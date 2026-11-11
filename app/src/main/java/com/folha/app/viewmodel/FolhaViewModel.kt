package com.folha.app.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.folha.app.model.Book
import com.folha.app.model.Club
import com.folha.app.ui.theme.*

class FolhaViewModel : ViewModel() {
    var books by mutableStateOf(
        listOf(
            Book(1, "Torto arado", "Itamar Vieira Junior", Dourado, isTrending = true),
            Book(2, "A hora da estrela", "Clarice Lispector", VerdeFloresta, isTrending = true),
            Book(3, "Tudo é rio", "Carla Madeira", Terracota, isTrending = true)
        )
    )

    var clubs by mutableStateOf(
        listOf(
            Club(1, "Entre páginas", "Torto arado", "17 out. · sábado, às 15h", "Café das Letras · Pinheiros", true),
            Club(2, "Leituras de domingo", "A hora da estrela", "25 out. · domingo, às 10h", "Livraria Jardim · Vila Mariana", false)
        )
    )

    fun joinClub(clubId: Int) {
        clubs = clubs.map { if (it.id == clubId) it.copy(isJoined = !it.isJoined) else it }
    }
}