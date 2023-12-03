package com.example.pruebaborrar2.animaciones

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AnimateDpAsSate {

    @Composable
    private fun Greeting(nombre: String) {

        // guardamos aunque giremos el movil
        var expanded by rememberSaveable { mutableStateOf(false) }

        val extraPadding by animateDpAsState(if (expanded) 48.dp else 0.dp)
        // recordar antes:
        //val extraPadding = if(estaExpandido.value) 48.dp else 0.dp

        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text(text = "Hello, ")
                    Text(text = nombre)
                }
                ElevatedButton(
                    onClick = { expanded = !expanded }
                ) {
                    Text(if (expanded) "Show less" else "Show more")
                }

            }

        }
        
    }

    @Composable
    fun MyApp() {
        Greeting(nombre = "Antonio")
    }


    @Preview(showBackground = true)
    @Composable
    fun previoAnimateDpAsState() {
        MyApp()
    }

}