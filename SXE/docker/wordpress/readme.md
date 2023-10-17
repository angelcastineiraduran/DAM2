# WORDPRESS CON DOCKER
# Buscar información sobre el Compose de Docker
Ir a [Docker Hub]() y en el buscador escribir Wordpress
![Paso 1](imagenesReadme/dockerDocs.png)

Nos redirige el repositorio de Git Hub de docker [Git Hub de Wordpress](https://github.com/docker/awesome-compose/tree/master/official-documentation-samples/wordpress/) donde buscaremos el directorio de Wordpress

Aquí encontraremos un _readme_ detallado donde nos explicará paso a paso como crear un Wordpress en un contenedor Docker mediante un fichero _.yml_

Como indica la guía, hay que crear un directorio en nuestra máquina host (que es dónde almacenaremos el _yml_) y posteriormente, mediante la terminal, nos ubicamos dentro.

Copiamos el código del paso 3 y lo pegamos en un fichero vacío, al que llamamos "compose.yml", dentro del repositorio que hemos creado.

![Paso 2](imagenesReadme/dockerGH.png)

El siguiente paso es configurar el docker compose:

```yml
services:
  db:
    image: mariadb:10.6.4-focal
    command: '--default-authentication-plugin=mysql_native_password'
    volumes:
      - db_data:/var/lib/mysql
    # comentamos la siguiente linea para que no se incie cada vez que iniciamos en 
    # sistema?
    #restart: always
    environment:
      - MYSQL_ROOT_PASSWORD=somewordpress
      - MYSQL_DATABASE=wordpress
      - MYSQL_USER=wordpress
      - MYSQL_PASSWORD=wordpress
    expose:
      - 3306
      - 33060
  wordpress:
    image: wordpress:latest
    volumes:
      - wp_data:/var/www/html
    ports:
      - 80:80
    restart: always
    environment:
      - WORDPRESS_DB_HOST=db
      - WORDPRESS_DB_USER=wordpress
      - WORDPRESS_DB_PASSWORD=wordpress
      - WORDPRESS_DB_NAME=wordpress
volumes:
  db_data:
  wp_data:
```
Este archivo lanzará dos conetenedores, uno donde se alojará la web y el otro donde se alojará la base de datos de MariaDB

* `image`: En la imagen se especifica el servicio y su version separado por 2 puntos.
* `volumes`:  En este caso, los 2 volumenes se crean la primera vez que ejecutamos el `docker compose up`. Se especifica, separado de 2 puntos, el nombre del volumen y la ruta (en el contenedor) donde se ubica.
  <details>
      <summary>¿Por qué al ejecutar <i>docker volume ls</i> en "volume name" el nombre del volumen es "wordpress_db_data" y no "db_data"?</summary>
      <p>
      Cuando Docker Compose crea los volúmenes, puede modificar el nombre de esos volúmenes en función del proyecto y otros factores.
      Docker Compose utiliza el nombre del proyecto, que generalmente es el nombre del directorio donde se encuentra el archivo de configuración de Docker Compose, como un prefijo para los nombres de los recursos que crea, incluidos los volúmenes. Esto se hace para evitar conflictos entre proyectos y para garantizar la isolación entre ellos.
      </p>
  </details>
* `enviroment`:Con el atributo `enviroment` ponemos variables de entorno en los contenedores.
  * Si no se inicializa alguna de las variables, su valor por defecto sería una cadena vacía. Se recomienda inicializarlas para posibles futuros errores.
* `expose`: especifica los puertos que deben estar disponibles para otros contenedores en la misma red personalizada y no para la red host o para la pública. El servicio de Wordpress utilizará los puertos 3306 y 33060 para comunicarse con la base de datos.
* `ports`: se utiliza para mapear los puertos del contenedor a los puertos del sistema anfitrión, lo que permite que el servicio dentro del contenedor sea accesible desde el mundo exterior y desde otras máquinas en la red. 
PUERTO_DEL_SISTEMA_ANFITRIÓN:PUERTO_DEL_CONTENEDOR

  ![Diferencia entre expose y ports](imagenesReadme/dockerPortsVsExpose.png)






