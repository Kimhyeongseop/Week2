package com.example.senthil.kotlin_tablayout

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "ACCOUNTBOOK.db"

        private val TABLE_NAME = "ACCOUNT"
        private val ID = "Id"
        private val MONEY = "Money"
        private val PM = "Pm"
        private val USAGE = "Usage"
        private val TIME = "Time"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME" +
                "($ID INTEGER PRIMARY KEY, $MONEY INTEGER, $PM INTEGER, $USAGE TEXT, $TIME TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    val dbList: ArrayList<Consumption>
        get() {
            val listConsumption = ArrayList<Consumption>()
            val selectQueryHandler = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQueryHandler, null)

            if (cursor.moveToFirst()) {
                do {
                    var consumption = Consumption(0, 0, 0, null, null)
                    consumption.id = cursor.getInt(cursor.getColumnIndex(ID))
                    consumption.money = cursor.getInt(cursor.getColumnIndex(MONEY))
                    consumption.pm = cursor.getInt(cursor.getColumnIndex(PM))
                    consumption.usage = cursor.getString(cursor.getColumnIndex(USAGE))
                    consumption.time = cursor.getString(cursor.getColumnIndex(TIME))

                    listConsumption.add(consumption)
                } while (cursor.moveToNext())
            }
            db.close()
            return listConsumption
        }

    fun addConsumption (consumption: Consumption) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(ID, consumption.id)
        values.put(MONEY, consumption.money)
        values.put(PM, consumption.pm)
        values.put(USAGE, consumption.usage)
        values.put(TIME, consumption.time)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateConsumption (consumption: Consumption) : Int {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(ID, consumption.id)
        values.put(MONEY, consumption.money)
        values.put(PM, consumption.pm)
        values.put(USAGE, consumption.usage)
        values.put(TIME, consumption.time)

        return db.update(TABLE_NAME, values, "$ID=?", arrayOf(consumption.id.toString()))
    }

    fun deleteConsumption (consumption: Consumption) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "$ID=?", arrayOf(consumption.id.toString()))
        db.close()
    }
}