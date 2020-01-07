package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_tab3.view.*
import kotlinx.android.synthetic.main.who.*

private lateinit var database: DatabaseReference
private lateinit var Prices : DatabaseReference


class Who : Activity() {
    private var name:TextView?=null
    private var email:TextView?=null
    private var money:TextView?=null
    private var di:TextView?=null

    private var kemail: String? = null
    private var key:Auth?=null
    private var numBCH:Int?=null
    private var numBSV:Int?=null
    private var numBTC:Int?=null
    private var numEOS:Int?=null
    private var numETH:Int?=null
    private var numLTC:Int?=null
    private var k:Int?=null


    private var ItemList = ArrayList<Coin>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.who)
        name= findViewById(R.id.name)
        email= findViewById(R.id.email)
        money= findViewById(R.id.money)
        di= findViewById(R.id.di)
        kemail=intent.getStringExtra("email")

        val manager = LinearLayoutManager(this)
        val adapter = CoinAdapter(ItemList, this)
        database = FirebaseDatabase.getInstance().getReference("Auth")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot)
            {
                for (snapshot in shot.getChildren()) {
                    var auth = snapshot.getValue(Auth::class.java)
                    if (auth!!.email==kemail.toString()) { //접속자 이름과 같은 이름을 찾아야함
                        key=auth

                        name?.text=key?.name
                        email?.text=key?.email
                        money?.text=key?.money.toString()
                        di?.text=key?.di.toString()
                        numBCH=key?.BCH
                        numBSV=key?.BSV
                        numBTC=key?.BTC
                        numEOS=key?.EOS
                        numETH=key?.ETH
                        numLTC=key?.LTC

                        lc.adapter=adapter
                        lc.layoutManager=manager

                        Prices = FirebaseDatabase.getInstance().getReference("Prices")

                        Prices.addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(shot: DataSnapshot) {
                                ItemList.clear()
                                for (snapshot in shot.children) //e.g) snapshot == BTC
                                {
                                    var image = snapshot.child("icon").value.toString()
                                    var key= snapshot.key.toString()
                                    var n="num"+key
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
                                    if (k!=0) {
                                        var total_price = (snapshot.child("price").value.toString().toDouble() * k!!).toString() + "￦"
                                        var addMe = Coin(image, k, total_price)
                                        ItemList.add(addMe)
                                    }
                                }
                                adapter.notifyDataSetChanged()
                            }
                            override fun onCancelled(p0: DatabaseError) {
                                Log.e("#### TAG ####: ", " ERROR '")
                            }
                        })







                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("TAG",  "@@@@ ERROR while get data from the database")
            }
        })




    }





}