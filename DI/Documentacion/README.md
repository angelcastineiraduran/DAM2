# Documentacion en Python

## Conceptos basicos

`docstring` es una cadena de documentacion

```python
def promedio(a, b):
    'Calcula el promedio de dos números.'
    return (a + b) / 2

# CADENA MULTILINEAS
def formula_cuadratica(a, b, c):
    """Resuelve una ecuación cuadrática.

    Devuelve en una tupla las dos raíces que resuelven la
    ecuación cuadrática:
    
        ax^2 + bx + c = 0.

    Utiliza la fórmula general (también conocida
    coloquialmente como el "chicharronero").

    Parámetros:
    a -- coeficiente cuadrático (debe ser distinto de 0)
    b -- coeficiente lineal
    c -- término independiente

    Excepciones:
    ValueError -- Si (a == 0)
    
    """
    if a == 0:
        raise ValueError(
            'Coeficiente cuadrático no debe ser 0.')
    from cmath import sqrt
    discriminante = b ** 2 - 4 * a * c
    x1 = (-b + sqrt(discriminante)) / (2 * a)
    x2 = (-b - sqrt(discriminante)) / (2 * a)
    return (x1, x2)

# -- ACCEDER A LA DOC--

# OPCION 1
# Todos los objetos que sean documentales tienen un 
# atributo `__doc__` el cual contiene su respectivo comentario.
promedio.__doc__ # > 'Calcula el promedio de dos números.'
formula_cuadratica.__doc__ # > ...

# OPCION 2
# usar help() --> +limpio pq + formateado
help(promedio)
```

**Cadena Multilineas:**

1. Primera linea: **UNA SOLA linea de resumen terminada por un punto**,
es una breve descripcion de la funcion que indica los efectos
de esta. Despes de acabar linea **espacio en blanco.**
2. Resto de cadenas debe definir el comportamiento funcion, los val
que devuelve, excep que arroja...
3. Se recomienda dejar linea en blanco antes de las ultimas
triples comillas que encierran el bloque.

## Generacion documentación en páginas HTML

En el caso de que las funciones
anteriores se ecnuentre en el .py: `ejemplos.py`

```bash
$ ls
ejemplos.html  ejemplos.py  __pycache__  README.md
$ pwd                        
/home/ubuntu/DAM2/DI/Documentacion
pydoc -w ejemplos
$ python -m pydoc -w ejemplos
# si aparece esto se ha creado correctamente
wrote ejemplos.html
```

Con el param `-w` eevuelve el archivo `ejemplos.html` que podemos
ver en el navegador en vez de printearlo por consola.

Otros params
```python
# busca una determinada palabra en todos los modulos
pydoc.py -k xml
# Con -p podemos iniciar el servidor HTTP en el puerto indicado.
pydoc.py -p puerto
```

> RECORDAR: tengo que estar dentro de un proyecto
> con entorno virtual

## Documentacion con Sphinx

Instalación

```bash
sudo apt install python3-pip
pip3 install sphinx sphinx_rtd_theme
```
Seguir tutorial: 
https://martinber.github.io/guia-sphinx/instalacion.html

Para responder a las preguntas:
https://pythonhosted.org/an_example_pypi_project/sphinx.html


## Archivos

`source/conf.py`:
* version y releases
* nombre autor y proyecto
* logo de proyecto
* estilo por defecto seleccionar: `sphinx` o `default` (`default` es lo que
usa la documentacion oficial de python). Esto lo lo veo en la carpeta, NO LO TOCQUE!

`source/index.rst` 

Plantilla de la página de inicio de la documentación generada. 
Está estructurada en formato reStructuredText. 
Este formato permite crear plantillas que le sirven a Sphinx para estructurar 
la información extraída de los ficheros de código fuente.

## Generar documentacion

```bash
# Dentro del repo del proyecto
$ ls -a
.  ..  build  ejemplos.html  ejemplos.py  .idea  make.bat  Makefile  __pycache__  README.md  source  .venv
$ make html
```

Comprobamos en el navegador el fichero `docs/build/html/index.html`.

Tenemos que repetir ese proceso cada vez que cambiemos un docstring. Y a veces
es necesario:

```bash
$ make clean
$ make html
```

Si llegados a este punto ejecutamos "make html" veremos que se generan ficheros html, 
pero si abrimos el de index veremos que está vacío. 
Esto es así porque Sphinx espera encontrar un fichero .rst por cada uno de 
los paquetes que queramos documentar. Podemos crearlos a mano, 
pero es más cómodo utilizar el comando sphinx-apidoc, 
el cual examina el directorio del código fuente y genera un fichero .rst 
por cada uno de los paquetes que detecte. 
Su uso es muy sencillo, en nuestro caso bastaría con hacer:

```bash
$ sphinx-apidoc -o docs .
# se me genera lo siguiente:
$ ls docs 
ejemplos.rst  modules.rst
```

## Configuracion

Hay que importar el código fuente para poder analizar 
sus docstrings y a partir de ahí generar parte de la documentación. 
Como el código fuente está en otra carpeta hay que agregarla al path de Python:

DESCARGAR REPO JORGE

## Diseños

Sphinx es construido por texto "reStructured", por lo que se pueden
combinar recursos.

+DISEÑOS:

````python
""""
:param consultaSQL. Código da consulta sql a executar
:param *parametros. Parámetros para introducir na consulta
:return listaConsulta
"""
````