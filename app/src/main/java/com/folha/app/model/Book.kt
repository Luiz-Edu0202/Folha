package com.folha.app.model

import androidx.compose.ui.graphics.Color

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val coverColor: Color,
    val isTrending: Boolean = false,
    val rating: Float = 0f,
    val review: String = ""
)
