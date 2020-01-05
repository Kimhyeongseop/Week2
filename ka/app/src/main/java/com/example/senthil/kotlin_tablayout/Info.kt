package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.senthil.kotlin_tablayout.Fragment.PhoneFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_phone.view.*

class Info: Activity() {
    private var btn: Button? = null
    private var edit: Button? = null
    private var text1: TextView? = null
    private var text2: TextView? = null
    private var image1:ImageView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)

        text1 = findViewById(R.id.textView)
        image1 = findViewById(R.id.imageView)
        text2 = findViewById(R.id.textView2)


        val str1= intent.getStringExtra("n")
        val str2 = intent.getStringExtra("p")
        val str3 = intent.getStringExtra("w")
        val position= intent.getIntExtra("position", 100)

        text1?.text = str1
        text2?.text = str3
        Glide.with(this).load(str2).into(image1!!)
//수정버튼
        edit = findViewById(R.id.edit)
        edit?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, sub::class.java)

            intent.putExtra("str1",str1)
            intent.putExtra("str2",str2)
            intent.putExtra("str3",str3)
            intent.putExtra("position",position)

            startActivityForResult(intent,3)
        })

//저장 버튼
        btn = findViewById(R.id.back)
        btn?.setOnClickListener(View.OnClickListener {
            val dintent = Intent()
            setResult(RESULT_OK, dintent)
            finish()
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == 3) {

            val fn = data!!.getStringExtra("fn")
            val pn = data!!.getStringExtra("pn")
            val F1= data!!.getStringExtra("str1")
            val position=data!!.getIntExtra("position",100)

            text1?.text =fn
            text2?.text = pn
            //Glide.with(this).load(str2).into(image1!!)

            edit = findViewById(R.id.edit)
            edit?.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, sub::class.java)

                intent.putExtra("str1",fn)
                intent.putExtra("str2",pn)
                intent.putExtra("str3",F1)
                intent.putExtra("position",position)

                startActivityForResult(intent,3)
            })


            btn = findViewById(R.id.back)
            btn?.setOnClickListener(View.OnClickListener {
                val intent = Intent()
                intent.putExtra("str1",F1)
                intent.putExtra("fn", fn)
                intent.putExtra("pn", pn)
                intent.putExtra("position",position)
                setResult(RESULT_OK, intent)
                finish()
            })


        } else {
            text1 = findViewById(R.id.textView)
            image1 = findViewById(R.id.imageView)
            text2 = findViewById(R.id.textView2)


            val F1= data!!.getStringExtra("str1")
            val F2= data!!.getStringExtra("str2")
            val F3 = data!!.getStringExtra("str3")


            text1?.text = F1
            text2?.text = F3
            Glide.with(this).load(F2).into(image1!!)

            edit = findViewById(R.id.edit)
            edit?.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, sub::class.java)
                intent.putExtra("str1",F1)
                intent.putExtra("str3",F3)


                startActivityForResult(intent,3)
            })

            btn = findViewById(R.id.back)
            btn?.setOnClickListener(View.OnClickListener {
                val dintent = Intent()
                setResult(RESULT_OK, dintent)
                finish()
            })

        }
    }
}