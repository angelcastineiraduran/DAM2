package com.dam.teoriacompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.camera.core.Preview
import com.dam.teoriacompose.datos.SampleData
import com.example.pruebaborrar2.ui.theme.PruebaBorrar2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaBorrar2Theme {
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
                onClick = { clicado.value =! clicado.value },
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
        var esExpandido by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { esExpandido != esExpandido }) {
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
    PruebaBorrar2Theme {
        MyApp()
    }
}

