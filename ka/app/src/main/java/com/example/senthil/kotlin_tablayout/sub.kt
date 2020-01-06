package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class sub : Activity() {
    private var btn_move: Button? = null
    private var btn: Button? = null
    private var first_name: EditText? = null
    private var phone_number: EditText? = null

    private var id : String? = null
    private var photo : String?= null
    private var pw : String?= null
    private var position : Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        first_name = findViewById(R.id.first_name)
        phone_number = findViewById(R.id.phone_number)
        btn_move = findViewById(R.id.btn_move)
        btn = findViewById(R.id.btn)


        id= intent.getStringExtra("id") // 원래 아이디
        photo= intent.getStringExtra("photo")
        pw = intent.getStringExtra("pw")
        position = intent.getIntExtra("position",100)


    //저장버튼
        btn_move?.setOnClickListener(View.OnClickListener {
            val id = first_name?.getText().toString()
            val pw = phone_number?.getText().toString()
            val intent = Intent()
            intent.putExtra("id", id) // 바꾼 아이디
            intent.putExtra("photo", photo)
            intent.putExtra("pw", pw) // 바꾼 번호
            intent.putExtra("position", position!!)
            setResult(3, intent)
            finish()
        })
    //취소버튼
        btn?.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.putExtra("id", id)
            intent.putExtra("photo", photo)
            intent.putExtra("pw", pw)
            intent.putExtra("position", position!!)
            setResult(2, intent)

            finish()
        })
    }

}