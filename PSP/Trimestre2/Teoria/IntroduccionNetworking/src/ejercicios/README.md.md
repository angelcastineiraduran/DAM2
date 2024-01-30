# EJERCICIOS

## Ejercicios de Pildoras informaticas yt

### Ejercicio 1 - PASOS

#### CLIENTE

1. Creacion Interfaz grafica

Después de codificar el desieño de las ventanas hay que añadir un 
`actionPerformed()` al btn enviar que cuando se accione este boton
se mande el msj del `JTextField` 
 de **CLIENTE** a 
el `JTextArea` de **SERVIDOR**. 

-----

2. Creacion socket

Hay que realizar un puente para establecer una comunicacion entre el servidor
y el cliente

Clase `Socket`
* paquete `java.net`
* Constructor param lanza excep de tipo `IOException`

El socket lo definimos en el `actionPerformed` pq voy a querer establecer esa
comunicacion entre cliente-servidor cuando se quiera mandar ese msj, es decir,
cuando se accione el btn enviar.

----

3. Creación flujo

Establecer un flujo de comunicación entre cliente-servidor utilizando el socket
que acabamos de crear.

Para ello primero tenemos que crear un flujo de datos de salida desde el cliente.

El constructor de `DataOutputStream` nos pide un arg de tipo `OutputStream`.
Para ello, si vamos a API de la clase `Socket`, vemos que tenemos un metodo que 
nos devuelve un `OutputStream` correspondiente a una salida de flujo de ese socket.

En definitiva, cd instanciamos el `DataOutputSream` nos pide que indiquemos por donde
van a circular ese flujo de datos, que en este caso es por ese socket.

> Conclusion: hemos creado un flujo de salida y ese flujo de salida va a circular
por ese socket  

----

A continuacion le tenemos que indicar a ese flujo de salida que es lo que tipo de
datos van a circular por el mismo: `flujoSalida.writeUTF(lblEscribir.getText());`

---

Por ultimo cerramos el flujo para que no se quede abierto con `.close()`

----
----

#### SERVIDOR

**Planteamiento**

Hay que poner el la clase que hace de servidor a la escucha en el puerto que 
hayamos puesto en la clase que hace de cliente.

El servidor tiene que hacer 2 tareas:
* Tarea 1: Escribir en el area de txt el msj del cliente.
* Tarea 2: Estar a la escucha (con la ventana  abierta) constantemente y SIMULTÁNEAMENTE.
_Una tarea va a estar en primer plano y la otra en segundo plano__

Como lo hacemos? con los **hilos**.

1. Crear GUI

2. Crear hilo 1

Hacer que la clase `MiMarcoServidor` implemente `Runnable`













