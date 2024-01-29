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

### TCP (introduccionTPC)

Un socket de un servidor esperara peticiones que vengan dentro de la red.
Actúa sobre esas peticiones y puede que envie una respuesta.

Este trabajo es hecho por `SocketImpl` 

`ServerSocket` objetivo: esperara y aceptar conexiones entrantes desde clientes.

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




