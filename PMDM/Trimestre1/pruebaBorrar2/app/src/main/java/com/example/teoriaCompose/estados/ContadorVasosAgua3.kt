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

@Composable
fun WaterCounter3(modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // valor calculado con remember se almacena en la composicion inicial
        // esta en val y si que se actualiza su valor, que sentido tiene?¿
        val count: MutableState<Int> = remember {mutableStateOf(0)}
        Text(
            text = "Tu has tomado ${count.value} vasos de agua",
            modifier = modifier.padding(16.dp)
        )
        Button(
            // recibe una funion lambda, que es el evento que
            // tiene lugar cd se hace click
            onClick = { count.value++ },
            modifier = modifier.padding(16.dp),
        ) {
            Text(text = "+1")
        }
    }

}

@Composable
fun PantallaPrincipal3(modifier: Modifier = Modifier) {
    WaterCounter3(modifier)
}

@Preview(showBackground = true)
@Composable
fun previewWaterCounter3() {
    TeoriaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            PantallaPrincipal3()
        }
    }
}