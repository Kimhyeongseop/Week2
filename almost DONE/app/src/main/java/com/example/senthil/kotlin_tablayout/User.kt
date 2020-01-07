package com.example.senthil.kotlin_tablayout

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
        var name: String? = "a",
        var pw: String? = "aa",
        var profile: String? = "profile"
        ) {

    fun toMap(): Map<String, Any?> {
        return mapOf(
                "name" to name,
                "profile" to profile,
                "pw" to pw
        )
    }
}