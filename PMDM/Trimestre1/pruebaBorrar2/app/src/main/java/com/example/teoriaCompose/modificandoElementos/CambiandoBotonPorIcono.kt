package com.example.teoriaCompose.modificandoElementos

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CambiandoBotonPorIcono {

    @Composable
    private fun Greeting(nombre: String) {
        var btnCicked by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = Modifier.padding(10.dp),
        ) {
            Row(
                // expande el row horizontalmente
                modifier = Modifier.fillMaxWidth(),
                // distribuye los ele del row dejando el maximo espacio posible entre ellos
                horizontalArrangement = Arrangement.SpaceBetween,
                // esto es solo para centralo verticalmente
                verticalAlignment = CenterVertically
            ) {
                Text(text = nombre)
                // utilizo el elemento componible:
                IconButton(onClick = { btnCicked = !btnCicked }) {
                    // agregamos el elemento secundario
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Expandir"
                    )
                }
            }
            Text(
                text = "Esto es un texto con una descripcion un poco largo para que se muestre" +
                    "despues de que le de a un boton y no se vea antes ",
                maxLines = if(btnCicked) Int.MAX_VALUE else 1
            )

        }
    }

    @Composable
    fun MyApp() {
        Surface(
            color = MaterialTheme.colorScheme.primary,
        ) {
            Greeting(nombre = "Hola")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun previewCambiandoBotonPorIcono() {
        MyApp()
    }
}