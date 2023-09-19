# Práctica: Docker - Comandos básicos
> La siguiente práctica es una lista de tareas que tenéis que hacer. Por cada tarea tenéis que ir poniendo los comandos utilizados y, brevemente, describir el proceso

## 1. Descarga la imagen 'ubuntu y comprueba que está en tu equipo

```bash
> docker pull ubuntu
Using default tag: latest
latest: Pulling from library/ubuntu
445a6a12be2b: Pull complete
Digest: sha256:aabed3296a3d45cede1dc866a24476c4d7e093aa806263c27ddaadbdce3c1054
Status: Downloaded newer image for ubuntu:latest
docker.io/library/ubuntu:latest

# Comprobamos que la imagen se ha descargado correctemente:
> docker image ls
REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
ubuntu       latest    c6b84b685f35   4 weeks ago   77.8MB
```

## 2. Crea un contenedor sin ponerle nombre. ¿está arrancado? Obtén el nombre

```bash
# contenedores
> docker run ubuntu

# todos los contenedores
> docker ps -a
CONTAINER ID   IMAGE     COMMAND   CREATED         STATUS                     PORTS     NAMES
7ae051a9f050   ubuntu    "bash"    3 seconds ago   Exited (0) 2 seconds ago             heuristic_shirley
```
Como elcontenedor no está levantado aún, tenemos que añadir el parámetro `-a` para que me muestre también los contendores que no están levantados.

Si queremos levantarlo al crealo tenemos ejecutar el siguiente comandos:
donde `-t` terminal y `-d` detach
```bash
> docker -t -d run ubuntu
```


> Si no hubieramos hecho el `pull` previamente, se haría ahora la descarga y tendríamos la siguiente salida
```bash
> docker run ubuntu
Unable to find image 'ubuntu:latest' locally
latest: Pulling from library/ubuntu
445a6a12be2b: Pull complete
Digest: sha256:aabed3296a3d45cede1dc866a24476c4d7e093aa806263c27ddaadbdce3c1054
Status: Downloaded newer image for ubuntu:latest
```
Como no encuentra la imagen localmente en nuestro equipo, la descarga de [Docker Hub](https://hub.docker.com)


## 3. Crea un contenedor con el nombre 'dam_ubu1'. ¿Como puedes acceder a él?

```bash
docker run --name dam_ubu1 ubuntu bash

# Comprobamos que se ha creado con el nombre
> docker ps -a
CONTAINER ID   IMAGE     COMMAND       CREATED              STATUS                          PORTS     NAMES
7b569f45cd71   ubuntu    "/bin/bash"   About a minute ago   Exited (0) About a minute ago             dam_ubu1
3f837aa4499a   ubuntu    "/bin/bash"   15 minutes ago       Exited (0) 15 minutes ago                 eager_darwin
```
Efectivamente comprobamos que el contenedor con el ID **7b569f45cd71** tiene el nombre que hemos escogido

A continuación nos metemos dentro del contenedor:
```bash
docker exec -it ejemplo sh
```
