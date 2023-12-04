package com.dam.simon_dice_v2

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import androidx.lifecycle.viewModelScope

class MiViewModel(): ViewModel() {
    val TAG_LOG = "ViewModel"

    init {
        Log.d(TAG_LOG, "Entrando")
    }

    /**
     * genera secuencia random de 10 elementos tipo MyColor
     */
    fun setBotSecuence(secuencia: MutableList<Int>) {
        for (i in 0 .. 10) {
            secuencia.add((1..4).random())
        }
        Log.d(TAG_LOG, "botSecuence: ${(Data.botSecuence)}")
        Log.d(TAG_LOG, "botSecuence: ${(Data.userSecuence)}")
    }

    /**
     * compara todos los elementos de las 2 secuncias y si alguno de ellos es falso
     * se acaba el juego -> isGameOver = True
     */
    fun validateSecuences() {
        Data.userSecuence.forEachIndexed { index, element ->
            if(element != Data.botSecuence[index]) {
                Data.isGameOver.value = true
            } else if(Data.userSecuence.size != Data.record.value) {
                Data.isGameOver.value = true
            }
            Log.d(TAG_LOG, "${Data.userSecuence.size} != ${Data.record.value}, ${Data.userSecuence.size != Data.record.value}")
            Log.d(TAG_LOG, "valorando... ${element} == ${Data.botSecuence[index]}, ${element != Data.botSecuence[index]}")
        }
        Log.d(TAG_LOG, "isGamerOver=${Data.isGameOver.value}")
    }

    fun answerRequest() {
        if(Data.isGameOver.value == true) {
            isGameOverTrue()
        } else {
            nextRound()
        }
    }
    // este funciona
    fun isStarted() {
        setBotSecuence(Data.botSecuence)
        Data.isStarted.value = true
        Data.isGameOver.value = false
        Data.record.value = 1
        setBotSecuenceNow()
        Log.d(TAG_LOG, "${Data.botSecuenceNow}")
        Log.d(TAG_LOG, "isStarted_v2")
    }

    // runBlocking bloquea el hilo principal y detiene la ejecucion de la corrutina hasta que se complete
    // pero como dentro de modifyColor estas lanzando corrutinas launch que contienen delay, esto esta
    // tratando de suspender la ejecuccion mientras el hilo principal esta bloqueado, lo que provoca el error
    /*
    fun isStarted_v2() = runBlocking{
        Data.isStarted.value = true
        Data.isGameOver.value = false
        Data.record.value = 1
        setBotSecuenceNow()
        Log.d(TAG_LOG, "${Data.botSecuenceNow}")
        Log.d(TAG_LOG, "isStarted_v2")
        modifyColor()
    }

     */

    fun isGameOverTrue() {
        Data.isStarted.value = false
        Data.userSecuence.clear()
        Data.botSecuence.clear()
        Data.botSecuenceNow.clear()
        Data.record.value = 1
    }

    fun nextRound() {
        Data.record.value++
        Data.userSecuence.clear()
        setBotSecuenceNow()
        modifyColor()
    }

    fun setBotSecuenceNow() {
            Data.botSecuenceNow.add(Data.botSecuence[Data.record.value-1])
            Log.d(TAG_LOG, "setBotSecuenceNow: ${Data.botSecuenceNow}")
    }

    fun modifyColor() {
        Log.d(TAG_LOG, "incrementanto color")
        viewModelScope.launch {
            Data.botSecuenceNow.forEach { element ->
                delay(150L)
                when (element) {
                    Data.ROJO -> {
                        var aux = Data.colorRojo.value
                        Data.colorRojo.value = Data.colorSeleccion.value
                        delay(700L)
                        Data.colorRojo.value = aux
                    }
                    Data.AMARILLO -> {
                        var aux = Data.colorAmarillo.value
                        Data.colorAmarillo.value = Data.colorSeleccion.value
                        delay(700L)
                        Data.colorAmarillo.value = aux
                    }
                    Data.VERDE -> {
                        var aux = Data.colorVerde.value
                        Data.colorVerde.value = Data.colorSeleccion.value
                        delay(700L)
                        Data.colorVerde.value = aux
                    }
                    Data.AZUL -> {
                        var aux = Data.colorAzul.value
                        Data.colorAzul.value = Data.colorSeleccion.value
                        delay(700L)
                        Data.colorAzul.value = aux
                    }
                }
            }
        }

    }

}