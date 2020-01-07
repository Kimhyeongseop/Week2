package com.example.senthil.kotlin_tablayout

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Auth(
        var name: String?="잉",
        var email: String? = "a",
        var money: Double? = 1000000.0,
        var BCH:Int?=0,
        var BSV:Int?=0,
        var BTC:Int?=0,
        var EOS:Int?=0,
        var ETH:Int?=0,
        var LTC:Int?=0
        ) {

    fun toMap(): Map<String, Any?> {
        return mapOf(
                "name" to name,
                "money" to money,
        "email" to email,
                "BCH" to BCH,
                "BSV" to BSV,
                "BTC" to BTC,
                "EOS" to EOS,
                "ETH" to ETH,
                "LTC" to LTC
        )
    }
}