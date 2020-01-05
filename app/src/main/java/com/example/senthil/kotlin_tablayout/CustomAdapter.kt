package com.example.senthil.kotlin_tablayout

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(val arrayList: ArrayList<User>, val context: Context) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CustomViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phone_list, parent, false)
        val holder = CustomViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount() : Int { return arrayList.size }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val _name : TextView? = itemView.findViewById<TextView>(R.id.tv_name)
        val _number : TextView? = itemView.findViewById<TextView>(R.id.tv_number)

        fun bind(user: User)
        {
            _name?.text = user.name
            _number?.text = user.pw
        }
    }
}