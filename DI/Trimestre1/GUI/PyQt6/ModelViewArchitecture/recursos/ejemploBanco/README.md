# Bases de datos - SQLite

## Crear tabla y usuario en la BD
1. Constructor que se conecte a la bd y cree una tabla.
2. Metodo `crearTablas()` que crear una tabla y no la hay.
3. Metodo `crearAdmin()` para crear usuario por defecto con 
el que entraremos desde el sist.
4. En `crearTablas()` llamo a `crearAdmin()` justo despues de crear las 
tablas, es decir, debajo del metodo `cur.close()`
5. Debido a que `crearAdmin()` es una instruccion SQL y puede fallar,
tenemos que añadir el bloque `try`/`except`.

### Insert
Lo podemos hacer de varias maneras
```python
sql_insert = """INSERT INTO usuarios VALUES (null, {}, {}, {})""".format("Administrador", "Admin", "admin1234")
# %s pq son String
sql_insert = """INSERT INTO usuarios VALUES (null, %s, %s, %s)""".format("Administrador", "Admin", "admin1234")
# creo que esta es la mejor
sql_insert = """INSERT INTO usuarios VALUES (null, '{}', '{}', '{}')""".format("Administrador", "Admin", "admin1234")
```

### Diseñamos interfaz

Nos ayudamos con la interfaz grafica de PyQt6.

Para instalarla: `$pip3 install pyqt6-tools`
Para ejecutarla, nos vamos a la terminal del proyecto y ejecutamos:
```bash
$ pwd
/home/ubuntu/DAM2/DI/Trimestre1/gui/PyQt6
$ pyqt6-tools designer
```

Cd lo ejecutemos le damos a crear con los valores que vienen preseleccionados.

* `crtl + r` previsualizamos

### Distribucion y ejecucion
1. Creamos carpeta `gui` donde guardamos el `login.ui`
2. Creo `login.py` que va a importar el diseño de `login.iu` encodigo python
para que podamos manipularlo.
   * Le indico la ruta y lo muestro.
3. Creo `banco.py` donde creo la app `QApplication()`, instancio 
la clase `Login` y ejecuto la app.
4. Creo `app.py` que va ser el archivo que tiene que ejecutar el usuario
para iniciar la app.

### Ejecucion
Podemos en `Login` que antes de ejecutar el `login.show` llame al
`lblMensaje.setText("")` con la intencion de que cd ejecutemos el programa 
por primera vez, no se muestre ningun mensaje.

**Me quede en el minuto: 57:42**

A continuacion...
1. Creo el metodo `ingresar()`
2. Creo el metodo `initGUI()`
3. Añado `initGUI()` al `__init__()`
4. Le posiciono el cursor en el usuario en el caso de que no sea valido
con `setFocus()`

## Bibliografia
* video yt: https://www.youtube.com/watch?v=SaBwpCIV6PQ