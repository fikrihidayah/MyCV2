package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    nim: String,
    nama: String,
    email: String,
    alamat: String,
    onDaftarClick: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Halaman Detail") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("NIM: 235150400111015")
            Text("Nama: Fikri Irfan Hidayah")
            Text("Email: fikri@gmail.com")
            Text("Alamat: Malang")

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onDaftarClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Daftar Lagi")
            }
        }
    }
}