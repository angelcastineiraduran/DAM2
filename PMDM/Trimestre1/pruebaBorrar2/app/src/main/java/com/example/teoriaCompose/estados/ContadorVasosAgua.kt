package com.example.teoriaCompose.estados

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teoriaCompose.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WaterCounter(modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. cambiamos a var para que sea mutable
        //val count = 0
        // 2. vuelvo a cambia a var pq¿
        var count = 0
        Text(
            text = "Tu has tomado $count vasos de agua",
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
fun PantallaPrincipal(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Preview(showBackground = true)
@Composable
fun previewWaterCounter() {
    TeoriaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            PantallaPrincipal()
        }
    }
}