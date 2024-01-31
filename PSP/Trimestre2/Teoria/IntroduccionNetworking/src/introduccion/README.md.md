# Introduccion

Socket: especie de puente virtual para comunicar cliente-servidor.

![clienteServidor](../imagenes/clienteServidor.png)

TCP
* orientado a conexion
* eficiente, respeta orden	

UPD
* orientado a velocidad
* no respeta orden
* puede que algunos paquetes se pierdan
* ej uso: streaming, video juegos…


## Primeros pasos: cliente-servidor con 2 main != (=HOST)

Socket: es uno de los puntos finales de una comunicacion entre 2 programas
corriendo en la red. Las clases de sockets son usadas para representar 
la conexion entre el cliente y el servidor. El paquete `java.net` provee 2 clases:

* `Socket` implementa el lado del cliente de la conexion.
* `ServerSocket` implementa el lado del servidor de la conexion.

> un endpoint (o punto final) es una combinacion de una IP addr y un numero de 
puerto. toda conexion TCP puede ser identificada por esos 2 endpoints

Otros conceptos

* Recordar que para que un cliente se contect a un servidor por un puerto 
que esta a la escucha, el cliente tambien necesita ser identificado por el servidor
asi que se enlaza con un numero de puerto local que estara usando durante su conexion.
**Este puerto es normalmente asignado por el sistema.**

### TCP (introduccionTPC)

Un socket de un servidor esperara peticiones que vengan dentro de la red.
Actúa sobre esas peticiones y puede que envie una respuesta.

Este trabajo es hecho por `SocketImpl` 

`ServerSocket` objetivo: esperar y aceptar conexiones entrantes desde clientes.

Cuando el cliente manda una peticion, el metodo `accept` acepta tal peticion 
y devuelve un tipo `Socket` que representa la conexion establecida **con ese
cliente especifico**. A partir de ese obj `Socket` se puede establecer una
**comunicación** (esta clase permite comuncicación BIDIRECCIONAL entre
cliente-servidor).

Envolviendo el `accept()` en bucle `while(true)`:
* SIN BUCLE WHILE. El servidor aceptara **una sóla** conexion y finalizará.
* CON "". "" Seguira aceptanto peticiones cte (Posibilidad manejo múltiples **simultaneamente** 
petis). IDEAL: después de recibir peticion, manejarla con otro hilo para que 
el servidor vuelva al estado de escucha.

Orden de lectura de las clases
1. `Servidor`
2. `Cliente`


* Pq se cierra el la instancia de tipo `Socket` 2 veces? (tanto en el servidor
como en el cliente)??

### UDP (introduccion UDP)

No necesitamos una clase que sea servidora, no hay un `ServerSocker` UDP. Si no que
trabaja con **datagramas**.


LO QUE ESTA EN LA GUIA DE ORACLE:
https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
NO LO ENTIENDO BIEN. Buscar info en otro sitio mejor explicado ya que es dificil
de entender.





