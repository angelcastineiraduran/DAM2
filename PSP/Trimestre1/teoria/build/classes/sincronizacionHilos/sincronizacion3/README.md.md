# Ejercicio Banco
_
Soy el banco y creo 100 cuentas bancarias e ingreso 2,000$ en cada
una de esas cuentas (saldo total 200,000$). Realizar transferencias internas
(en un bucle infinito de forma aleatoria) entre hilos (el saldo total sigue siendo el mismo).
Cada una de las transferencias la hace un hilo y repito, el saldo
    total tiene que ser el mismo.
_

## PRIMERA PARTE
Funciona pero hay en algunos momento donde el saldo total varia aunque vuelve
constantemente a su estado inicial. Esto no debería ser así ya que el saldo total
debería ser siempre el mismo. Eso yo creo que es porque al hacerse transferencias todo
el rato sin esperar unas a las otras afecta el saldo total  de tal forma que 
a veces se imprime el saldo total sin haber acabado previamente el hilo anterior y por eso varia.
Esto se solucionaria sincronizando los hilos.

Ejemplo de salida:
```java
Thread[Thread-16,5,main]
    395,48 de 16 para 32Thread[Thread-10,5,main]
   1730,56 de 10 para 32Saldo total:  200000,00
Thread[Thread-10,5,main]
Thread[Thread-64,5,main]
    161,32 de 64 para 92Saldo total:  199803,77
Saldo total:  200000,00
Thread[Thread-84,5,main]
    548,04 de 84 para 27Saldo total:  199803,77
    196,23 de 10 para 70Saldo total:  200000,00
Thread[Thread-71,5,main]
     84,25 de 71 para 95Saldo total:  200000,00
Thread[Thread-12,5,main]
    198,67 de 12 para 27Saldo total:  200000,00
BUILD STOPPED (total time: 8 seconds)
```
(volver a ver el video)

## SEGUNDA PARTE

## Condiciones Bloqueos

_ 
Ahora queremos hacer que cuando un hilo entrea en el if (porque la cantidad 
es mayor al saldo que hay en la cuenta) en vez de hacer un return, que espere 
hasta que otro hilo le haga una transferencia de la cantidad suficiente como para 
poder realizar la anteior operacion
_

Para crear una condición tenemos que utilizar `newCondition()` para que me 
devuelva un obj de tipo `Condition`.

Con esta nueva modificacion los hilos que entran y no tienen el saldo suficiente
NO mueren, si no que se quedan a la espera de tenerlo. De esta forma todos los hilos
realizan transferencias.

## Synchronized

Esta forma mas facil que la anterior. Usar esta siempre y cuando no haya mas de
una condicion ya que si no seria la anteior mas practica.

