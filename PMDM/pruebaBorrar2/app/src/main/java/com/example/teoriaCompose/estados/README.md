# Estados
Introduccion y ElevacionEstado en la web introduccion de compose

Mas informacion estados [aqui](https://developer.android.com/codelabs/jetpack-compose-state?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state#0)

El estado en Compose es cualquier valor
que se puede cambiar con el tiempo.

Evento: Cualquier acción que ocasione la modificación de un estado.

Si bien el estado de la app ofrece una descripción 
de lo que se mostrará en la IU, 
los eventos son el mecanismo mediante 
el cual cambia el estado, lo que genera cambios en la IU.

> Idea clave: El estado es. Los eventos suceden.

Ciclo:
1. Evento. El usuario o alguna otra parte del programa 
genera un evento.
2. Estado de actualizacion. Un controlador de eventos 
cambia el estado que usa la IU.
3. Estado de visualizacion. Se actualiza la IU a fin
de mostrar el estado nuevo.

## Composicion y recomposicion

* Composicion: Es una descripcion de IU que compila
JetPack Compose cd ejecuta elementos de componibilidad.
* Recomposicion: Es una nueva ejecucion de los elementos
de componibilidad cuando los datos cambian.
* Composicion Inicial: Es la creacion de una composicion
mediante la primera ejeccuion de elementos de componibilidad.

Para ello Compose necesita saber de qué estado
tiene que hacer seguimiento, a fin de que cd 
reciba una actualizacion pueda programar una recomposicion.

Usa los tipo `State` y `MutableState` de Compose
para que Compose pueda observar el estado.

Compose realiza un seguimiento de cada 
elemento de componibilidad que las propiedades
`value` del estado y activa una recomposicion
cd cambia su `value`.

Puedes usar la funcion `mutableStateOf` para crear 
un `MutableState` observable. Recibe un valor inicial
como un parametro que esta unido a un objeto `State`, 
lo que luego hace que su `value` sea observable.

## remember
Un valor calculado por remember se almacena en la composición 
durante la composición inicial, y el valor almacenado se conserva entre recomposiciones.

_
Un valor calculado por remember
se almacena en la composición durante la composición inicial, 
y el valor almacenado se conserva entre recomposiciones.
_

[...Me quede en este punto...](
https://developer.android.com/codelabs/jetpack-compose-state?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state#5
)

## DUDAS
Recolver lo de var/val para el tipo `MutableState`