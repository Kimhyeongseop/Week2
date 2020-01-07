package com.example.senthil.kotlin_tablayout

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Auth(
        var name: String?="잉",
        var email: String? = "a",
        var money: Int? = 1000000,
        var di:Int?=0,
        var BCH:Int?=0,
        var BSV:Int?=0,
        var BTC:Int?=0,
        var EOS:Int?=0,
        var ETH:Int?=0,
        var LTC:Int?=0
        ) {

    fun toMap(): Map<String, Any?> {
        return mapOf(
                "name" to email,
                "money" to money
        )
    }
}