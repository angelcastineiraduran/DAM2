package com.example.ejercicio_tiempoactivo_v3.ui.theme

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_tiempoactivo_v3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(miViewModel: MyViewModel) {
    val TAG_LOG:String="Mensaje UI"
    ColorButtons()
}

@Composable
fun ColorButtons() {
    var contador by remember { mutableStateOf(0) }
    var buttonText by remember { mutableStateOf("Start") }
    var contadorSize by remember { mutableStateOf(32.sp) } // Tamaño del contador

    LazyColumn(
        //modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(30.dp)
    ) {
        item {
            Column {
                Text(
                    text = "CLICS:", //$contador",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End)
                )
                Text(
                    text = "$contador",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End)
                        .scale((if (contador >= 10) contadorSize else 1f) as Float) // Aplicar escala si contador >= 10
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ColorButton(Color.Blue)
                    ColorButton(Color.Green)
                }
            }
        }
        item {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,


                ) {
                    ColorButton(Color.Red)
                    ColorButton(Color.Yellow)
                }
                Row {
                    RowButton(
                        onClick = {
                            if (buttonText == "Start") {
                                buttonText = "Reset"
                            } else {
                                buttonText = "Start"
                                contador = 0
                            }
                        },
                        text = buttonText
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Agregar una separación horizontal
                    RoundButton(
                        onClick = {
                            contador++
                        },
                        iconResourceId = R.drawable.ic_android_black_24dp
                    )

                }

            }
        }
    }
}

@Composable
fun ColorButton(buttonColor: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = buttonColor)
    ) {
        // Puedes personalizar el contenido del botón aquí
    }
}

@Composable
fun RoundButton(
    onClick: () -> Unit,
    iconResourceId: Int
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp)
            .background(
                shape = CircleShape,
                color = Color.Magenta
            )

    ) {
        Image(
            painter = painterResource(id = iconResourceId),
            contentDescription = null
        )
    }
}


@Composable
fun RowButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp)
            .background(
                shape = CircleShape,
                color = Color.Magenta
            )
    ) {
        Text(text)
    }
}


@Preview(showBackground = true)
@Composable
fun ColorButtonsPreview() {
    Ejercicio_TiempoActivo_v3Theme {

            ColorButtons()

    }
}
