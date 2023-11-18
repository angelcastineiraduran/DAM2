# Eventos
* Cada interacion que tiene el usuario con una 
aplicación Qt es un *evento*.
* Qt representa estos eventos utilizando *objetos de 
evento* los cuales empaquetan información sobre lo sucedido.
* Estos eventos se pasan a *controladores de eventos* los
en el widget donde ocurrió la interacion.

## Controladores de eventos
* Se definen como cualquier otro método.
* Nombre es específico para el tipo de evento que manejan.

## Eventos
### Ejemplos
#### `QMouseEvent`
Este es uno de los principales eventos que reciben los widgets.
Es un objeto que representa un evento específico. Por lo 
tanto es un tipo de evento en el contexto de la GUI.
Controlar clicks y movimientos ratón. Ejemplos controladores:
* `mouseMoveEvent`
* `mousePressEvent`
* `mouseReleaseEvent` Boton del ratón liberado
* `mouseDobleClickEvent`

> Estos ejemplos de metodos, son metodos especificos
> de eventos que perteneces a clases que heredan de 
> `QWidget`, como `QMainWindow`, `QPushButton`, `QLabel`, 
> etc. Métodos específicos del ratón que se activarán 
> cuando ocurren acciones de ratón sobre esos widgets.

## Flow
_Ejemplo:_
1. Hago un click en un widget.
2. Se envía el evento: `QMouseEvent` al *controlador
de eventos*.
3. Este controlador (`mousePressEvent`) puede usar el 
*objeto del evento* para encontrar información
sobre lo sucedido.
4. Manejamos la información del objeto. Filtramos, 
clasificamos, podemos usar `super()`...

## Eventos del Mouse
### `QMouseEvent`
Todos los eventos del mouse se registran en este objeto.
La info del evento se puede leer en estos métodos
del evento:
* `.button()` Boton especifico que desencadeno el evento.
* `.buttons()` Estado de todos los botones del mouse.
* `.position()` Posición relativa del widget como un 
`QPoint` (numero entero).

> Estos métodos son partes de un objeto `QMouseEvent`.
> `QMouseEvent` es la clase que contiene info sobre un 
> evento del ratón específico y por ejemplo `.button()`
>  es un método de esa clase que devuelve el botón del 
> ratón que se presionó durante ese evento.

*Conclusión*. Método estilo `mouseMoveEvent` son métodos 
de manejo de eventos en los *widgets*, mientras que los 
métodos estilo `.button()` son métodos para obtener 
información sobre un evento del ratón específico.



