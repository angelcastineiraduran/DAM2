# EXAMEN 25/10/23
> Realizo commit para indicar inicio examen y creo las ramas de los apartados 2
> y 3 llamadas `Compose` y `ViewModel` respectivamente

## APARTADO 3
Una Data Class se caracteriza por tener propiedades inmutables, 
lo que significa que sus valores no pueden cambiar una vez que se han asignado. 
Además, proporciona automáticamente una serie de funciones comunes, como equals(), 
hashCode(), toString(), copy(), entre otras, lo que la hace especialmente útil 
para representar 
objetos de datos simples. Una Data Class se define de la siguiente manera:

```kotlin
data class NombreDeLaClase(val propiedad1: TipoDeDato, val propiedad2: TipoDeDato, ...)

```
Donde:

* NombreDeLaClase es el nombre de la clase.
* propiedad1, propiedad2, etc., son las propiedades de la clase con sus tipos de datos.
* TipoDeDato es el tipo de datos de cada propiedad.

La funcionalidad de la aplicación consiste en la creación de números aleatorios y 
el seguimiento de una lista de estos números. En lugar de almacenar estos números 
directamente en el ViewModel, se pueden encapsular en una Data Class para una 
gestión más eficiente. 
La nueva clase, llamada "RandomData," podría definirse de la siguiente manera:

```kotlin
data class RandomData(val numbers: List<Int>)

class MyViewModel : ViewModel() {
    // Resto del código...

    var randomData = mutableStateOf(RandomData(emptyList()))

    fun crearRandom() {
        val randomNumber = (0..3).random()
        val updatedNumbers = randomData.value.numbers.toMutableList()
        updatedNumbers.add(randomNumber)
        randomData.value = RandomData(updatedNumbers)
        Log.d(TAG_LOG, "Creamos random $randomNumber")
    }

    fun getListaRandom(): List<Int> {
        return randomData.value.numbers
    }

    // Resto del código...
}

```

En este código, hemos definido una clase "RandomData" como una Data Class que almacena la lista de números aleatorios. La función "crearRandom" ahora actualiza el estado de "randomData" en lugar de manipular la lista directamente. La función "getListaRandom" se ha modificado para acceder a la lista desde "randomData" en lugar de "numbers."

Esta adaptación permite un mejor encapsulamiento de los datos y facilita la gestión de la lista de números aleatorios en la aplicación.
