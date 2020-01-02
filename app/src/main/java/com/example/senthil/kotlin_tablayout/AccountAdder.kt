package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.account_item_adder.*
import kotlinx.android.synthetic.main.account_item_editor.*
import kotlinx.android.synthetic.main.dialog_list.*
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class AccountAdder : AppCompatActivity() {
    private var updated_money_flag = false
    private var updated_usage_flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_item_adder)

        val intent = getIntent()
        val year = intent.getIntExtra("year", 0)
        val month = intent.getIntExtra("month", 0)
        val day = intent.getIntExtra("day", 0)
        val max_id = intent.getIntExtra("max_id", 0)
        var hour : String? = null
        var minute : String? = null

        adder_date_month.setText(month.toString())
        adder_date_day.setText(day.toString())

        var month_string = if (month < 10) "0" + month.toString() else month.toString()
        var day_string = if (day < 10) "0" + day.toString() else day.toString()


        var inOrOut = false

        adder_money.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updated_money_flag = true
                Log.e("MONEY", s.toString())
            }
        })

        adder_usage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updated_usage_flag = true
                Log.e("USAGE", s.toString())
            }
        })

        adder_radioGroup.setOnCheckedChangeListener { adder_radioGroup, i ->
            when(i) {
                R.id.adder_income -> {
                    inOrOut = true
                    Log.e("INCOME", "$inOrOut")
                }
                R.id.adder_outcome -> {
                    inOrOut = false
                    Log.e("INCOME", "$inOrOut")
                }
            }
        }

        adder_spinner_hour.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                hour = adder_spinner_hour.getItemAtPosition(position)!!.toString()
            }
        }

        adder_spinner_minute.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                minute = adder_spinner_minute.getItemAtPosition(position)!!.toString()
            }
        }

        // add
        add_new_account_item.setOnClickListener {
            val intent = Intent()

            val id = max_id + 1
            val money = Integer.parseInt(adder_money?.text.toString())
            val pm = if(inOrOut) 1 else -1
            val usage = adder_usage?.text.toString()

            //val zone = TimeZone.getTimeZone("Asia/Seoul")
            //val cal = GregorianCalendar(zone)
            //val form = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            //val time = form.format(cal.getTime())
            val time =  "$year/$month_string/$day_string $hour:$minute:00"

            //Log.e("asdfsadfsadfad", "$time, $_time")

            val consumption = Consumption(id, money, pm, usage, time)
            intent.putExtra("addConsumption", consumption)
            setResult(Activity.RESULT_OK, intent)

            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }
    }



    //액티비티 종료 될 때 애니메이션 없애는 부분.
    // 근데 종료시에는 애니메이션이 있는게 나을거같아서 주석처리함.
    /*override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }*/
}