package com.example.teoriaCompose.estados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teoriaCompose.animaciones.*
import com.example.teoriaCompose.modificandoElementos.*
import com.example.teoriaCompose.ui.theme.TeoriaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var estados : Introduccion = Introduccion()
        var elevacionEstado : ElevacionEstado = ElevacionEstado()
        var animateDpAsSate : AnimateDpAsSate = AnimateDpAsSate()
        var animateDpAsSate2 : AnimateDpAsSate2 = AnimateDpAsSate2()
        var cambiandoBotonPorIcono: CambiandoBotonPorIcono = CambiandoBotonPorIcono()
        setContent {
            //estados.miApp()
            //elevacionEstado.MyApp()
            //animateDpAsSate.MyApp()
            //animateDpAsSate2.MyApp()
            //cambiandoBotonPorIcono.MyApp()
            TeoriaComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    PantallaPrincipal4()
                }
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
    ) {
        for(name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row (modifier = Modifier.padding(24.dp)) {
            Column (
                modifier = Modifier
                    //.fillMaxWidth()
                    //.padding(vertical = 4.dp, horizontal = 8.dp),
                    .weight(1f)
            ) {
                Text(text = "Holaa, ")
                Text(text = name)
            }
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "Seleccioname!")
            }


        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun previoMetodos() {
    MyApp()
}