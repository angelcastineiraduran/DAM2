# Chapter 1: Architecture

Siguiendo la docu oficial 
https://www.odoo.com/documentation/16.0/es/developer/tutorials/getting_started/01_architecture.html

1. Presentacion tier:
HTML + JavaScript + CSS

2. Logic tier:
Python

3. Data tier:
PostgreSQL

## Modulos Odoo

Las extensiones server y cliente son empaquetadas como modulos.

Modulo es un conjunto
de funciones y datos que tienen un objetivo común.

Los principales módulos orientados al usuarios están expuestos como **Aplicaciones**
(pero la mayoria de los modulos NO son app).

Los modulos tambien pueden ser referenciados como **addons**.

### Composicion modulos

1. Objetos de negocios

* Declarados como clases Python.
* Campos definidos en esa clase mapeados a las columnas de db gracias a **ORM** layer.

2. Archivos de datos

* XML, CSV de metadatos, datos conf, de demostracion...

3. Controladores Web

* Manejo peticiones web

4. Datos estaticos web

* static web data: imagenes, css, js

### Estructuras modulos

Módulo odoo declarado en el **manifest**.

Un modulo es tambien un paquete de python con un archivo `__init__.py` que contiene
instrucciones de importacion de varios archivos de python en dicho modulo.

Ejemplo: si un modulo tiene solo un archivo `mymodule.py`, el archivo `__init__.py` podría
contener: 

```python
from . import mymodule
```

Para crear un modulo vacio con archivos 
estandar: `$ odoo-bin scaffold <module name> <where to put it>` 
