# Ejercicio Odoo

Siguiendo la docu oficial https://www.odoo.com/documentation/16.0/es/developer/tutorials/getting_started/01_architecture.html

## Arquitectura

1. Presentacion tier
HTML + JavaScript + CSS

2. Logic tier
Python

3. Data tier
PostgreSQL

## Modulos Odoo

Las extensiones server y cliente son empaquetadas como modulos.

Modulo es un conjunto
de funciones y datos que tienen un obj común.

Los principales módulos orientados al usuarios están expuestos como **Aplicaciones**
(pero la mayoria de los modulos NO son app).

Los modulos tambien pueden ser referenciados como **addons**.

### Composicion modulos

1. Business objects

* Declarados como clases Python.
* Campos definidos en esa clase mapeados a las columnas de db gracias a **ORM** layer.

2. Object views

* UI

3. Data files

* archivos XML/CSV declarando el model data.

4. Web controllers

* Peticiones manejadas de los navegadores
* static web data: imagenes, css, js

### Estructuras modulos

Módulo odoo declarado en el **manifest**.

Cd el modulo incluye "business objects" (arch python) son organizados
como paquetes Python con un `__init__.py`
