package com.example.ejercicio_tiempoactivo_v3.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_tiempoactivo_v3.R


open class UI {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(miViewModel: MyViewModel) {
    var contador = remember { mutableStateOf(0) }
    val TAG_LOG:String="Mensaje UI"

    //un cuadro de texto para mostrar los numeros
    Text(
        text="Numeros: ${miViewModel.getListaRandom()}",
        modifier = Modifier
            .offset(y = 160.dp)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "GENERADOR DE NUMEROS ALEATORIOS")
        Button(
            onClick = {
                miViewModel.crearRandom()
                contador.value++
            }
        ) {
            Text("Pulsa aqui")
            Image(
                painter = painterResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = "generar numero aleatorio"
            )
        }
        /*
        // campo de texto para rellenar
        OutlinedTextField( // da error pq?
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text(text = "Name") }
        )
        */
        Login(miViewModel = MyViewModel())

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {
    Column {
        // mostrar el contador de clics
        TextButton(
            onClick = { miViewModel.contadorClic() },
            modifier = Modifier.offset(y = 5.dp)
        ) {
            Text("CLICS: ${miViewModel.getContador()}")
        }
        // mientras no tecleamos mas de tres caracteres no se muestra el saludo
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getTexto()}!",
                fontSize = 24.sp,
                modifier = Modifier.offset(y = 110.dp)
            )
        }
        // campo de texto para rellenar
        OutlinedTextField(
            value = miViewModel.getTexto(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = { Text(text = "Name") }, modifier = Modifier.offset(y = 5.dp)
        )

    }

}
