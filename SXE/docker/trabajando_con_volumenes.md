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
Los servidores web suelen utilizar el 80 o 8080 para escuchar http

Como el direccionamiento de puertos solo puede ser especificado caundo ejecutamos el comando `docker run` o `docker create`, 
no podemos mapear el puerto 80 de mi contenedor con el 8000 de mi máquina. Sin embargo, podemos hacer una instantánea de
nuestro contenedor para crear una nueva imagen basada en el mismo y así podemos mapear los puertos:
```bash
# creamos imagen basada en el contenedor "dam_httpd"
$ docker commit dam_httpd dam_httpd_image
sha256:49a19da0799201128485b3f9d7b5e5d3de812ff1e82919fd2fdca4824ab2f9d5

# lanzamos nuevo contenedor basado en la imagen anteriormente creada y mapeando los puerto
$ docker run --name dam_httpd_v2 -tdi -p 8000:80 dam_httpd_image 
0683afe191f74170875481759d1166d85da05f8456f9074451513a907130cdc5

# comprobamos
$ docker ps
CONTAINER ID   IMAGE             COMMAND              CREATED             STATUS             PORTS                                   NAMES
0683afe191f7   dam_httpd_image   "httpd-foreground"   2 minutes ago       Up 2 minutes       0.0.0.0:8000->80/tcp, :::8000->80/tcp   dam_httpd_v2
7c70cbefe8ff   httpd             "httpd-foreground"   About an hour ago   Up About an hour   80/tcp                                  dam_httpd


```
