# Desarrollo de un chat con arquitectura cliente/servidor

## Enunciado ejercicio

El objetivo es desarrollar un sistema de chat cliente/servidor mediante sockets en TCP/IP.

**El servidor**

* Permitirá conectar varios clientes de chat simultanemente, hasta un máximo de 10.
* Dispondrá de una única sala de chat a la que se conectarán todos los clientes.
* Cada usuario tendrá un nickname que se le solicitará antes de establecer la conexión con el servidor.
* Mostrará por pantalla todos los mensajes que se reciban desde los clientes a medida que van llegando, indicando "nickname: mensaje..."
* Cada mensaje que se reciba será reenviado a todos los clientes, incluyendo el nickname correspondiente.
* Al arrancar el servidor, se solicitará el puerto por lo que se establecerá la conexión.
* Cada vez que se conecte un nuevo cliente, se indicará por pantalla: Nuevo cliente conectado (nickname ) Actualmente hay x usuarios conectados.
* Mientras no se conecte ningún usuario, o se todos los clientes se desconectan, se mostrará el mensaje "Ningún cliente conectado".
* Si el servidor se cierra, todos los clientes cerrarán adecuadamente sus conexiones tras mostrar el mensaje "El servidor se desconectó".

**Los clientes**

* Al arrancar se solicitará la dirección IP y el puerto de conexión del servidor. A continuación se solicitará el nickname que se empleará para identificar los mensajes del usuario, y se realizará la conexión con el servidor.
* Una vez conectado, se mostrarán los mensajes recibidos en la pantalla.
* Si el usuario escribe un mensaje, será enviada al servidor para su reenvío a todos los demás clientes.
* El cliente admitirá un comando /bye que hará que se cierre la conexión con el servidor y salga del programa.
* Cada vez que un nuevo cliente se conecta: en el cliente aparecerá un mensaje indicando "Conectado a la sala de chat" se mostrará a todos los participantes a mensaje "nickname acaba de conectarse la este chat."
* Cada vez que un nuevo cliente se desconecta, se mostrará a todos los participantes a mensaje "nickname dejó este chat."
* Cada vez que se escribe un mensaje, a todos los clientes se les mostrará el mensaje con el formato "nickname: mensaje"
* En cualquier caso, se deberán controlar los posibles errores y mostrar los correspondientes mensajes de manera controlada.


## Aclaraciones finales :warning:

Realmente los únicos archivos relevantes son **`Cliente1_v2.java`** y **`Servidor_v3.java`**. 

También, destacar que, las clases utilizadas para la interfaz gráfica son la de `IU.java` y `IU_inicioSesion.java`. 

Los demás archivos son prototipos que fui haciendo para lograr el resultado final. 
Estos no los borré con el fin de reflejar el proceso seguido.
