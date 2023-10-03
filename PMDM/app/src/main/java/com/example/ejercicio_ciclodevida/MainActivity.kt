package com.example.ejercicio_ciclodevida

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
import com.example.ejercicio_ciclodevida.ui.theme.Ejercicio_CicloDeVidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("cicloVida", "Ingresa onCreate() ")
    }

    override fun onStart(){
        super.onStart()
        Log.i("cicloVida", "Ingresa onStart()")
    }
    override fun onResume(){
        super.onResume()
        Log.i("cicloVida", "Ingresa onResume()")
    }
    override fun onPause(){
        super.onPause()
        Log.i("cicloVida", "Ingresa onPause()")
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

