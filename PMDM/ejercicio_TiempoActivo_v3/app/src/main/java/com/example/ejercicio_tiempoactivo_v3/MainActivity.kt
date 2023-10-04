@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ejercicio_tiempoactivo_v3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio_tiempoactivo_v3.ui.theme.Ejercicio_TiempoActivo_v3Theme

class MainActivity : ComponentActivity() {
    var horaActualIncioActivity : Long = 0
    var tiempoTotal : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.i("cicloVida", "Ingresa onCreate() ")
        setContent{
            InterfazUsuario()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.i("cicloVida", "Ingresa onStart()")
        horaActualIncioActivity = System.currentTimeMillis()
    }
    override fun onResume(){
        super.onResume()
        Log.i("cicloVida", "Ingresa onResume()")
        updateUI()
        tiempoTotal = 0
    }
    override fun onPause(){
        super.onPause()
        Log.i("cicloVida", "Ingresa onPause()")
        Log.i(
            "cicloVida",
            "Tiempo que estuvo en actividad: " + calculoTiempo(horaActualIncioActivity) + " segundos"
        )
    }
    override fun onStop(){
        super.onStop()
        Log.i("cicloVida", "Ingresa onStop()")
    }
    override fun onRestart(){
        super.onRestart()
        Log.i("cicloVida", "Ingresa onRestart()")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("cicloVida", "Ingresa onDestroy()")
    }

    fun updateUI(){
        Toast.makeText(this,"Tiempo activo: $tiempoTotal",Toast.LENGTH_SHORT).show()

    }
    fun calculoTiempo(tiempoActual : Long) : Long{
        tiempoTotal = (System.currentTimeMillis() - tiempoActual) / 1000
        return tiempoTotal
    }
}
@Composable
private fun InterfazUsuario() {
    var numbers by remember {mutableStateOf(0) }
    var name = remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Hola mundo $numbers")
        Button(
            onClick = { numbers = (0..10).random() }
        ) {
            Text("general numero aleatorio")
            Image(
                painter = painterResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = "generar numeros aleatorios"
            )
        }
        // campo de texto para rellenar
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text(text = "Name") }
        )
    }
}
