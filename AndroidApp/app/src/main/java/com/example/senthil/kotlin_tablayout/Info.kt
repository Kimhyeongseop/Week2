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


        val id= intent.getStringExtra("id")
        val photo = intent.getStringExtra("photo")
        val pw = intent.getStringExtra("pw")
        val position= intent.getIntExtra("position", 100)

        text1?.text = id
        text2?.text = pw
        Glide.with(this).load(photo).into(image1!!)
//수정버튼
        edit = findViewById(R.id.edit)
        edit?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, sub::class.java)

            intent.putExtra("id",id)
            intent.putExtra("photo",photo)
            intent.putExtra("pw",pw)
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

            val id = data!!.getStringExtra("id")
            val photo= data!!.getStringExtra("photo")
            val pw = data!!.getStringExtra("pw")
            val position=data!!.getIntExtra("position",100)

            text1?.text =id
            text2?.text = pw
            //Glide.with(this).load(str2).into(image1!!)

            edit = findViewById(R.id.edit)
            edit?.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, sub::class.java)

                intent.putExtra("id",id)
                intent.putExtra("photo",photo)
                intent.putExtra("pw",pw)
                intent.putExtra("position",position)

                startActivityForResult(intent,3)
            })


            btn = findViewById(R.id.back)
            btn?.setOnClickListener(View.OnClickListener {
                val intent = Intent()
                intent.putExtra("id",id)
                intent.putExtra("photo",photo)
                intent.putExtra("pw", pw)
                intent.putExtra("position",position)
                setResult(RESULT_OK, intent)
                finish()
            })


        } else {
            text1 = findViewById(R.id.textView)
            image1 = findViewById(R.id.imageView)
            text2 = findViewById(R.id.textView2)


            val id= data!!.getStringExtra("id")
            val photo= data!!.getStringExtra("photo")
            val pw = data!!.getStringExtra("pw")
            val position=data!!.getIntExtra("position",100)


            text1?.text = id
            text2?.text = pw
            Glide.with(this).load(photo).into(image1!!)

            edit = findViewById(R.id.edit)
            edit?.setOnClickListener(View.OnClickListener {
                val intent = Intent(this, sub::class.java)
                intent.putExtra("id",id)
                intent.putExtra("photo",photo)
                intent.putExtra("pw",pw)
                intent.putExtra("position",position)


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