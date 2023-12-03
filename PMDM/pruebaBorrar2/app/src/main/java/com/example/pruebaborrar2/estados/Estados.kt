package com.example.pruebaborrar2.estados

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Estados {
    @Composable
    private fun Greeting(txtBtn: String) {
        val estaExpandido = remember { mutableStateOf(false) }
        val extraPadding = if(estaExpandido.value) 48.dp else 0.dp
        ElevatedButton(
            onClick = { estaExpandido.value = !estaExpandido.value },
            // agrega espacio entre el txt del boton y el borde de dentro del boton
            //aunque este no es el mejor ejemplo ya que no funciona muy bien con el txt
            modifier = Modifier.padding(extraPadding)
        ) {
            Text(if (estaExpandido.value) "Muestra menos" else txtBtn)
        }
    }

    @Composable
    fun miApp(
        txtBtns: List<String> = listOf("Presioname", "Clica"),
        modificador: Modifier = Modifier
    ) {
        Surface(modifier = modificador.padding(19.dp), color = MaterialTheme.colorScheme.primary) {
            // toda esta columna es un ele del surface y por eso el padding le afecta
            // a toda la columna, es decir a los 2 botones que hay dentro de la columna
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                // el padding se aplica a los ele que hay dentro del bloque de la columna
                // por tanto es el padding que se aplica por cada btn
                for (txtBtn in txtBtns) {
                    Greeting(txtBtn = txtBtn)
                }
            }
        }
    }

    @Preview(showBackground = true, name = "preview")
    @Composable
    fun previoEstados() {
        miApp()
    }
}