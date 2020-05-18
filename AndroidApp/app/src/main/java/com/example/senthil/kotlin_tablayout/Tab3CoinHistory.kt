package com.example.senthil.kotlin_tablayout

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Tab3CoinHistory (
        var date : String? = "tmp",
        var total_volume : String? = "tmp_volume"
){
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "date" to date,
                "total_volume" to total_volume
        )
    }
}