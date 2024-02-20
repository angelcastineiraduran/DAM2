package com.example.teoriaCompose.estados

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teoriaCompose.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

// pq tengo que agregar esta anotacion??
// esto aparece pq aun NO hemos AÑADIDO el remember (es una advertencia)
@SuppressLint("UnrememberedMutableState")
@Composable
fun WaterCounter2(modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // pq vuelvo a camabiar a val?
        // la programacion de recomposiciones funciona pero cada vez que
        // se produce la recomposicion, la variable se reinicia a 0
        // por lo que necesitamos preservar el estado de recomposiciones.
        val count: MutableState<Int> = mutableStateOf(0)
        Text(
            text = "Tu has tomado ${count.value++} vasos de agua",
            modifier = modifier.padding(16.dp)
        )
        Button(
            // recibe una funion lambda, que es el evento que
            // tiene lugar cd se hace click
            onClick = { /*TODO*/ },
            modifier = modifier.padding(16.dp),
        ) {
            Text(text = "+1")
        }
    }

}

@Composable
fun PantallaPrincipal2(modifier: Modifier = Modifier) {
    WaterCounter2(modifier)
}

@Preview(showBackground = true)
@Composable
fun previewWaterCounter2() {
    TeoriaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            PantallaPrincipal2()
        }
    }
}