# Corrutinas
[doce jetbrains](https://kotlinlang.org/docs/coroutines-guide.html#table-of-contents)
[basico](https://kotlinlang.org/docs/coroutines-basics.html)

Similar a un hilo en el sentido de que un bloque de codigo se ejecuta al mismo tiempo
que el resto del codigo. Sin embargo no esta vinculada a ningun hilo en particular. Puede
suspender su ejecucion en un hilo y reanudarla en otro. Son como
subprocesos livianos.

Las corrutinas consumen mucha menos memorias que los Threads

```kotlin

fun main() = runBlocking { // this: CoroutineScope
    launch { // lanza una nuevo rutina y continua
        delay(1000L) // retraso sin bloqueo durante 1 seg
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

```

output:

```bash

Hello
World!

```

`launch` es un constructor de rutinas.

`runBlocking` es un generador de corrutinas que une el mundo 
sin corrutinas de y un `fun main()` con corrutinas dentro del 
`runBlocking { ... }`. Esto se resalta en el IDE: `this: CoroutineScope`.

`runBlocking` significa que el hilo que lo ejecuta
(en este caso en principal) se bloquea durante la
llamada, hasta que las corrutinas internas de `runBlocking { ... }`
completen su ejecucion.

`suspend` es una funcion de suspension que se 
pueden usar como unas funciones normales dentro de las 
corrutinas y que ademas, pueden usar otras funciones 
de suspension (como `delay`), a su vez, para suspender la ejecucion 
de la corrutina.

```kotlin

fun main() = runBlocking {
    launch { doWorld() }
    println("Hello")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

```

## Corrutinas de Kotlin en Android

[docu android](https://developer.android.com/kotlin/coroutines?hl=es-419#more)

Es un patron de diseño de simultaneidad que puedes usar en Android
para simplificar el codigo que se ejecuta de forma asincrona.

Ventajas
* Ligereza
* Menos fugas de memoria
* Compatibilidad con aceleracion incorporada
* Integracion con Jetpacke
