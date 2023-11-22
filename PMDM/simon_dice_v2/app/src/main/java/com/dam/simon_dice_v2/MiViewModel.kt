package com.dam.simon_dice_v2

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MiViewModel(): ViewModel() {
    private val TAG_LOG: String = "Mensaje View"

    // te devuelve un objeto, para poder aplicarle la func random() ?¿
    var numeros = mutableStateOf(0); // observable

    init {
        Log.d(TAG_LOG, "Iniciamos View Model")
    }

    fun crearRandom() {
        numeros.value = (0 .. 4).random()
        Log.d(TAG_LOG, "Creamos random ${numeros.value}")
    }

    fun getNumeroRandom() : Int {
        return numeros.value
    }

    fun iterarLista(lista : MutableList<Int>) : String {
        var impresionLista : String = ""
        for(ele in lista) {
            impresionLista += " , ${ele.toString()}"
        }
        return impresionLista
    }
}