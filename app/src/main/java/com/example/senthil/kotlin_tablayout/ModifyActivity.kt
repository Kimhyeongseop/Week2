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
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.account_item_adder.*
import kotlinx.android.synthetic.main.account_item_editor.*
import kotlinx.android.synthetic.main.activity_modify.*
import java.util.zip.Inflater

class ModifyActivity : AppCompatActivity() {
    private var updated_money_flag = false
    private var updated_usage_flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.account_item_editor)

        val intent = getIntent()

        //200101
        val money = this.editor_money
        val usage = this.editor_usage

        money.setText(intent.getStringExtra("money"))
        usage.setText(intent.getStringExtra("usage"))

        val original_consumption = intent.getParcelableExtra<Consumption>("consumption")
        val original_money = original_consumption.money
        val original_usage = original_consumption.usage

        val original_radio = if(original_consumption.pm == 1) editor_income.id else editor_outcome.id

        //Log.e("original_radio", "${this.editor_radioGroup.checkedRadioButtonId}")

        this.editor_radioGroup.check(original_radio)


        //val tmp_time = intent.getStringExtra("time") //"YYYY/MM/DD_HH:MM"
        val consumption = intent.getParcelableExtra<Consumption>("consumption")

        var hour = consumption.time!!.slice(IntRange(11, 12))
        var minute = consumption.time!!.slice(IntRange(14, 15))

        editor_spinner_hour.setSelection(Integer.parseInt(hour))
        editor_spinner_minute.setSelection(Integer.parseInt(minute))


        //END



        var inOrOut = false

        editor_money.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updated_money_flag = true
                Log.e("MONEY", s.toString())
            }
        })

        editor_usage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updated_usage_flag = true
                Log.e("USAGE", s.toString())
            }
        })

        editor_radioGroup.setOnCheckedChangeListener { editor_radioGroup, i ->
            when(i) {
                R.id.editor_income -> {
                    inOrOut = true
                    Log.e("INCOME", "$inOrOut, ${editor_radioGroup.checkedRadioButtonId}")
                }
                R.id.editor_outcome -> {
                    inOrOut = false
                    Log.e("INCOME", "$inOrOut, ${editor_radioGroup.checkedRadioButtonId}")
                }
            }
        }

        editor_spinner_hour.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                hour = editor_spinner_hour.getItemAtPosition(position)!!.toString()
            }
        }

        editor_spinner_minute.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                minute = editor_spinner_minute.getItemAtPosition(position)!!.toString()
            }
        }

        edit_save_account_item.setOnClickListener {
            val intent = Intent()

            Log.e("MONEEEEEY", "${editor_money?.text.toString()} and $original_money")
            Log.e("USAAAAAGE", "${editor_usage?.text.toString()} and $original_usage")
            val id = consumption.id
            val money = if(updated_money_flag) Integer.parseInt(editor_money?.text.toString()) else Integer.parseInt(original_money.toString())
            val pm = if(inOrOut) 1 else -1
            val usage = if(updated_usage_flag) editor_usage?.text.toString() else original_usage

            //val time = consumption.time

            val year = consumption.time.toString().slice(IntRange(0, 3))
            val month = consumption.time.toString().slice(IntRange(5, 6))
            val day = consumption.time.toString().slice(IntRange(8, 9))
            val time = "$year/$month/$day $hour:$minute:00"

            val consumption = Consumption(id, money, pm, usage, time)
            intent.putExtra("updateConsumption", consumption)
            setResult(Activity.RESULT_OK, intent)

            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }

        edit_delete_account_item.setOnClickListener {
            val intent = Intent()

            val id = consumption.id
            val money = consumption.money
            val pm = if(inOrOut) 1 else -1
            val usage = editor_usage?.text.toString()
            val time = consumption.time

            val consumption = Consumption(id, money, pm, usage, time)
            intent.putExtra("deleteConsumption", consumption)
            setResult(Activity.RESULT_FIRST_USER, intent)

            finish()
        }
    }
}