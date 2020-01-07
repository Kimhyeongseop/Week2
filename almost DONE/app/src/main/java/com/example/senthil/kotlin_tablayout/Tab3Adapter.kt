package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Tab3Adapter(val ListViewItemList: ArrayList<Tab3CoinListViewItem>, val context : Context) : RecyclerView.Adapter<Tab3Adapter.Tab3ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tab3ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        val holder = Tab3ViewHolder(view)

        return holder
    }


    override fun onBindViewHolder(holder: Tab3ViewHolder, position: Int) {
        holder.bind(ListViewItemList[position])
    }

    override fun getItemCount() : Int { return ListViewItemList.size }


    inner class Tab3ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val _name : TextView? = itemView.findViewById<TextView>(R.id.item_coin_name)
        val _price : TextView? = itemView.findViewById<TextView>(R.id.item_coin_price)
        val _image: ImageView? = itemView.findViewById<ImageView>(R.id.item_coin_image)

        fun bind(coin: Tab3CoinListViewItem)
        {
            _name?.text = coin.coin_name
            _price?.text = coin.coin_price
            Glide.with(context).load(coin.coin_image).into(_image!!)

            itemView.setOnClickListener{
                val intent = Intent(context, Tab3CoinInfo::class.java)
                intent.putExtra("coin_name", coin.coin_name) //coin_name : String?
                intent.putExtra("coin_current_price", coin.coin_price) //coin_current_price : String?
                startActivity(context, intent, null)
            }
        }
    }

}