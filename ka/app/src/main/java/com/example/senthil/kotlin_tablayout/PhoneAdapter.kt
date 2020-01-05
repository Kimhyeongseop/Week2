package com.example.senthil.kotlin_tablayout

import android.app.AlertDialog
import android.app.Dialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.security.AccessController.getContext

class CustomAdapter(val arrayList: ArrayList<User>, val context: Context) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CustomViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phone_list, parent, false)
        val holder = CustomViewHolder(view)

        return holder
    }
    interface ItemClick{
        fun onClick(view:View, position: Int)
    }
    var itemClick: ItemClick?=null
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(arrayList[position])
        if (itemClick!=null)
        {
            holder?.itemView?.setOnClickListener{v->
                itemClick?.onClick(v,position)
            }
        }
    }

    override fun getItemCount() : Int { return arrayList.size }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val _name : TextView? = itemView.findViewById<TextView>(R.id.tv_name)
        val _number : TextView? = itemView.findViewById<TextView>(R.id.tv_number)
        val _profile: ImageView? = itemView.findViewById<ImageView>(R.id.iv_profile)


        fun bind(user: User)
        {
            _name?.text = user.name
            _number?.text = user.pw
            Glide.with(context).load(user.profile).into(_profile!!)
        }
    }
}