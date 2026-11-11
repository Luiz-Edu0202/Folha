package com.folha.app.model

data class Club(
    val id: Int,
    val name: String,
    val bookTitle: String,
    val date: String,
    val location: String,
    val isJoined: Boolean = false
)