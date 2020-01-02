package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class GridViewAdapter : BaseAdapter
{
    var mContext: Context

    //val imageIDs = arrayOf (R.drawable.image00, R.drawable.image01, R.drawable.image02, R.drawable.image03, R.drawable.image04)

    constructor(c: Context) { mContext = c;}

    /*fun getNum =
    var tmpList = GalleryManager(mContext).getAllPhotoPathList()*/
    var numOfImages: Int = 20
    override fun getCount(): Int { return numOfImages /*imageIDs.size*/ }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /*START*/
        val mPhotoList = GalleryManager(mContext).getAllPhotoPathList()

        var inflator = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var imageView = inflator.inflate(R.layout.item_gallery, null)

        var imView: ImageView = imageView.findViewById(R.id.imageView1)

        var path = mPhotoList[position].imgPath
        Glide.with(imageView.context).load(path).into(imView)
        //imageView.layoutParams = LinearLayout.LayoutParams(100, 100)

        var imgView: ImageView = imageView.findViewById<ImageView>(R.id.imageView1)
        imgView.setOnClickListener(View.OnClickListener
        {
            val intenting = Intent(mContext, GalleryFullImage::class.java)
            intenting.putExtra("path", path)
            startActivity(mContext, intenting, null)
        })
        /*END*/

/*
        var image: ItemData = ItemData(imageIDs[position])

        var inflator = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var imageView = inflator.inflate(R.layout.item_gallery, null)
        imageView.imageView1.setImageResource(image.imageFile!!)
        //imageView.layoutParams = LinearLayout.LayoutParams(100, 100)

        var imgView: ImageView = imageView.findViewById<ImageView>(R.id.imageView1)
        imgView.setOnClickListener(View.OnClickListener
        {
            val intenting = Intent(mContext, GalleryFullImage::class.java)
            intenting.putExtra("id", position)
            startActivity(mContext, intenting, null)
        })

       /* var imUri: Uri = Uri.parse(Environment.DIRECTORY_PICTURES + "/image00.jpg")
        Log.d(ContentValues.TAG, "############################## PATH : " + imUri.toString())
        Glide.with(mContext).load(imUri.toString()).into(imgView)*/
*/
        return imageView
    }

    override fun getItemId(position: Int): Long
    {
        //return null
        return 0
    }

    override fun getItem(position: Int): Any
    {
        return 0
        //return imageIDs[position]
    }
}