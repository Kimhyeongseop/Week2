package com.example.senthil.kotlin_tablayout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide

class GalleryFullImage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        this.overridePendingTransition(R.layout.fade_in, R.layout.fade_out)
        setContentView(R.layout.full_image)
        val intent: Intent = getIntent()
        //val adapting = GridViewAdapter(this)
        val imageView : ImageView = findViewById(R.id.full_image)

        val path = intent.getStringExtra("path")
        Glide.with(imageView.context).load(path).into(imageView)
        //imageView.setImageResource(adapting.imageIDs[position])
    }

    override fun finish()
    {
        super.finish()
        this.overridePendingTransition(R.layout.fade_in, R.layout.fade_out)
    }
}