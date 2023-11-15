package com.dam.simon_dice_v2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.simon_dice_v2.ui.theme.Simon_dice_v2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

// componente: Button(onClick={/*ACCION*/}){/*TEXTO*/}

/**
 * Visualizo boton por pantalla que al hacer click se muestra texto
 */

@Composable
fun miBoton() {
    var context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Has presionado el boton", Toast.LENGTH_LONG).show()
    }) {Text(text = "Presiona aqui")} // texto del boton
}

@Composable
fun miEtiqueta() {
    Surface (color = MaterialTheme.colorScheme.primary){ // color de fondo
        Row {
            Column {
                Text(text = "Hola Mundo")
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                Text(text = "Hola Angel")
            }
            Image(
                painter = painterResource(id = R.drawable.sirenita),
                contentDescription = "foto de la sirenita",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
        }
    }
}


