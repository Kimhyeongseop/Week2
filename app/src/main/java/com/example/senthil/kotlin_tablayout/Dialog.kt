package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_item.*
import kotlinx.android.synthetic.main.dialog_list.*
import java.util.ArrayList

class Dialog : AppCompatActivity() {

    internal lateinit var db : DBHelper
    lateinit var dialogAdapter: DialogAdapter
    private var listConsumptions: List<Consumption> = ArrayList<Consumption>()

    /*private val items: ArrayList<Consumption> = arrayListOf(
            Consumption(1, 10000, 1, "jack", "2019/12/31 17:00"),
            Consumption(2, 6000, -1, "dinner", "2019/12/31 19:00"),
            Consumption(3, 2000, -1, "yogurt", "2019/12/31 19:30")
    )*/

    private var EDIT_REQUEST = 1
    private var ADD_REQUEST = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_list)

        val intent = getIntent()
        val year = intent.getIntExtra("year", 0)
        val month = intent.getIntExtra("month", 0)
        val day = intent.getIntExtra("day", 0)

        db = DBHelper(this)
        //val items = db.dbList

        val tmp_items = db.dbList

        //get items according to date
        var items : ArrayList<Consumption> = arrayListOf()

        for (it in tmp_items)
        {
            //format: "YYYY/mm/dd ... "
            var date_string = it.time

            var date_month = Integer.parseInt(date_string!!.slice(IntRange(5, 6)))
            var date_day = Integer.parseInt(date_string!!.slice(IntRange(8, 9)))

            when (month == date_month && day == date_day)
            {
                true -> items.add(it)
            }
        }

        // after constructing db, use listConsumptions
        dialogAdapter = DialogAdapter(items, (
                fun(consumption : Consumption) {
                    val intent = Intent(this, ModifyActivity::class.java)

                    //200101
                    intent.putExtra("money", consumption.money.toString())
                    intent.putExtra("usage", consumption.usage.toString())
                    intent.putExtra("time", consumption.time.toString())
                    //END

                    intent.putExtra("consumption", consumption)
                    startActivityForResult(intent, EDIT_REQUEST)
                }))

        refreshData()

        dialog_list_month.setText(month.toString())
        dialog_list_day.setText(day.toString())

        //For FAB
        val dialog_FAB = findViewById<FloatingActionButton>(R.id.dialog_fab)
        dialog_FAB.setOnClickListener {
            val next = Intent(this, AccountAdder::class.java)
            next.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            next.putExtra("month", month)
            next.putExtra("day", day)
            next.putExtra("year", year)
            next.putExtra("max_id", db.dbList.size)
            startActivityForResult(next, ADD_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                // db.addConsumption~~
                val addedConsumption = data?.getParcelableExtra<Consumption>("addConsumption")
                db.addConsumption(addedConsumption!!)
                refreshData()
            }
        }

        else if (requestCode == EDIT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                // db.updateConsumption~~
                val updatedConsumption = data?.getParcelableExtra<Consumption>("updateConsumption")
                db.updateConsumption(updatedConsumption!!)
                refreshData()
            }
            else if (resultCode == Activity.RESULT_FIRST_USER){
                // db.deleteConsumption~~
                val deletedConsumption = data?.getParcelableExtra<Consumption>("deleteConsumption")
                db.deleteConsumption(deletedConsumption!!)
                refreshData()
                Log.e("DELETE!!", deletedConsumption?.usage.toString())
            }
        }
    }

    private fun refreshData()
    {
        rv_dialog?.layoutManager = LinearLayoutManager(baseContext)
        rv_dialog?.adapter = dialogAdapter
        listConsumptions = db.dbList
    }

    override fun onRestart()
    {
        super.onRestart()
        val intent = getIntent()
        finish()
        startActivity(intent)
    }

}