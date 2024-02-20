package com.dam.simon_dice_v2

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import com.dam.simon_dice_v2.ui.theme.Simon_dice_v2Theme

/**
 * Funcion que contiene toda la interfaz de usuario
 * @param miViewModel: MiViewModel el cual contiene la logica de la app

 */
@Composable
fun MiInterfaz(miViewModel: MiViewModel) {
    val TAR_LOG: String = "Mensaje IU"
    val TAG_LOG_vM: String = "ViewModel"

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContadorRonda()
        Botonera(
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp),
            isEnabled = if(Data.isStarted.value) {true} else {false},
        )
        Row(
            modifier = Modifier
                .padding(30.dp),
        ) {
            if (Data.isStarted.value) {
                BotonReset(
                    clicado = { miViewModel.isGameOverTrue() },
                    txtReset = R.string.txtReset,
                )
            } else {
                BotonStart(
                    //clicado = { Data.isStarted.value = !Data.isStarted.value },
                    clicado = { miViewModel.isStarted()
                        miViewModel.modifyColor()
                        Log.d(TAG_LOG_vM, "${Data.isGameOver.value}")
                              },
                    txtStart = R.string.txtStart,
                    //miViewModel = miViewModel
                )
            }
            Spacer(modifier = Modifier.width(70.dp))
            BotonContinuar(
                miViewModel = miViewModel,
                modifier = Modifier

            )

        }
    }
}

/**
 * Interfaz fráfica de los botones de colores. Si se hace click sobre estos se añade el color a la secuencia del usuario,
 * @param modifier: Modifier para que se pueda cambiar desde fuera
 * @param isEnabled: Boolean para habilitar o deshabilitar los botones
 */
@Composable
fun Botonera(
    modifier: Modifier = Modifier,
    isEnabled: Boolean
) {
    val TAG_LOG_vM: String = "ViewModel"

    Row {
        Button(
            onClick = {
                Data.userSecuence.add(Data.ROJO)
                Log.d(TAG_LOG_vM, "userSecuence: ${(Data.userSecuence)}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Data.colorRojo.value),
            modifier = modifier,
            enabled = isEnabled
        ) {  }
        Button(
            onClick = {
                Data.userSecuence.add(Data.AMARILLO)
                Log.d(TAG_LOG_vM, "userSecuence: ${(Data.userSecuence)}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Data.colorAmarillo.value),
            modifier = modifier,
            enabled = isEnabled
        ) { }
    }
    Row {
        Button(
            onClick = {
                Data.userSecuence.add(Data.VERDE)
                Log.d(TAG_LOG_vM, "userSecuence: ${(Data.userSecuence)}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Data.colorVerde.value),
            modifier = modifier,
            enabled = isEnabled
        ) { }
        Button(
            onClick = {
                Data.userSecuence.add(Data.AZUL)
                Log.d(TAG_LOG_vM, "userSecuence: ${(Data.userSecuence)}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Data.colorAzul.value),
            modifier = modifier,
            enabled = isEnabled
        ) {  }
    }

}

/**
 * IU del boton que inicia el juego
 * @param txtStart: Int para el texto del boton se pueda cambiar desde fuera
 * @param modifier: Modifier para que se pueda cambiar desde fuera
 * @param clicado: () -> Unit para que se pueda cambiar desde fuera
 */
@Composable
fun BotonStart(
    @StringRes txtStart: Int,
    modifier: Modifier = Modifier,
    clicado: () -> Unit,
    //miViewModel: MiViewModel
) {
    Button(
        onClick = {
            clicado()
            //miViewModel.setBotSecuence(Data.botSecuence)
                  },
        modifier = modifier
    ) {
        Text(stringResource(id = txtStart))
    }
}

/**
 * IU del boton que reinicia el juego
 * @param txtReset: Int para el texto del boton se pueda cambiar desde fuera
 * @param modifier: Modifier para que se pueda cambiar desde fuera
 * @param clicado: () -> Unit para que se pueda cambiar desde fuera
 */
@Composable
fun BotonReset(
    @StringRes txtReset: Int,
    modifier: Modifier = Modifier,
    clicado: () -> Unit,
) {
    Button(
        // tengo que llamar a la funcion y no al valor
        // funcion: clicado(), valor clicado
        onClick = {
            clicado()
                  },
        modifier = modifier
    ) {
        Text(stringResource(id = txtReset))
    }
}

/**
 * IU del boton que continua el juego
 * @param modifier: Modifier para que se pueda cambiar desde fuera
 * @param miViewModel: MiViewModel para que se pueda cambiar desde fuera aunque en este caso
 * no se utiliza ya que se llama a la funcion desde el propio boton
 */
@Composable
fun BotonContinuar(
    modifier: Modifier = Modifier,
    miViewModel: MiViewModel
) {
    IconButton(
        onClick = {
            miViewModel.validateSecuences()
            miViewModel.answerRequest()
                  },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = "Siguiente"
        )
    }
}

/**
 * IU del contador de rondas. Aumenta cada vez que se acierta la secuencia.
 * @param modifier: Modifier para que se pueda cambiar desde fuera. Al final no se utiliza.
 */
@Composable
fun ContadorRonda(
    modifier: Modifier = Modifier
) {
    Text("Ronda: ${Data.record.value}")
}

/**
 * Para previsualizar la interfaz de usuario
 */
@Preview("Prev de mostrarNum")
@Composable
fun prevMostrarNumeros() {
    var miViewModel: MiViewModel = MiViewModel()
    Simon_dice_v2Theme {
        Surface {
            MiInterfaz(miViewModel = miViewModel)
        }
    }
}