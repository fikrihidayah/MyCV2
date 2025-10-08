package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarScreen(
    onSimpanClick: (String, String, String, String) -> Unit,
    onKembaliClick: () -> Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Halaman Daftar") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = nim,
                onValueChange = { nim = it },
                label = { Text("NIM") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { onSimpanClick(nim, nama, email, alamat) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SIMPAN")
            }
            Spacer(Modifier.height(8.dp))
            TextButton(
                onClick = onKembaliClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kembali ke Login")
            }
        }
    }
}