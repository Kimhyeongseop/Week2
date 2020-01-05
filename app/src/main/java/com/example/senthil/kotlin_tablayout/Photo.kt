package com.example.senthil.kotlin_tablayout

data class Photo(
        var image: String? = "") {

    fun toMap(): Map<String, Any?> {
        return mapOf(
                "image" to image
        )
    }
}