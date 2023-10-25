

package com.example.ejercicio_tiempoactivo_v3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio_tiempoactivo_v3.ui.theme.Ejercicio_TiempoActivo_v3Theme
import com.example.ejercicio_tiempoactivo_v3.ui.theme.InterfazUsuario
import com.example.ejercicio_tiempoactivo_v3.ui.theme.MyViewModel

class MainActivity : ComponentActivity() {
    var horaActualIncioActivity : Long = 0
    var tiempoTotal : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val miViewModel: MyViewModel =MyViewModel()
        super.onCreate(savedInstanceState)
        Log.i("cicloVida", "Ingresa onCreate() ")
        setContent{
            Ejercicio_TiempoActivo_v3Theme {
                Surface (
                    color = MaterialTheme.colorScheme.background,
                    //modifier = Modifier.fillMaxSize()
                ){
                    InterfazUsuario(miViewModel = miViewModel)
                }
            }

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

    @Preview
    @Composable
    fun vistaPrevia(){
        val miViewModel: MyViewModel =MyViewModel()
        Ejercicio_TiempoActivo_v3Theme {
            Surface (
                color = MaterialTheme.colorScheme.background,
                //modifier = Modifier.fillMaxSize()
            ){
                InterfazUsuario(miViewModel = miViewModel)
            }
        }
    }
}
