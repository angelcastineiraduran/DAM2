package com.dam.simon_dice_v2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
import androidx.lifecycle.ViewModel
import com.dam.simon_dice_v2.ui.theme.Simon_dice_v2Theme

/**
 * Clase que inicia todo el proceso de la app
 *
 */
class MainActivity : ComponentActivity() {
    /**
     * Funcion que inicia la app, llamando a la funcion MiInterfaz (toda la interfaz de la app) la cual
     * recibe una instancia de MiViewModel (la logica de la app).
     * Tambien indico en el surface algunos parametros de la interfaz como el color de fondo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var miViewModel: MiViewModel = MiViewModel()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MiInterfaz(miViewModel = miViewModel)
                }
            }
        }
    }
}

/**
 * Ir viendo como se va a ir mostrando la interfaz
 */
@Preview(showBackground = true)
@Composable
fun PreviewPrincipal() {
    var miViewModel: MiViewModel = MiViewModel()
    MaterialTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MiInterfaz(miViewModel = miViewModel)
        }
    }
}


