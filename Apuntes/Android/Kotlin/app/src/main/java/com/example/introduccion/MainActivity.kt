package com.example.introduccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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
         * Tipos de datos
         */

        // const val moneda = "EUR" // ERROR
        var nombre = "juan" // gris pq no se utiliza
        var nombre2 = "juan" // blanco pq se esta utilizando
        println(nombre2)

        var nombre3: String = "juan" // "String" gris pq estamos especificando el tipo = redundante
        // se subraya con linea amarilla pq se puede hacer todo en una linea:
        var nombre4: String // "String" blanco pq hasta la siguiente linea no lo sabe
        nombre4 = "juan"

        var vip: Boolean = false

        //var saldo: Float = 300.54 // ERROR - float no espec
        var saldo2: Float = 300.54f

        var doble: Double = 3.4 // mas espacio reservado memoria

        var entero: Int = 3

        var saludo = "Hola " + nombre
        // mezclando tipos:
        var saludo2 = "Hola" + saldo2 // incorrecto, tienen que ser mismo tipo
        var saludo2_1 = "Hola" + saldo2.toString() // forma correcta

        /**
         * arrays
         */
        var matriz = arrayOf (
            intArrayOf(1, 2, 3), // (0,0) (0,1) (0,2)
            intArrayOf(4, 5, 6), // (1,0) (1,1) (1,2)
            intArrayOf(7, 8, 9) // (2,0) (2,1) (2,2)
            //intArrayOf(7, 8, 9, 10, 11) // puedo poner esto
        )

        recorrerMatriz(matriz)

        /**
         * colecciones
         */
        // INMUTABLE
        var clientesVIP : Set<Int> = setOf(123, 3223, 423)
        var setMezclados = setOf(123, "antonio", 423)
        if (clientesVIP.contains(123)) println("123 es vip") // solo recibe int

        // MUTABLE
        var clientes : MutableSet<Int> = mutableSetOf(12, 323, 23)
        //clientesVIP.add(1234) // error -> no mutable
        clientes.add(123)
        clientes.clear() // limpia todas
        /**
         * Condicionales
         */
        var fecha : String = "01/02/2023"
        var mesCumple : Int = 2

        if (fecha.subSequence(0,2).toString().toInt() == mesCumple) println("Es tu cumple")
        else println("No es tu cumple")

        when(fecha.subSequence(0,2).toString().toInt()){
            1, 2, 3 -> println("Estamos en invierno")
            4, 5, 6 -> println("Estamos en primavera")
            7, 8, 9 -> println("Estamos en verano")
            10, 11, 12 -> println("Estamos en otornio")
            else -> print("mes incorrecto")
        }


        /**
         * Bucles
         */
        var dinero : Double = 30.0
        var tipoMoneda : String = "EUR"
        var intentos : Int = 0
        var PIN_correcto : Int = 333
        var PIN_ingresado : Int = 330
        var dineroIngresado : Double = 5.0

        // APP BANCO
        do{
            println("En mi cuenta bancaria tengo $dinero $tipoMoneda") // 30.0 EUR
            println("Te quedan ${intentos++} intentos")  // 1-printea, 2-incrementa
        }while(intentos < 2 && PIN_correcto != PIN_ingresado)

        var recibos = arrayOf("luz", "agua", "gas")
        recibos.set(0, "electricidad")
        recorrerArray(recibos)

        /**
         * funciones = metodos
         */
        mostrarDinero()
        mostrarNombre("Angel")

        var acertado : Boolean = numeroAcertado(2)
        if(acertado == true) println("Numero correcto")
        else println("Numero incorrecto")

    }

    fun mostrarDinero(){
        println("tienes 50 eur")
    }
    fun mostrarNombre(nombre : String) {
        println("Nombre introducido: " + nombre)
    }

    fun numeroAcertado(numero : Int) : Boolean{
        println("Introduce numero entero del 1 al 10")
        if(numero == 1) return true
        else return false
    }

    fun recorrerArray(arreglo : Array<String>){
        for (i in arreglo) // i de iterador
            println(i)

        println("--con indices--")
        for (i in arreglo.indices) {
            println(arreglo.get(i))
        }
        println("--tamanio arrar--")
        for (i in 0 .. arreglo.size -1) {
            println("${i + 1}: ${arreglo.get(i)}")
        }
    }

    // forma propia
    fun recorrerMatriz(matriz: Array<IntArray>){
        for (i in 0 .. matriz.size - 1) { // incluye ultimo elemento (si matriz.size=3 iria incluido)
            for (j in 0 .. matriz.get(i).size - 1){
                print(matriz.get(i).get(j))
            }
            println("")

        }
    }

    fun recorrerMatriz_v2 (matriz: Array<IntArray>) {
        //for (i in 0 .. 2){  // correcto creo tambien
        for (i in (0 until matriz.size)) { // No hace falta -1 pq NO incluye el ultimo
             println()
            for (j in (0 until matriz[i].size)) {
                println("Poscicion[$i][$j]: ${matriz[i][j]}")
            }
        }
    }



}