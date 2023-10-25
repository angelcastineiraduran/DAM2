package com.example.ejercicio_tiempoactivo_v3.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
data class RandomData(val numbers: List<Int>)

class MyViewModel() : ViewModel() {
    private val TAG_LOG: String = "Mensaje ViewModel"

    //esta va a ser nuestra lista para la secuencia random
    //usamos mutable, ya que la queremos modificar y observar cuando cambia
    var _numbers = mutableStateOf(0)
    var randomData = mutableStateOf(RandomData(emptyList()))

    //crear una lista mutable
    val numbers= mutableStateListOf<Int>()

    // Dos maneras diferentes de definir un estado
    // con el = necesitamos utilizar value
    var counter=mutableStateOf(0)

    var name =mutableStateOf("")



    //inicializamos variables cuando instanciamos, éste es el constructor de la clase
    init {
        //se usa el log para saber cuando se ejecuta la instacia de la clase
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    /**
     * Crear entero random
     */
    fun crearRandom() {
        /*
        val randomNumber=(0..3).random()
        numbers.add(randomNumber)
        Log.d(TAG_LOG,"Creamos random $randomNumber")

        //Imprime la lista completa
        for(numero in numbers){
            Log.d(TAG_LOG,"Números aleatorio: $numero")
        }
        */
        val randomNumber = (0..3).random()
        val updatedNumbers = randomData.value.numbers.toMutableList()
        updatedNumbers.add(randomNumber)
        randomData.value = RandomData(updatedNumbers)
        Log.d(TAG_LOG, "Creamos random $randomNumber")
    }







    /**
     * Crear entero random
     */
    fun getNumero(): Int {
        return _numbers.value
    }

    fun getListaRandom(): List<Int> {
        return randomData.value.numbers
    }
    /**
     * Contador de clic
     */
    fun contadorClic(){
        counter.value++
    }

    /**
     * Crear contador
     */
    fun getContador():Int{
        return counter.value
    }

    /**
     * Obtener texto
     */
    fun getTexto():String{
        return name.value
    }

    @Preview
    @Composable
    fun vistaPreview(){
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