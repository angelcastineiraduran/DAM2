package com.example.pruebaborrar2.animaciones

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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

class AnimateDpAsSate2 {

    @Composable
    private fun Greeting(nombre: String) {

        var expanded by rememberSaveable { mutableStateOf(false) }

        val extraPadding by animateDpAsState(
            if(expanded) 48.dp else 0.dp,
            // param opcional que permite personalizar animacion
            // animacion basada en resortes, como si fuera un muelle
            animationSpec = spring(
                // amortiguacion
                dampingRatio = Spring.DampingRatioMediumBouncy,
                // rigidez
                stiffness = Spring.StiffnessLow
            )
        )

        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        // antes:
                        //.padding(bottom = extraPadding)
                        // ahora:
                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))

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