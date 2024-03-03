# Conexion contenedor mediante SSH

Entramos como root en los contenedores `$ docker exec -u root -it tareaentornoymodulo-db-1 bash` y: 

1. Instalamos SSH

```bash
$ apt install openssh-server
```

2. Cambiamos contraseña usuario

```bash
# --OPCION 1: mala practica--
# Cambiamos contraseña del usuario `root` para conectarnos al servicio 
desde este.
$ passwd

# --OPCION 2: buena practica--
# Creamos un nuevo usuario para conectarnos al servicio
$ useradd -m angel
$ passwd angel
```

> contraseña root: 1234

Si hago un nuevo usuario para conectarme, le tengo que dar todos 
privilegios (en este caso le daria todos aunque no fuese recomendable):

```
# instalo vim y sudo para poder utilizar `visudo` y darle todos los privilegios a el nuevo usu
$ apt-get install vim & apt-get install sudo
$ visudo
```

En el fichero modificar:

```vim
# User privilege specification
root    ALL=(ALL:ALL) ALL
angel   ALL=(ALL:ALL) ALL
```

Reiniciamos SSH: `$ service ssh restart`

3. Permitimos acceso por SSH -- NO SE SI ES NECESARIO ESTE PASO

```bash
$ apt-get install vim
$ vim /etc/ssh/sshd_config
```

Descomentar y modificar linea: `PermitRootLogin yes`

Reiniciamos SSH: `$ service ssh restart`

4. Arranco ssh

```bash
$ service ssh start
# compruebo si esta levantado
$ service --status-all
```

Cada vez que el servidor se vuelva a iniciar tenemos que arrancar el servicio de ssh. 
Para que cada vez que se levante el contenedor inicie el servicio ssh `systemctl enable ssh`

5. Nos conectamos a contenedor mediante la bash

Averigurar ip contnedor

```bash
# nos dice solo la ip
$ docker inspect -f "{{ .NetworkSettings.IPAddress }}" [container-name-or-id]

# toda la info de red en bruto
$ docker inspect [container-name-or-id]

# nos aseguramos de que ponemos establecer conexion
$ ping -c 3 172.23.0.2
```

Conexion ssh

```bash
#$ ssh angel@localhost -p 5435 # no me funciona por el firewall creo
$ ssh -L 5435:localhost:5432 angel@172.23.0.2
```

Nos conectamos a postgres desde el puente de ssh creado `$ psql postgres odoo` (
creadenciales en el docker compose).

----------

Ahora tendria que establecer la conexion con el IDE siguiendo los tutoriales:

* https://www.youtube.com/watch?v=6RlgQBB1UDU
* https://www.jetbrains.com/help/pycharm/creating-a-remote-server-configuration.html
