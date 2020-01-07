package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val initial = findViewById<ImageView>(R.id.splash_image)
        Glide.with(this).load(R.drawable.anigif).into(initial)

        val sleep = thread_sleep(this)
        sleep.start()

    }

    inner class thread_sleep(val theAct : Activity) : Thread() {
        override fun run()
        {
            try {
                Thread.sleep(4000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            startActivity(Intent(theAct, MainActivity::class.java))
            finish()
        }
    }
}