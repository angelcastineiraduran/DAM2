# SINCRONIZACION
https://docs.oracle.com/javase/tutorial/essential/concurrency/simple.html

Sincronizacion para prevenir errores de interferencia y de consistencia
de memoria entre hilos.

Sin embargo la sincronizacion entre hilos puede
producir **contencion de hilos**. Esto se produce
cd 2 o más hilos intentan acceder al mismo recurso
simultaneamente y hacen que el tiempo de ejecución de 
Java ejecute 1 o + hilos lentamente o incluso suspenda
la ejecucion.

Algunas **formas de contencion** con: Starvation and livelock.

Orden lectura

## Interferencia - Clase `Counter`

**Interferencia**: Ocurre cuando 2 operaciones, corriendo en diferentes hilos,
pero actuando sobre los mismos datos, se entrelazan (interleave). Entonces los pasos
que forman esas operaciones se solapan.

Recordemos que pasos sigue la operacion `c++`:
1. Recupera el valor actual de `c`.
2. Incrementa el valor recuperado en 1.
3. Guarda el valor incrementado en `c`.

Pues teniendo esto presente, aunque los metodos que se den en la clase
`Counter` sean muy simples, **tambien podría haber interferencia**

_Ejemplo1: Imaginar que un hilo invoca `increment` al mismo tiempo
en el que un segundo hilo invoca el `decrement` siendo en este momento
el valor de `c=0`.

El resultado de la secuencia podría ser:

1. Thread A: Recupera c
2. Thread B: Recupera c
3. Thread A: Incrementa valor recuperado en 1 --> resltado = 1
4. Thread B: Decrementa valor recuperado en 1 --> resultado = -1
5. Thread A: Guarda el resultado en c; c = 1
6. Thread B: Guarda el resultado en c; c = -1

El resultado de A es **sobreescrito** por el del hilo B. Este seria un posible
escenario pero tambien es posible ne otro dd el resultado del hilo B sea sobreescrito.

## Errores de coherencia de memoria

Ocurren cd diferentes hilos tienen vistas inconsistentes de lo que deberia ser
los mismos datos.

Es parecido a lo que vimos hasta, ya que imaginate que el hilo B en vez de
decrementar c muestra su resultado, y accede al mismo tiempo que el hilo A.
Si estuvieran en el mismo hilo, B mostratia c=1 pero estando en != hilos 
y accediendo a la vez a c el resultado que printea es impredecible (0 o 1).

## Modos de sincronizacion

### Metodos sincronizados (synchronized methods)

El constructor no puede ser sincronizado usando `synchronized`.

Tambien hay que tener cuidado cuando un objeto es visible para más de un 
hilo. Todas las lecturas/escrituras de las variables de ese obj
se deberían hacer atraves de metodos sincronizados.

> Recordar con los campos con `final` NO pueden ser modificados despues
de que el objeto haya sido construido.

### Instruccions sincronizadas (synchronized statements) +COMPLICADO

Me quedé en este punto (sin leer):
"Intrinsic Locks and Synchronization" de 
https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
