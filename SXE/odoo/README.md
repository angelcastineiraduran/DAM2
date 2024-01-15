# Tarea: Odoo Instalación

Configura Odoo con docker-compose
* Usar docker-compose
* Configura Postgresql y realizas pruebas
* Configura Odoo y enlazalo con el contenedor de Postgtresql
* Enlazar PyCharm con el docker y con la base de datos

Entrega el repositorio con los ficheros y en el Readme la explicación.

En el readme tiene que estar explicado las diferentes partes del docker-composer, asi como comandos para lanzar los contenedores.

¿Que ocurre si en el ordenador local el puerto 5432 está ocupado? ¿Como lo puedes solucionar?

Se valora formato del Readme, capturas, commits, funcionalidad, capturas.

## Creacion compose
Busco la imagen oficial en ![docker hub](https://hub.docker.com/_/odoo) y voy a la parte de los ejemplos de Docker Compose. Copio y pego en mi fichero .yml el codigo del compose más simple. Añado la linea que me permite mapear los puertos para que me permita establecer una conexion desde fuera (desde
PyCharm) hacia dentro (contenedor de Docker).

En mi caso, el puero 5432 ya está ocupado en mi máquina host por lo que tengo que utilizar otro puerto.

## Conectar PyCharm a la base de datos de Odoo


> Para saber los puertos ocupados `netstat -putan` creo
