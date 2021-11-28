package com.example.beginreadingapp.data.model

enum class ReadingLevel {
    K, FIRST, SECOND
}
data class Book (
    val readingLevel: ReadingLevel,
    val imageId: Int,
    val title: String,
    val story: Int
)