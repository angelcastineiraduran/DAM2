package com.dam.ejercicio_tiempoactivo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam.ejercicio_tiempoactivo.ui.theme.Ejercicio_tiempoActivoTheme

class MainActivity : ComponentActivity() {

    var horaActualIncioActivity : Long = 0
    //var horaActualFinalPause : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.i("cicloVida", "Ingresa onCreate() ")
    }

    override fun onStart(){
        super.onStart()
        Log.i("cicloVida", "Ingresa onStart()")
        horaActualIncioActivity = System.currentTimeMillis()
    }
    override fun onResume(){
        super.onResume()
        Log.i("cicloVida", "Ingresa onResume()")
    }
    override fun onPause(){
        super.onPause()
        Log.i("cicloVida", "Ingresa onPause()")
        Log.i("cicloVida", "Tiempo que estuvo en actividad: " + (System.currentTimeMillis() - horaActualIncioActivity)/60 + "segundos")

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
}
