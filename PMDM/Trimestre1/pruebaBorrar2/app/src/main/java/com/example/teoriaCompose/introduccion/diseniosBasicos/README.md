# Disenios Basicos

## SearchBar

...

## Alineacion
_Objetivo: Alinear txt horizontalmente estableciendo
la alineacion de la `Column`_

En general, para alinear los elementos componibles
dentro de un elemento superior (`Column` supongo),
tendras que establecer la alineacion de ese contenedor superior.
Por lo tanto, en lugar de indicarle al elemento secunadio
(la imagen supongo) que se posicione en su elemento superior,
debes indicarle al elemento susperior el modo en que se deben alinear sus 
elementos secundarios.

En la `Column` tu debes indicarle como se deben alinear
sus elementos secundarios. Opciones:
* `Start`
* `CenterHorizontally`
* `End`

En la `Row`, estableceras la alineacion vertical. Opciones:
* `Top`
* `CenterVertically`
* `Bottom`

En el `Box` combinaras la alineacion vertical y horizontal. Opciones:
* `TopStart`
* `TopCenter`
* `TopEnd`
* `CenterStart`
* `Center`
* `CenterEnd`
* `BottonStart`
* `BottonCenter`
* `BottomEnd`

**Todos** los ele secunadarios del contenedor seguiran este
**mismo** patron de alineacion. Puedes **anular**
el comportamiento de un solo elemento secunadario
si le agregar un modificar `align`.


A menudo, existen varias formas de obtener el mismo resultado, por lo que tu implementación 
puede diferir un poco de la solución propuesta. Por ejemplo, en general, puedes usar un Spacer o 
configurar un padding, y ambos tendrán el mismo resultado visual

## FavouriteCollectionCard
Este contenedor usa surfaceVariant como su color de fondo, 
que es diferente al de fondo de pantalla.

Para añadir esquinas redondeadas usar el parametro `shape`
y no el elemento `Shape` como en el caso de la imagen anterior
(al contrario que la imagen anterior usare un valor que proviene
de nuestro tema Material).

## Listas ...
[Me quede aqui](https://developer.android.com/codelabs/jetpack-compose-layouts?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#6)
