package com.dam.modelovista

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MiViewModel() : ViewModel() {
    private val TAG_LOG : String = "mensaje ViewModel"
    var _numbers = mutableStateOf(0)
    init {
        Log.d(TAG_LOG, "inicializamos ViewModel")
    }
    fun crearRandom(){
        _numbers.value = (0..10).random()
        Log.d(TAG_LOG, "creamos random ${_numbers.value}")
    }
    fun getNumero() : Int{
        return _numbers.value
    }


}