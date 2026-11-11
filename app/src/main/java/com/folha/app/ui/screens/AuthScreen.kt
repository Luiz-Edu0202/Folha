package com.folha.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.folha.app.ui.theme.*

@Composable
fun AuthScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Seu próximo capítulo.", fontSize = 32.sp, fontFamily = FontFamily.Serif)
        Text("Entre para reencontrar suas leituras.", color = CinzaOliva)

        Spacer(modifier = Modifier.height(32.dp))

        Text("E-mail", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("voce@exemplo.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Senha", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite sua senha") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Esqueci minha senha", color = VerdePrincipal, fontSize = 12.sp, modifier = Modifier.align(androidx.compose.ui.Alignment.End))

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdePrincipal)
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Continuar com Google", color = VerdeTinta)
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Ainda não tem conta? ", color = CinzaOliva)
            Text("Cadastre-se", color = VerdePrincipal, fontWeight = FontWeight.Bold)
        }
    }
}