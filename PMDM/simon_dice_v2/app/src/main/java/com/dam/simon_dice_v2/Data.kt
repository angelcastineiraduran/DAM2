package com.dam.simon_dice_v2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

/**
 * Clase que contiene los datos de la aplicación
 */
object Data {

    /**
     * correlacionan los colores con numeros para que podamos trabajar con ellos
     */
    final const val ROJO = 1
    final const val AMARILLO = 2
    final const val VERDE = 3
    final const val AZUL = 4

    /**
     * Variables utilizadas para controlar la secuancia de la app
     */
    var isStarted = mutableStateOf(false)
    var isGameOver = mutableStateOf(false)
    var playStatus = mutableStateOf("Start")
    var userSecuence = mutableListOf<Int>()
    var botSecuence = mutableListOf<Int>()
    var botSecuenceNow = mutableListOf<Int>()

    /**
     * Variables utilizadas para cambiar la IU
     */
    var record = mutableStateOf(1)
    var colorSeleccion: MutableState<Color> = mutableStateOf(Color.LightGray)
    var colorRojo: MutableState<Color> = mutableStateOf(Color.Red)
    var colorAmarillo: MutableState<Color> = mutableStateOf(Color.Yellow)
    var colorVerde: MutableState<Color> = mutableStateOf(Color.Green)
    var colorAzul: MutableState<Color> = mutableStateOf(Color.Blue)
}