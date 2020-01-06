package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.*

class Tab3CoinInfo : Activity()
{
    //for real-time price data!
    private val priceRef = FirebaseDatabase.getInstance().getReference("Prices")
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_info_coin)

        //get info. from previous fragment : Tab3Fragment
        val intent = getIntent()
        val coin_name_view = findViewById<TextView>(R.id.tmp_coin_name)
        val coin_price_view = findViewById<TextView>(R.id.tmp_coin_price)

        val name = intent.getStringExtra("coin_name")
        var price = intent.getStringExtra("coin_current_price")
        coin_name_view.text = name
        coin_price_view.text = price

        database = FirebaseDatabase.getInstance().getReference("Prices")
        var childData = database.child(name)

        //we need real-time data for this, not something intented!
        childData.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(shot: DataSnapshot) {
                var price_new = shot.child("price").value.toString()
                coin_price_view.text = price_new + "￦"
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("#### TAG ####: ", " ERROR in 'Tab3Adapter'")
            }
        })

    }
}