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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        first_name = findViewById(R.id.first_name)
        phone_number = findViewById(R.id.phone_number)
        btn_move = findViewById(R.id.btn_move)
        btn_move?.setOnClickListener(View.OnClickListener {
            str1 = first_name?.getText().toString()
            str3 = phone_number?.getText().toString()
            val intent = Intent()
            intent.putExtra("fn", str1)
            intent.putExtra("pn", str3)
            setResult(RESULT_OK, intent)
            finish()
        })
        btn = findViewById(R.id.btn)
        btn?.setOnClickListener(View.OnClickListener {
            val dintent = Intent()
            setResult(RESULT_OK, dintent)
            finish()
        })
    }
}