package com.example.ejercicio_tiempoactivo_v3.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MyViewModel() : ViewModel() {
    private val TAG_LOG: String = "Mensaje ViewModel"

    //esta va a ser nuestra lista para la secuencia random
    //usamos mutable, ya que la queremos modificar y observar cuando cambia
    var _numbers = mutableStateOf(0)

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
        val randomNumber=(0..3).random()
        numbers.add(randomNumber)
        Log.d(TAG_LOG,"Creamos random $randomNumber")

        //Imprime la lista completa
        for(numero in numbers){
            Log.d(TAG_LOG,"Números aleatorio: $numero")
        }
        /*_numbers.value = (0..10).random()
        Log.d(TAG_LOG, "Creamos random ${_numbers.value}")*/
    }

    /**
     * Crear entero random
     */
    fun getNumero(): Int {
        return _numbers.value
    }

    fun getListaRandom(): List<Int> {
        return numbers.toList()
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

}