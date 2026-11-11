package com.folha.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.folha.app.ui.theme.CinzaOliva
import com.folha.app.viewmodel.FolhaViewModel

@Composable
fun TrendingScreen(viewModel: FolhaViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Trending", fontSize = 40.sp, fontFamily = FontFamily.Serif, color = MaterialTheme.colorScheme.onBackground)
        Text("Histórias que estão passando de mão em mão.", color = CinzaOliva)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Os mais acessados", fontSize = 24.sp, fontFamily = FontFamily.Serif)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(vertical = 16.dp)) {
            items(viewModel.books) { book ->

                Column(modifier = Modifier.width(120.dp)) {
                    Box(
                        modifier = Modifier.fillMaxWidth().aspectRatio(0.7f).background(book.coverColor, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(book.title, color = Color.White, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
                    }
                    Text("01 ${book.title}", fontWeight = FontWeight.Bold, maxLines = 1)
                    Text(book.author, fontSize = 12.sp, color = CinzaOliva)
                }
            }
        }
    }
}