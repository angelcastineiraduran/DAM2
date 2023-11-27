# Conceptos basicos
GTK+ sigue el paradigma del modelo de programacion
basado en eventos.

1. Mientras el usuario no hace nada, GTK+ se ubica en 
el bucle principal en estado de espera hasta que
ocurre un evento de interacción.

2. Cuando un widget recibe detecta una interaccion,
emite una señal. Por ejemplo un boton emite 
la señal "clicked" cuando es presionado.

3. La función `connect()` se utiliza para asociar
una señal con una funcion especifica, conocida 
como devolución de llamada (callback)

```python
widget.connect("event", callback, data)
```
* `event` nombre del evento especifico.
* `callback` la funcion que se ejecutara cd se emita
la señal.
* `data` datos opcionales que se pueden pasar
a la devolución de llamada.

Esta funcion devuelve el numero que identifica 
este par señal-devolucion de llamada.

Es necesario desconectarse de una señal para
que la "callback" no se llame durante ninguna 
emisión futura o **en curso a la señal que se 
esta conectando**

```python
widget.disconnect(handler_id)
```
## Propiedades

## Widgets
Galería de widgets [aquí](https://python-gtk-3-tutorial.readthedocs.io/en/latest/gallery.html)