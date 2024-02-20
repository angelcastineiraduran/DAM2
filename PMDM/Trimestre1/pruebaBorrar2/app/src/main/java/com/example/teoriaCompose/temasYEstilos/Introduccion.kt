package com.example.teoriaCompose.temasYEstilos

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Introduccion {
    @Composable
    private fun Greeting(txtBtn: String) {
        val estaExpandido = remember { mutableStateOf(false) }
        val extraPadding = if(estaExpandido.value) 48.dp else 0.dp
        ElevatedButton(
            onClick = { estaExpandido.value = !estaExpandido.value },
            modifier = Modifier.padding(extraPadding)
        ) {
            Text(
                if (estaExpandido.value) "Muestra menos" else txtBtn,
                // le cambiamos el estilo
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

    @Composable
    fun MyApp(
        txtBtns: List<String> = listOf("Presioname", "Clica"),
        modificador: Modifier = Modifier
        ) {
            Surface(modifier = modificador.padding(19.dp), color = MaterialTheme.colorScheme.primary) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    for (txtBtn in txtBtns) {
                        Greeting(txtBtn = txtBtn)
                    }
                }
            }
    }

    @Preview(showBackground = true)
    @Composable
    fun previewIntroduccion() {
        MyApp()
    }

}