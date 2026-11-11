package com.folha.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.folha.app.ui.theme.*

@Composable
fun SearchScreen() {
    var searchText by remember { mutableStateOf("Clarice Lispector") }
    var reviewText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Cada leitura, uma voz.", fontSize = 32.sp, fontFamily = FontFamily.Serif)
        Text("Encontre um livro e compartilhe sua avaliação.", color = CinzaOliva)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdePrincipal,
                unfocusedBorderColor = CinzaSalvia
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("2 livros encontrados", color = CinzaOliva, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = SalviaClara),
            border = CardDefaults.outlinedCardBorder()
        ) {
            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.width(40.dp).height(60.dp).background(VerdeFloresta, RoundedCornerShape(4.dp)))
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("A hora da estrela", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Clarice Lispector", color = CinzaOliva)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Ocre, modifier = Modifier.size(16.dp))
                        Text(" 4,8 · Literatura brasileira", fontSize = 12.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Sua avaliação", fontSize = 24.sp, fontFamily = FontFamily.Serif)
        Text("A hora da estrela · Clarice Lispector", fontSize = 14.sp, color = CinzaOliva)

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            repeat(4) { Icon(Icons.Default.Star, contentDescription = null, tint = Ocre) }
            Icon(Icons.Default.Star, contentDescription = null, tint = CinzaSalvia)
            Spacer(modifier = Modifier.width(8.dp))
            Text("4 de 5", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = reviewText,
            onValueChange = { reviewText = it },
            modifier = Modifier.fillMaxWidth().height(100.dp),
            placeholder = { Text("O que você achou da leitura?") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = CinzaSalvia,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Marfim,
                unfocusedContainerColor = Marfim
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdePrincipal)
        ) {
            Text("Publicar avaliação", fontSize = 16.sp)
        }
    }
}