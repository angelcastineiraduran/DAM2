# Creacion de app en Odoo
Entramos en ![docker hub de la imagen oficial de Odoo](https://hub.docker.com/_/odoo/).

Copiamos y pegamos el código del tercer ejemplo del 
apartado de "Docker Compose examples" en un fichero .yml que hayamos
creado en nuestra maquina host. En mi caso hice una carpeta donde incluí 
ese .yml y meteré los demás archivos correspondientes a ese Odoo.

Borro las lineas que no me interesen del compose y añado algunas otras
que me interesan del docker compose subido en Esemtia sobre Odoo. Finalmente lo ejecuto 
con `docker compose up -d`.

Si hacemos u n`ls` en la ubicación donde tengo el compose
observamos que se crean 2 nuevas carpetas, una de ellas correspondiente
a las futuras app de nuestro odoo "addons"

```bash
 ~/DAM2/SXE/odoo/creacionAppOdoo | main ?1 ............................................................... 14:37:36 
> ls
addons  config  docker-compose.yml  README.md
```
