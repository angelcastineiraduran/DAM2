# Ejercicio de clase: Ciclo de Vida
## Resumen de estados
1. `onCreate()`
Nos permite referenciar nuestra pantalla de la GUI con la lógica en Activity. Primer método que se
ejecuta. Refenciamos el layout mediante `setContentView()`
2. `onStart()`
Despues de crear la app, se lanza para que el usuario pueda ver la pantalla que tenemos contruída.
Es aquí cuando la vista y la actividad se hace interactiva para el ususario.
3. `onResumen()`
Ya tenemos los componentes gráfico que estarán en espera para que el usuario empiece a interactuar 
con la app. Aquí se va a capturar lo que el usuario ingrese y los eventos iniciados (por ejemplo
presionar un botón).
4. `onPause()`
Cuando usuario quiere cambiar a otra pantalla o minimizar la app. Cuando el usuario vuelve
a entrar en la app volveríamos a un estado `onResume()` y seguimos el ciclo.
5. `onStop()`
Cuando la actividad ya no es visible para el usuario. A continuación tendríamos dos opciones:
* El usuario regresa --> `onRestart()`
* No "" --> `onDestroy()`
6. `onResumen()`
7. `onDestroy()`
Ultimo estado por el que pasa la Activity. Para cerrar procesos o matar recursos antes de que 
se cierre la app.
