# Trabajando con volumenes
## 1. Descarga la imagen 'httpd' y comprueba que está en tu equipo.
```bash
$ docker pull http # descargo imagne de Docker Hub
$ docker image ls # listo las imagenes
```
## 2. Crea un contenedor con el nombre 'dam_httpd'.
```bash
$ docker run -dti --name dam_httpd httpd 
$ docker ps # liso contenedores
```

## 3. Mapea el puerto 80 del contenedor con el puerto 8000 de tu máquina.
```bash
$ docker ps # compruebo puertos que esta exponiendo el contenedor
CONTAINER ID   IMAGE     COMMAND              CREATED          STATUS          PORTS     NAMES
7c70cbefe8ff   httpd     "httpd-foreground"   36 minutes ago   Up 36 minutes   80/tcp    dam_httpd

```
