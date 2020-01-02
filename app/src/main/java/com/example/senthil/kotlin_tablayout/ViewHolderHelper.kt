package com.example.senthil.kotlin_tablayout

import android.graphics.Color
import android.icu.util.Calendar
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_calendar.view.*


open class ViewHolderHelper(override val containerView: View, itemClick: (Int, Int, Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer