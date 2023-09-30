package com.example.introduccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Tipos_datos : AppCompatActivity() {
    /**
     * constantes
     */
    companion object{
        const val moneda = "EUR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * tipos declaracion
         */
        // const val moneda = "EUR" // ERROR
        var nombre = "juan" // gris pq no se utiliza
        var nombre2 = "juan" // blanco pq se esta utilizando
        println(nombre2)

        var nombre3: String = "juan" // "String" gris pq estamos especificando el tipo = redundante
        // se subraya con linea amarilla pq se puede hacer todo en una linea:
        var nombre4: String // "String" blanco pq hasta la siguiente linea no lo sabe
        nombre4 = "juan"

        /**
         * booleanos
         */
        var vip: Boolean = false

        /**
         * tipos num
         */
        //var saldo: Float = 300.54 // ERROR - float no espec
        var saldo2: Float = 300.54f

        var doble: Double = 3.4 // mas espacio reservado memoria

        var entero: Int = 3

        /**
         * ejemplos
         */
        var saludo = "Hola " + nombre
        // mezclando tipos:
        var saludo2 = "Hola" + saldo2 // incorrecto, tienen que ser mismo tipo
        var saludo2_1 = "Hola" + saldo2.toString() // forma correcta
    }

}