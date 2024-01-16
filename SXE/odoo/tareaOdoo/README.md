# INTRODUCCION
Configura Odoo con docker-compose
* Usar docker-compose
* Configura Postgresql y realizas pruebas
* Configura Odoo y enlazalo con el contenedor de Postgtresql
* Enlazar PyCharm con el docker y con la base de datos

Entrega el repositorio con los ficheros y en el Readme la explicación.

En el readme tiene que estar explicado las diferentes partes del docker-composer, asi como comandos para lanzar los contenedores.

¿Que ocurre si en el ordenador local el puerto 5432 está ocupado? ¿Como lo puedes solucionar?

Se valora formato del Readme, capturas, commits, funcionalidad, capturas.

## Docker compose
Busco en [docker hub](https://hub.docker.com/_/odoo) la imagen oficial de Odoo. En el apartado de
"Docker Compose examples", copio el código del primer ejemplo y lo pego en un fichero .yml dentro de mi proyecto. Este fichero corresponde a mi docker-compose.

### Servicio de PostgreSQL

Tengo hasta 4 variables de entorno:
* `HOST` nombre del contenedor que aloja la base de datos. Por defecto el nombre de la base de datos es "db".
Por lo tanto, si en el docker-compose no añadimos esta variable y la modificamos, odoo, por defecto
va a buscar la base de datos como "db". Es decir, si no añado esta variable de entorno
en el compose en el servicio web de odoo, y luego en el nombre del servicio de la base de datos, en vez
de ponerle "db" se lo cambiamos por defecto a "mydb" no me funcionaria. Para que funcionarse tengo que añadir
la variable de entorno HOST=mydb para indicarle a odoo que tiene que conectarse a un contenedor que levanta un servicio 
de base de datos que se llamara "db".
* `PORT` puerto del **gestor de la base de datos**
* `USER`
* `PASSWORD`

En todos los **gestores de bases de datos** me tengo que conectar con un usuario y una  contraseña. Siempre que los instalo se crea un usuario por defecto ("postgres").

> No es buena practica entrar con el usuario por defecto de postgres (el usuario administrador de la base de datos)
> para administrar la base de datos, 
> cada app deberia tener su propio usuario, en este caso "odoo".

Mapeo los puertos ya que si no, no me puedo conectar desde mi máquina host (desde PyCharm) a mi contenedor de docker.

En mi caso, al tener el puerto 5432 ocupado, tengo que modificar el puerto al que se mapea en mi host (nuevo puerto
elegido: 5433). Otra opción seria apagar el servicio que utiliza ese puerto para poder utilizarlo en Odoo.
Con el comando `sudo service postgresql stop` cancelo el servicio actual que está utilizando el puerto.

> Para comprobar que tengo un puerto activo `netstat -putan`

## Conexión con PyCharm
En el menú derecho de la app añado una conexion a una base de datos SQL. En las credenciales de conexión:

![conexionSQL](imagenes/testConnection.png)

## Configuracion de Odoo
Averiguo la IP de mi ordenador con `ip addr`.

En cualquier navegador busco la URL: http://DIRECCION_IP:8069

"DIRECCION_IP"
* localhost
* 10.0.9.19

Checkeamos el demo data para que el Odoo no nos quede demasiado vacío.

En este instalador hay que crear una nueva base de datos, la cual utilizara
odoo. La anterior bd y las variables de entorno que definimos realmente
creo que son solo para que odoo pueda conectarse a esa base dae datos con las
credenciales de superuser y asi crear una base de datos concreta para todo lo
relacionado con odoo.
