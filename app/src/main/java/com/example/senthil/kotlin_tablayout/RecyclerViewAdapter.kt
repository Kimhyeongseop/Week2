package com.example.senthil.kotlin_tablayout

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_address.view.*

class RecyclerViewAdapter (val addressList: MutableList<Address>) :
                                RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //Log.e("TAG", "${addressList.size}")
        return addressList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(addressList[position])
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val _image : ImageView? = itemView.findViewById(R.id.tv_image)
        val _name: TextView? = itemView.findViewById(R.id.tv_name)
        val _phoneNumber: TextView? = itemView.findViewById(R.id.tv_phone_number)


        fun bind (address: Address) {
            _phoneNumber?.text = address.number
            _name?.text = address.name
        }
    }
}