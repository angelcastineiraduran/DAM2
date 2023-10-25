package com.example.ejercicio_tiempoactivo_v3.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
    LazyColumn(
        //modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(30.dp)
    ) {
        item {
            Column {
                Text(
                    text = "CLICS: $contador",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End)
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
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ColorButton(Color.Red)
                    ColorButton(Color.Yellow)
                }
                RoundButton(
                    onClick = {
                        contador++
                    },
                    Image(
                        painter = ,
                        contentDescription =
                    )
                )
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
