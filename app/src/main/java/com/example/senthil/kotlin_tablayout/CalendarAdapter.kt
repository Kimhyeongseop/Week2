package com.example.senthil.kotlin_tablayout

import android.graphics.Color
import android.icu.util.Calendar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.Fragment.AccountBookFragment
import kotlinx.android.synthetic.main.item_calendar.view.*


class CalendarAdapter(private val mainActivity: AccountBookFragment, val itemClick: (Int, Int, Int) -> Unit) : RecyclerView.Adapter<ViewHolderHelper>() {

    private val baseCalendar = BaseCalendar()

    init {
        baseCalendar.initBaseCalendar { refreshView(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHelper {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar, parent, false)

        return ViewHolderHelper(view, itemClick)
    }

    override fun getItemCount(): Int {
        return BaseCalendar.LOW_OF_CALENDAR * BaseCalendar.DAYS_OF_WEEK
    }

    override fun onBindViewHolder(holder: ViewHolderHelper, position: Int) {
        val year = baseCalendar.calendar.get(Calendar.YEAR)
        var month = baseCalendar.calendar.get(Calendar.MONTH) + 1
        var day = baseCalendar.data[position]

        if (position % BaseCalendar.DAYS_OF_WEEK == 0)
            holder.containerView.tv_date.setTextColor(Color.parseColor("#ff1200"))
        else holder.containerView.tv_date.setTextColor(Color.parseColor("#676d6e"))

        if (position < baseCalendar.prevMonthTailOffset) {
            holder.containerView.tv_date.alpha = 0.3f
            month --
        }
        else if (position >= baseCalendar.prevMonthTailOffset + baseCalendar.currentMonthMaxDate) {
            holder.containerView.tv_date.alpha = 0.3f
            month ++
        }
        else holder.containerView.tv_date.alpha = 1f

        if (month == 0) month = 12
        if (month == 13) month = 1

        holder.containerView.tv_date.text = baseCalendar.data[position].toString()

        holder.containerView.setOnClickListener { itemClick(year, month, day) }


        /**
         * to get data from the DB
         */
        val db = DBHelper(mainActivity.requireContext())
        val consumptionList = db.dbList

        var sum_income : Int = 0
        var sum_outcome : Int = 0
        var sum_total : Int

        for (it in consumptionList)
        {
            //format: "YYYY/mm/dd ... "
            var date_string = it.time

            var date_month = Integer.parseInt(date_string!!.slice(IntRange(5, 6)))
            var date_day = Integer.parseInt(date_string!!.slice(IntRange(8, 9)))

            //check date
            when (month == date_month && day == date_day)
            {
                true -> when(it.pm == 1) //is it income?
                {
                    true -> sum_income += it.money!!
                    false -> sum_outcome += it.money!!
                }
            }
        }

        sum_total = sum_income - sum_outcome

        //set the view text
        holder.containerView.tv_income.text = "+" + sum_income.toString()
        holder.containerView.tv_outcome.text = "-" + sum_outcome.toString()
        holder.containerView.tv_total.text = sum_total.toString()


    }

    fun changeToPrevMonth() {
        baseCalendar.changeToPrevMonth { refreshView(it) }
    }

    fun changeToNextMonth() {
        baseCalendar.changeToNextMonth { refreshView(it) }
    }

    private fun refreshView(calendar: Calendar) {
        notifyDataSetChanged()

        mainActivity.refreshCurrentMonth(calendar)

    }
}