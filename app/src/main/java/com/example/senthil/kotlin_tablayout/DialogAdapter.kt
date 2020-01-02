package com.example.senthil.kotlin_tablayout

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_item.view.*

class DialogAdapter(val items : ArrayList<Consumption>, val click: (Consumption) -> Unit) : RecyclerView.Adapter<DialogAdapter.DialogHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_item, parent, false)
        return DialogHolder(view)
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: DialogHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener { click(items[position]) }
    }

    inner class DialogHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val _usage = view.findViewById<TextView>(R.id.item_dialog_usage)
        val _money = view.findViewById<TextView>(R.id.item_dialog_money)
        val _pm = view.findViewById<TextView>(R.id.plus_or_minus)

        fun bind (consumption: Consumption)
        {
            val tmp_pm = consumption.pm

            if (tmp_pm == 1) //income
            {
                _money.setTextColor(Color.parseColor("#038cfc"))
                _pm?.setTextColor(Color.parseColor("#038cfc"))
            }
            else //outcome
            {
                _money.setTextColor(Color.parseColor("#fc036f"))
                _pm?.setTextColor(Color.parseColor("#fc036f"))
            }

            _usage?.text = consumption.usage
            _money?.text = consumption.money.toString()

            //+ or -

            val pm_string : String
            if (tmp_pm == 1) { pm_string = "+"}
            else { pm_string = "-" }
            _pm?.text = pm_string
        }
    }
}