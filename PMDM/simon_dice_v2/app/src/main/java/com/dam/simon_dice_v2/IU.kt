package com.dam.simon_dice_v2

import android.R
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview("prev")
@Composable
fun MiInterfaz(miViewModel: MiViewModel) {

    val TAR_LOG: String = "Mensaje IU"
    val clickado = remember { mutableStateOf(false) }
    val secuenciaColores : MutableList<Int> = remember { mutableListOf() }
    var botonSeleccionado : Int = -1
    val BOTON1 : Int = 1
    val BOTON2 : Int = 2
    val BOTON3 : Int = 3
    val BOTON4 : Int = 4

    Column(
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally // centra los compos de la Column
    ) {
        Text(text = "Simon dice", modifier = Modifier.padding(10.dp), Color.Black)

        Row {
            Button(
                onClick = {
                    Log.d("botonera", "Boton 1")
                    secuenciaColores.add(BOTON1)
                    Log.d("botonera", miViewModel.iterarLista(secuenciaColores))
                },
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) { Text(text = "b1") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    Log.d("botonera", "Boton 2")
                    secuenciaColores.add(BOTON2)
                    Log.d("botonera", miViewModel.iterarLista(secuenciaColores))
                },
                colors = ButtonDefaults.buttonColors(Color.Yellow),
            ) { Text(text = "b2") }
        }
        Row {
            Button(
                onClick = {
                    Log.d("botonera", "Boton 3")
                    secuenciaColores.add(BOTON3)
                    Log.d("botonera", miViewModel.iterarLista(secuenciaColores))
                },
                colors = ButtonDefaults.buttonColors(Color.Green),
            ) { Text(text = "b3") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    Log.d("botonera", "Boton 4")
                    secuenciaColores.add(BOTON4)
                    Log.d("botonera", miViewModel.iterarLista(secuenciaColores))
                },
                colors = ButtonDefaults.buttonColors(Color.Blue),
            ) { Text(text = "b4") }
        }

        Button(
            onClick = {
                Log.d("botonera", "principal = ${clickado.value}")
                clickado.value = !clickado.value
            },
            shape = CutCornerShape(0),
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(if(clickado.value) "Reset" else "Start")
        }
    }
}
@Composable
fun funcStart(){

}

@Composable
fun mostrarNumeros(miViewModel: MiViewModel) {
    Column {
        Text(
            text = "Numeros: ${miViewModel.getNumeroRandom()}",
            color = MaterialTheme.colorScheme.primary
        )
        Button(onClick = { miViewModel.crearRandom() }) {

        }

    }
}
@Preview("Prev de mostrarNum")
@Composable
fun prevMostrarNumeros(){
    val miViewModel : MiViewModel = MiViewModel()
    MiInterfaz(miViewModel = miViewModel)
}