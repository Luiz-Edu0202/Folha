package com.folha.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
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
import com.folha.app.ui.theme.Marfim
import com.folha.app.ui.theme.SalviaClara
import com.folha.app.ui.theme.VerdePrincipal
import com.folha.app.viewmodel.FolhaViewModel

@Composable
fun ClubsScreen(viewModel: FolhaViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())) {
        Text("Clubes do livro", fontSize = 36.sp, fontFamily = FontFamily.Serif)
        Text("Boas histórias merecem companhia.", color = CinzaOliva)

        Surface(
            shape = RoundedCornerShape(8.dp),
            color = SalviaClara,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {
            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = VerdePrincipal)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("São Paulo, SP", fontWeight = FontWeight.Bold)
                    Text("Região demonstrativa", fontSize = 12.sp, color = CinzaOliva)
                }
            }
        }

        viewModel.clubs.forEach { club ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), colors = CardDefaults.cardColors(containerColor = Marfim)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(club.name, fontSize = 22.sp, fontFamily = FontFamily.Serif)
                    Text(club.bookTitle, fontWeight = FontWeight.Bold, color = VerdePrincipal)
                    Text("${club.date}\n${club.location}", fontSize = 14.sp, color = CinzaOliva, modifier = Modifier.padding(vertical = 8.dp))

                    Button(
                        onClick = { viewModel.joinClub(club.id) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (club.isJoined) SalviaClara else VerdePrincipal,
                            contentColor = if (club.isJoined) VerdePrincipal else Color.White
                        )
                    ) {
                        Text(if (club.isJoined) "Encontro marcado" else "Participar do encontro")
                    }
                }
            }
        }
    }
}