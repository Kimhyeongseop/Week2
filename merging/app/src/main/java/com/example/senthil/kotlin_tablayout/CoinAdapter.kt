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

class CoinAdapter(val ItemList: ArrayList<Coin>, val context : Context) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_list, parent, false)
        val holder = CoinViewHolder(view)

        return holder
    }


    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount() : Int { return ItemList.size }


    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val _number : TextView? = itemView.findViewById<TextView>(R.id.number)
        val _total_price : TextView? = itemView.findViewById<TextView>(R.id.total_price)
        val _coin_image: ImageView? = itemView.findViewById<ImageView>(R.id.coin_image)

        fun bind(coin: Coin)
        {
            _number?.text = coin.number.toString()
            _total_price?.text = coin.total_price
            Glide.with(context).load(coin.coin_image).into(_coin_image!!)

        }
    }

}