package com.folha.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.folha.app.ui.theme.*

@Composable
fun GoalsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Metas de leitura", fontSize = 36.sp, fontFamily = FontFamily.Serif)
        Text("Pequenos passos, muitas histórias.", color = CinzaOliva)

        Spacer(modifier = Modifier.height(24.dp))

        // Card de Progresso
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = VerdePrincipal)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("SUA META PARA 2026", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text("8", color = Color.White, fontSize = 48.sp, fontFamily = FontFamily.Serif)
                    Text(" de 12 livros lidos", color = Color.White, fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))
                LinearProgressIndicator(
                    progress = { 8f / 12f },
                    modifier = Modifier.fillMaxWidth().height(8.dp),
                    color = D7DFAB, // Lima suave
                    trackColor = Color.White.copy(alpha = 0.2f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("67% concluído · faltam 4 novas histórias.", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Sua ordem de leitura", fontSize = 24.sp, fontFamily = FontFamily.Serif)
        Spacer(modifier = Modifier.height(8.dp))

        // Fila de Leitura
        BookQueueItem(order = "01", title = "Torto arado", status = "Lendo agora · página 86 de 264")
        BookQueueItem(order = "02", title = "Tudo é rio", status = "Próxima leitura · 210 páginas")
        BookQueueItem(order = "03", title = "O avesso da pele", status = "Na sequência · 208 páginas")
    }
}

@Composable
fun BookQueueItem(order: String, title: String, status: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Marfim),
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(CinzaSalvia))
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(order, color = Ocre, fontSize = 24.sp, fontFamily = FontFamily.Serif, modifier = Modifier.width(40.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(status, fontSize = 12.sp, color = CinzaOliva)
            }
        }
    }
}