package com.example.senthil.kotlin_tablayout.Fragment

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.*
import kotlinx.android.synthetic.main.dialog_list.*

import kotlinx.android.synthetic.main.fragment_account_book.*
import java.util.*

class AccountBookFragment : Fragment() {
    lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        calendarAdapter = CalendarAdapter(this, (
            fun (year: Int, month: Int, day: Int)
            {
                val intent: Intent = Intent(this.context, Dialog::class.java)
                intent.putExtra("year", year)
                intent.putExtra("month", month)
                intent.putExtra("day", day)
                startActivity(intent)
            }))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account_book, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val baseCalendar = BaseCalendar()
        baseCalendar.initBaseCalendar { refreshCurrentMonth(it) }

        tv_prev_month?.setOnClickListener { calendarAdapter.changeToPrevMonth() }
        tv_next_month?.setOnClickListener { calendarAdapter.changeToNextMonth() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_calendar?.layoutManager = GridLayoutManager(this.context, BaseCalendar.DAYS_OF_WEEK)
        rv_calendar?.adapter = calendarAdapter
        rv_calendar?.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.HORIZONTAL))
        rv_calendar?.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

    }

    fun refreshCurrentMonth(calendar: Calendar) {
        val sdf = SimpleDateFormat("yyyy  MM", Locale.KOREAN)
        tv_current_month?.text = sdf.format(calendar.time)
    }

    override fun onStop() {
        super.onStop()

        calendarAdapter.notifyDataSetChanged()
    }
}
