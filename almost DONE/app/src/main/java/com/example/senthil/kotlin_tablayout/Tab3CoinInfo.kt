package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aachartmodel.aainfographics.AAInfographicsLib.AAChartConfiger.*
import com.aachartmodel.aainfographics.aainfographicsLib.aachartConfiger.AAChartView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.coin_buy.*
import kotlinx.android.synthetic.main.more_info_coin.*
import java.lang.Math.round

class Tab3CoinInfo : Activity()
{
    //for real-time price data!
    private val priceRef = FirebaseDatabase.getInstance().getReference("Prices")
    private lateinit var database: DatabaseReference

    //for graph!
    private lateinit var history : DatabaseReference

    //for BUY and SELL
    private lateinit var auth: DatabaseReference
    private var updated_buy_flag = false
    private var updated_sell_flag = false
    private var numBCH:Int?=null
    private var numBSV:Int?=null
    private var numBTC:Int?=null
    private var numEOS:Int?=null
    private var numETH:Int?=null
    private var numLTC:Int?=null
    private var money:Double?=null
    private var k:Int?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_info_coin)

        //get info. from previous fragment : Tab3Fragment
        val intent = getIntent()
        val coin_name_view = findViewById<TextView>(R.id.coin_name)
        val coin_price_view = findViewById<TextView>(R.id.coin_price)

        val name = intent.getStringExtra("coin_name")
        var price = intent.getStringExtra("coin_current_price")
        coin_name_view.text = name
        coin_price_view.text = price

        database = FirebaseDatabase.getInstance().getReference("Prices")
        var childData = database.child(name)  //e.g) childData : BCH

        var price_now = "tmp"
        //we need real-time data for this, not something intented!
        childData.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot) {
                price_now = shot.child("price").value.toString()
                coin_price_view.text = price_now + "￦"
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("#### TAG ####: ", " ERROR ")
            }
        })

        //for getting daily history data!
        var dates = Array<String>(30, {"tmp dates"})
        var total_volumes = Array<Any>(30, {-1})

        history = FirebaseDatabase.getInstance().getReference("DailyHistory")
        Log.d("@@@@", name)
        var companyData = history.child(name) // e.g.) companyData : BCH
        companyData.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot) {
                var i = 0
                for (snapshot in shot.getChildren())
                {
                    var tmp = snapshot.getValue(Tab3CoinHistory::class.java)

                    var volume_doulbe = tmp!!.total_volume!!.toDouble()

                    dates.set(i, tmp!!.date!!)
                    total_volumes.set(i, volume_doulbe)

                    i = i + 1
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("#### TAG ####: ", " ERROR in 'Tab3Adapter'")
            }
        })

        //for drawing graph!!
        val aaChartView = findViewById<AAChartView>(R.id.coin_graph)

        fun configureAreaChartThreshold(): AAChartModel {
            val gradientColorDic1 = AAGradientColor.linearGradient(
                    AALinearGradientDirection.ToBottom,
                    "rgba(30, 144, 255,1)", //DodgerBlue, alpha 透明度 1
                    "rgba(30, 144, 255,0.1)"//DodgerBlue, alpha 透明度 0.1
            )

            val tmpList = arrayListOf<Double>(1.0)

            return AAChartModel()
                    .chartType(AAChartType.Area)
                    .title("")
                    .yAxisTitle("")//设置Y轴标题
                    .yAxisGridLineWidth(0f)
                    .categories(dates)
                    .dataLabelsEnabled(false)//是否显示值
                    .markerRadius(8f)
                    .markerSymbol(AAChartSymbolType.Circle)
                    .markerSymbolStyle(AAChartSymbolStyleType.InnerBlank)
                    .legendEnabled(false)
                    .series(arrayOf(
                            AASeriesElement()
                                    .threshold(-200f)
                                    .data(total_volumes)
                                    .lineWidth(6f)
                                    .color("rgba(30, 144, 255,1)")
                                    .fillColor(gradientColorDic1)
                    )
                    )
        }

        val aaChartModel = configureAreaChartThreshold() //chart!

        aaChartView.aa_drawChartWithChartModel(aaChartModel)


        //for BUY
        // Get the layout inflater
        val dialogView_buy = layoutInflater.inflate(R.layout.coin_buy, null)
        val buy_how_many_text = dialogView_buy.findViewById<EditText>(R.id.buy_how_many)
        val buy_show_view = dialogView_buy.findViewById<TextView>(R.id.buy_show)
        //get what the user inserted...
        var user_input_buy = 0
        buy_how_many_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.d("##########buy : ", s.toString())
                if (s.toString() != "")
                {
                    user_input_buy = Integer.parseInt(s.toString())
                    var current_price = price_now.toDouble()

                    buy_show_view.text = (user_input_buy * current_price).toString() + "￦"
                }
            }
            override fun afterTextChanged(s: Editable?) {  updated_buy_flag = true  }
        })

        //to update firebase
        auth = FirebaseDatabase.getInstance().getReference("Auth")

        //first of all, we need to know who is our current user!
        var user = FirebaseAuth.getInstance().currentUser //wow!
        var email_findMe= user!!.email
        var user_name : String = "didn't find"

        auth.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot) {
                for (snapshot in shot.children) {
                    var who_are_you = snapshot.getValue(Auth::class.java)
                    if (who_are_you!!.email.toString() == email_findMe)
                    {
                        var Key=snapshot.getValue(Auth::class.java)
                        user_name = snapshot.key.toString()
                        money=Key?.money
                        numBCH=Key?.BCH
                        numBSV=Key?.BSV
                        numBTC=Key?.BTC
                        numEOS=Key?.EOS
                        numETH=Key?.ETH
                        numLTC=Key?.LTC
                        var n="num"+name
                        if (n=="numBCH"){
                            k=numBCH
                        }
                        else if (n=="numBSV"){
                            k=numBSV
                        }
                        else if (n=="numBTC"){
                            k=numBTC
                        }
                        else if (n=="numEOS"){
                            k=numEOS
                        }
                        else if (n=="numETH"){
                            k=numETH
                        }
                        else if (n=="numLTC"){
                            k=numLTC
                        }

                    }
                }
            }
            override fun onCancelled(p0: DatabaseError) {
                Log.e("#### TAG ####: ", " ERROR in 'Tab3CoinInfo'")
            }
        })// finally, we can configure who is whom
        //let's add our data!
        coin_buy.setOnClickListener {
                //"매수" 버튼 눌렀을 때!
                Log.d("@@@@@", "CLICKED")
                val builder = AlertDialog.Builder(this)
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView_buy)
                        // Add action buttons\
                        // 진짜로 살 때!
                        .setPositiveButton(R.string.really_buy) { dialog, id ->
                            if (money!! - user_input_buy.toDouble() * price_now.toDouble() < 0) {
                                Toast.makeText(applicationContext, "불가능", Toast.LENGTH_SHORT).show()
                            } else {
                                auth.child(user_name).child("money").setValue(money!! - user_input_buy.toDouble() * price_now.toDouble())
                                auth.child(user_name).child(name).setValue(k!! + user_input_buy)
                            }
                        }
                        .setNegativeButton(R.string.cancel) { dialog, id ->
                            dialog.cancel()
                        }

                builder.show()
        }

        //for SELL
        // Get the layout inflater
        val dialogView_sell = layoutInflater.inflate(R.layout.coin_sell, null)
        val sell_how_many_text = dialogView_sell.findViewById<EditText>(R.id.sell_how_many)
        val sell_show_view = dialogView_sell.findViewById<TextView>(R.id.sell_show)
        //get what the user inserted...
        var user_input_sell = 0
        sell_how_many_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s.toString() != "")
                {
                    user_input_sell = Integer.parseInt(s.toString())
                    var current_price = price_now.toDouble()

                    sell_show_view.text = (user_input_sell * current_price).toString() + "￦"
                }
            }
            override fun afterTextChanged(s: Editable?) {  updated_sell_flag = true  }
        })
            //let's add our data!

            coin_sell.setOnClickListener {

                //"매도" 버튼 눌렀을 때!
                Log.d("@@@@@", "CLICKED")
                val builder = AlertDialog.Builder(this)

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView_sell)
                        // Add action buttons\
                        // 진짜로 팔 때!
                        .setPositiveButton(R.string.really_sell) { dialog, id ->
                            if (k!! - user_input_buy < 0) {
                                Toast.makeText(applicationContext, "불가능", Toast.LENGTH_SHORT).show()
                            } else {
                                auth.child(user_name).child("money").setValue(money!! + user_input_sell.toDouble() * price_now.toDouble())
                                auth.child(user_name).child(name).setValue(k!! - user_input_sell)
                            }
                        }
                                    .setNegativeButton(R.string.cancel) { dialog, id ->
                                        dialog.cancel()
                        }

                builder.show()
            }
    }
}