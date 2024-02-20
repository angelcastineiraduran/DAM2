package com.example.teoriaCompose.introduccion

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaborrar2.R
import com.example.teoriaCompose.datos.SampleData
import com.example.teoriaCompose.ui.theme.TeoriaComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeoriaComposeTheme {
                // A surface container using the 'background' color from the theme
                //Greeting(name = "Angel")
                //MyApp(modifier = Modifier.fillMaxSize())
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val clicado = remember { mutableStateOf(false) }

    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        Row {
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(24.dp)
            )
            ElevatedButton(
                onClick = { clicado.value = !clicado.value },
            ) {
                Text(if(clicado.value) "Muestra menos" else "Muestra mas")
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android")
    }
}

data class Mensaje(val autor: String, val cuerpo: String)

@Composable
fun MensajesVarios(msg: Mensaje) {
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)

        )

        // seguimos el valor de esExpasndido
        var esExpandido by remember { mutableStateOf(false) }

        // va a cambiar gradualmente entre colores
        val surfaceColor by animateColorAsState(
            if(esExpandido) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        // alternamos esExpandido si se clicka sobre esta columna
        Column(modifier = Modifier.clickable { esExpandido = !esExpandido }) {
            Text(
                text = msg.autor,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Surface(color = MaterialTheme.colorScheme.tertiary){
                Text(
                    text = msg.cuerpo,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    style = MaterialTheme.typography.bodySmall,
                    // si esExpandido=True desplegamos todos el contenido del msg
                    // de lo contrario no
                    maxLines = if(esExpandido) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview (name="Light mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun previoMensajes(){
    MensajesVarios(msg = Mensaje("Angel", "hola"))
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeoriaComposeTheme {
        com.example.teoriaCompose.introduccion.diseniosBasicos.MyApp()
    }
}


@Preview("Pruebas Main")
@Composable
fun previewMain() {
    TeoriaComposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}
