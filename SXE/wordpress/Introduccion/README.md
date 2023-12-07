# INTRODUCCION

Hay que tener una estructura segregada.

CBN: para alamcenar imagenes, videos... (cosas estaticas).

## Primeros pasos

### 1. Hosting / Alojamiento
* Última tecnología disponible.
* PHP v7 min.
* Que te haga copias de seguridad.
* Buen servicio técnico 24/7 (mejor en español).
* Servidores buenos.

### 2. Sistema de preproducción (serv de prueba)
Mejores alternativas: 
* Local: docker o scotch box 
* No local: 
    * plugin de Wordpress (wp staging). Se hace dentro de la página de wp y se añade ese plugin.
    * plesk (software, extension: Wordpress Toolkit)
 
### 3. Obteniendo datos web

Analiticas generales:
* Google Analitics (+utilizado)
* Jepack (plugin, +sencillo)

Lo que sabe Google de nuestra web:
* Google Search Console

Velocidad web:
* Pigdom

Si nuestro sitio esta caído:
* Jetpack (plugin, ping cte y notificación si no lo consigue.)
* WPMUDEV ("")

### 4. Copia de seguridad

Se puede hacer desde el alojamiento (+automático) o mediante un plugin.

Buscamos "backup" en la barra de busquedas en [wordpress.org](wordpress.org)
y escogemos el que + estrellitas, + instalaciones...

Ideal copia seguridad diaria y la podemos mandar a distintos sitios.

### 5. Seguridad

Seguridad adicional dentro de wp, plugins (instalar solo 1 de ellos):
* Wordfence security
* iThemes security
* Securiti Security

CloudFlare: nos hace de filtro entre el trafico que llega a nuestra web (free).

CDN (Content Delivery Network / Red de ditribucion de contenido): coge todas las imagenes y videos (contenido estatico) se lo carga en sus propios servidores y despues los sirve al usuario desde el sitio web más cercano al usuario. 
* MaxCDN (+utilizado)
* Photon (servicio de Jetpak)

Optimizacion:
* Machete (plugin)

Mejorar velocidad:
* Mejoras WPO para WordPress (plugin)

### 6. Administracion de muchos sitios WordPress desde un único sitio
Servicio Wpmudev (de movistar). 

## Bibliografia
[Open webinar: Administracion de Sitios Wordpress](https://openwebinars.net/academia/aprende/administracion-wordpress-profesional/3410/)
