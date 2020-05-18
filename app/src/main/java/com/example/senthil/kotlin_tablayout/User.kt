package com.example.senthil.kotlin_tablayout

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
        var name: String? = "a",
<<<<<<< HEAD
        var pw: String? = "aa",
        var profile: String? = "profile"
        ) {
=======
        var profile: String? = "profile",
        var pw: String? = "aa") {
>>>>>>> 9de0792135b121a1c2c2128c1776232156b5243c

    fun toMap(): Map<String, Any?> {
        return mapOf(
                "name" to name,
                "profile" to profile,
                "pw" to pw
        )
    }
}