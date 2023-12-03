package com.example.teoriaCompose.estados

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teoriaCompose.ui.theme.TeoriaComposeTheme


class ElevacionEstado {
    var estados: Introduccion = Introduccion();

    @Composable
    fun MyApp() {
        var shouldShowOnboarding by remember{ mutableStateOf(true) }
        Surface {
            if(shouldShowOnboarding) {
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                estados.miApp()
            }
        }
    }

    @Composable
    fun OnboardingScreen(
        modifier: Modifier = Modifier,
        // recibe una funcion que no retorna nada ("Unit") y no tiene param ("()")
        onContinueClicked: () -> Unit
    ) {

        Column(
            modifier = modifier.fillMaxSize(),
            // para que se muestre el contenido en el centro de la pantalla
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun OnboardingPreview() {
        TeoriaComposeTheme {
            MyApp()
        }
    }
}