# Animaciones
## animate*AsState
Es una de las APIs mas simples de compose.

----

`animateDpAsState` muestra un obj State cuyo `value` se actualizara de forma continua en la animacion
**hasta que finalice**. Toma un "valor objetivo" cuyo tipo de `Dp`

### Animaciones dentro de las animaciones
Clase: `AnimateDpAsState2`.

Cualquier animacion creada con `animate*AsState` es interrumpible. Si el valor obj cambia en medio
de la animacion, `animate*AsState` la reinicia y la apunta al valor nuevo. Resultado = una animacion
mas natural.

_Ejemplo:_ este cambio es muy visual, imaginate que le demos muchas veces seguidas en un corto 
plazo de tiempo al boton. De esta forma se estaria actualizando todo el rato el "valor objectivo" por
lo que si le damos muchas veces en un corto periodo de tiempo, al actualizarse este valor, no llegaria
a acabar el recorredido de la animacion anterior. sin embargo, la animacion continua pero con un valor
final distinto.