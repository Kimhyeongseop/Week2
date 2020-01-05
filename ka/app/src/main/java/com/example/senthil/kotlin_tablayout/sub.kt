package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class sub : Activity() {
    private var btn_move: Button? = null
    private var btn: Button? = null
    private var first_name: EditText? = null
    private var phone_number: EditText? = null
    private var str1: String? = null
    private var str3: String? = null
    private var F1: String? = null
    private var F2: String? = null
    private var F3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        first_name = findViewById(R.id.first_name)
        phone_number = findViewById(R.id.phone_number)
        btn_move = findViewById(R.id.btn_move)
        F1= intent.getStringExtra("str1")
        F2= intent.getStringExtra("str2")
        F3 = intent.getStringExtra("str3")
        val position = intent.getIntExtra("position",100)


    //저장버튼
        btn_move?.setOnClickListener(View.OnClickListener {
            str1 = first_name?.getText().toString()
            str3 = phone_number?.getText().toString()
            val intent = Intent()
            intent.putExtra("str1", F1)
            intent.putExtra("po", str1)
            intent.putExtra("fn", str1)
            intent.putExtra("pn", str3)
            intent.putExtra("position", position)
            setResult(3, intent)
            finish()
        })
    //취소버튼
        btn = findViewById(R.id.btn)
        btn?.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.putExtra("str1", F1)
            intent.putExtra("str2", F2)
            intent.putExtra("str3", F3)
            intent.putExtra("position", position)
            setResult(2, intent)

            finish()
        })
    }

}