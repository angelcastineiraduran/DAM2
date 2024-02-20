package com.dam.modelovista

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InterfazUsuario(miViewModel: MiViewModel) {
    val TAG_LOG : String = "mensaje UI"
    Text(
        text = "Numeros: ${miViewModel.getNumero()}",
        modifier = Modifier.padding(32.dp),
        color = Color.DarkGray
    )
    Button(
        onClick = {
            Log.d(TAG_LOG, "Dentro del OnClick")
            miViewModel.crearRandom()
        },
        modifier = Modifier.padding(64.dp)
    ){

    }

        

}
@Preview
@Composable
fun DefaultPreview(){
    MaterialTheme{
        InterfazUsuario(miViewModel = MiViewModel())
    }
}