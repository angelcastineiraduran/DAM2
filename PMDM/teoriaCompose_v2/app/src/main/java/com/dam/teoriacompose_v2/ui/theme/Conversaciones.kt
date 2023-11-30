package com.dam.teoriacompose_v2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

data class Mensaje(val autor: String, val cuerpo: String)

@Composable
fun enviarMensaje(msg: Mensaje) {
    Column {
        Text(
            text = msg.autor,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = msg.cuerpo,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )
    }
}