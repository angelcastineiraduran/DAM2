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
fun WaterCounter4(modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // +simple con propiedades delegadas
        // ahora se vuelve a cambiar a var, si no no me deja??¿
        var count by remember {mutableStateOf(0)}
        Text(
            text = "Tu has tomado ${count} vasos de agua",
            modifier = modifier.padding(16.dp)
        )
        Button(
            // recibe una funion lambda, que es el evento que
            // tiene lugar cd se hace click
            onClick = { count++ },
            modifier = modifier.padding(16.dp),
            // se inhabilita cd valor aumenta de 10 clicks
            enabled = count < 10
        ) {
            Text(text = "+1")
        }
    }

}

@Composable
fun PantallaPrincipal4(modifier: Modifier = Modifier) {
    WaterCounter4(modifier)
}

@Preview(showBackground = true)
@Composable
fun previewWaterCounter4() {
    TeoriaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            PantallaPrincipal4()
        }
    }
}