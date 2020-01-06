package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.*

private lateinit var database: DatabaseReference


class Who : Activity() {
    private var name:TextView?=null
    private var email:TextView?=null
    private var money:TextView?=null
    private var di:TextView?=null
    private var bch:TextView?=null
    private var bsv:TextView?=null
    private var btc:TextView?=null
    private var eos:TextView?=null
    private var eth:TextView?=null
    private var ltc:TextView?=null

    private var kemail: String? = null
    private var key:Auth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.who)
        name= findViewById(R.id.name)
        email= findViewById(R.id.email)
        money= findViewById(R.id.money)
        di= findViewById(R.id.di)
        bch= findViewById(R.id.bch)
        bsv= findViewById(R.id.bsv)
        btc= findViewById(R.id.btc)
        eos= findViewById(R.id.eos)
        eth= findViewById(R.id.eth)
        ltc= findViewById(R.id.ltc)

        kemail=intent.getStringExtra("email")

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
                        bch?.text=key?.BCH.toString()
                        bsv?.text=key?.BSV.toString()
                        btc?.text=key?.BTC.toString()
                        eos?.text=key?.EOS.toString()
                        eth?.text=key?.ETH.toString()
                        ltc?.text=key?.LTC.toString()

                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("TAG",  "@@@@ ERROR while get data from the database")
            }
        })

    }





}