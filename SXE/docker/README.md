# Práctica: Docker - Comandos básicos
La siguiente práctica es una lista de tareas que tenéis que hacer. Por cada tarea tenéis que ir poniendo los comandos utilizados y, brevemente, describir el proceso

## 1. Descarga la imagen 'ubuntu y comprueba que está en tu equipo

```bash
$ docker pull ubuntu
Using default tag: latest
latest: Pulling from library/ubuntu
445a6a12be2b: Pull complete
Digest: sha256:aabed3296a3d45cede1dc866a24476c4d7e093aa806263c27ddaadbdce3c1054
Status: Downloaded newer image for ubuntu:latest
docker.io/library/ubuntu:latest
# Listamos imagenes descargadas
$ docker image ls
REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
ubuntu       latest    c6b84b685f35   4 weeks ago   77.8MB
```

## 2. Crea un contenedor sin ponerle nombre. ¿está arrancado? Obtén el nombre
Lanzamos el contenedor con la imagen de ubuntu con la última version `ubuntu:latest
```bash
$ docker run -dit ubuntu:latest bash
56d1e0ae5ce9424310dc1ad604b8ed3341c755ee4ceb53a0ecad2ccfccb90ed5
```
Parametros
* `-d` (detach) para que podamos utilizar el terminal mientras se lanza.
* `-i` y `-t` para crear una sesion interactiva del terminal dentro del contendor.

`bash` es el comando que se ejecutará dentro del contenedor una vez se inicie, es un intérprete de comandos y en este caso lo utilizamos porque es compatible con nuestro Sistema Operativo.

Comprobamos que está arrancado con el comando `ps` el 
```bash
$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS         PORTS     NAMES
56d1e0ae5ce9   ubuntu:latest   "bash"    4 seconds ago   Up 3 seconds             lucid_goodall
```

> Si no hubieramos hecho el `pull` previamente al levantar el contenedor no encontraria en local ninguna imagen y por tanto se descagaría la misma de [Docker Hub](https://hub.docker.com)

## 3. Crea un contenedor con el nombre 'dam_ubu1'. ¿Como puedes acceder a él?

```bash
$ docker run -dti --name dam_ubu1 ubuntu:latest bash
# Comprobamos que se ha creado con el nombre
$ docker ps
```

A continuación nos metemos dentro del contenedor:
```bash
$ docker exec -it dam_ubu1 bash
root@7e44cbf9cedd:/# 
```
`exec` te permite ejecutar un comando dentro de un contenedor en ejecución

## 4. Comprueba que ip tiene y si puedes hacer un ping a google.com
```bash
# salimos del contenedor
$ exit
# comprobamos ip
$ docker inspect dam_ubu1
```
La salida muestra un objeto "Networks" que muestra a las redes a las que está conectado el contenedor. Este está conectado a una red de tipo "bridge" y su dirección IP es "IPAddress": "172.17.0.3"

Ping a google.com
```bash
# Nos metemos en el contenedor...
# Instalamos el paquete iputils-ping
root@7e44cbf9cedd:/# apt install iputils-ping
# Realizamos el ping a google (enviamos 2 paquetes)
root@7e44cbf9cedd:/# ping -c 2 8.8.8.8
PING 8.8.8.8 (8.8.8.8) 56(84) bytes of data.
64 bytes from 8.8.8.8: icmp_seq=1 ttl=117 time=19.6 ms
64 bytes from 8.8.8.8: icmp_seq=2 ttl=117 time=20.6 ms

# Otra alternativa desde fuera del contenedor:
$ docker exec -it dam_ubu1 ping -c 2 8.8.8.8
```

## 5. Crea un contenedor con el nombre 'dam_ubu2'. ¿Puedes hacer ping entre los contenedores?
Como no hemos especificado el tipo de red asociada al contenedor, ambas fueron creadas con el tipo **brige** el cual nos permite una comunnicación entre contenedores del mismo host. 

_Tanto los contenedores como el tipo de red tienen que estar en ejecución para que sea posible_
```bash
# comprobamos que esta corriendo el tipo de red asociada a esos contenedores
$ docker network ls
# Averiguamos ip de los 2 contenedores
$ docker inspect dam_ubu1 | grep IPAddress # "IPAddress": "172.17.0.3",
$ docker inspect dam_ubu2 | grep IPAddress #  "IPAddress": "172.17.0.4",
# hacemos ping desde fuera de los contenedores (tambien se puede hacer desde dentro)
$ docker exec -ti dam_ubu1 ping -c 2 172.17.0.4
```
Con `inspect` nos devuelve la info de red de ese contenedor y con `grep` filtramos el contendo para que nos devuelva solo la IP

## 6. Sal del terminal, ¿que ocurrió con el contenedor?
```bash
# salimos del contenedor
root@7e44cbf9cedd:/# exit
exit
# comprobamos estado del mismo 
$ docker ps -a
```
El contenedor sigue levantado. Si queremos pausarlo o pararlo utilizamos las palabras reservadas
de `pause` y `stop` respectivamente.

## 7. ¿Cuanta memoria ocupaste en el disco?

```bash
# Comando de docker 
$ docker system df
TYPE            TOTAL     ACTIVE    SIZE      RECLAIMABLE
Images          1         1         77.82MB   0B (0%)
Containers      4         3         47.74MB   31B (0%)
Local Volumes   1         1         11B       0B (0%)
Build Cache     0         0         0B        0B

# Comando de shell (tradicional)
$ sudo du -sh /var/lib/docker/
426M	/var/lib/docker/
```

Si añadimos el parámetro `-v` nos da información más detallada.
Si queremos sólo ver el espacio de las imagenes `docker image ls` y sólo el de los contenedores `docker ps --size`.

## 8. ¿Cuanta RAM ocupan los contenedores? ¿Hay algún comando docker para saber esto?
```bash
$ docker stats --all
CONTAINER ID   NAME            CPU %     MEM USAGE / LIMIT     MEM %     NET I/O          BLOCK I/O     PIDS
1c4cceac8bec   dam_ubu2        0.00%     884KiB / 15.52GiB     0.01%     9.27kB / 840B    0B / 4.1kB    1
f13c02a2865a   ubu2            0.00%     0B / 0B               0.00%     0B / 0B          0B / 0B       0
7e44cbf9cedd   dam_ubu1        0.00%     47.91MiB / 15.52GiB   0.30%     29.2MB / 622kB   0B / 76.1MB   2
56d1e0ae5ce9   lucid_goodall   0.00%     884KiB / 15.52GiB     0.01%     16.3kB / 0B      0B / 0B       1

```
Utilizamos `--all` para que me muestre todos los contenedores incluidos los que no están levantados (ubu2).





