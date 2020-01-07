package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(val arrayList: ArrayList<Photo>, val context: Context) : RecyclerView.Adapter<ImageAdapter.CustomImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomImageViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        val holder = CustomImageViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CustomImageViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount() : Int { return arrayList.size }

    inner class CustomImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val _image: ImageView? = itemView.findViewById<ImageView>(R.id.imageView1)

        fun bind(photo: Photo)
        {
            Glide.with(context).load(photo.image).into(_image!!)
        }
    }
}