# Introduccion

Explicacion del codigo de la `Main` en:
https://www.objectdb.com/java/jpa/start/crud

Cuando corremos la primera vez la app un nuevo
archivo ObjectDB database es creado en 
el subdirectorio "db" llamado "pd2.odb".

```bash
$ pwd
/media/sf_AD/Trimestre2/Objectdb/objectdb-2.8.9/db
$ ls
p2.odb  point.odb  world.odb
```

Si corremos otra vez el programa va a utilizar esa db
para almacenar 1000 objetos adicionales.

Podemos ver el resultado visual de la db en un 
entorno grafico de ObjectDB llamado
**ObjectDB Explorer**. Para abrirlo vamos a la
carpeta bin que esta dentro del directorio de la instalacion
e introducimos el comando `$ java -jar explorer.jar`. Para
más info de como manejar esta GUI: 
https://www.objectdb.com/java/jpa/tool/explorer

## Operaciones de base de datos CRUP con JPA

### Guardando objetos en la db

`EntityManager` o `em` representa una conexion JPA al objeto
database y permite hacer operaciones con los objetos de la db.

Guarda en la db 1000 obj de tipo Point
```java
em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) { 
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
```
Las operaciones que modifican el contenido de la db requieren
una transaccion activa.

1. Se construye obj Point de forma predeterminada (como se hace
en java)
2. Se asocia el obj con el `EntityManager` y con la transaccion mediante
el metodo `persist`.
3. Los nuevos obj Point son guardados fisicamente en la db SOLO
cuando la transaccion es comiteada.

### Consultas JPA con JPQL

El objeto `EntityMaganer` sirve como una fabrica de instancias
de consultas.


### Recuperando entidades existentes

Hay varios metodos para recuperar objetos de la db usando JPA y
una consulta JPQL es una de esas maneras.

```java
TypedQuery<Point> query =
    em.createQuery("SELECT p FROM Point p", Point.class);
  List<Point> results = query.getResultList();
```

`TypedQuery es un tipo de subinterfaz de `Query` y es el modo
preferido para trabajar con queries.

### Actuando y eliminando entidades

JPA se refiere a los objetos de entidad que están asociados
con un `EntityManager` como "administrados" (managed) (o manejados???)

Un objeto nuevo contruido es SOLO manejado/administrado por un 
`EntityManager` cuando el método `persist` es invocado. Los 
obj recuperados de la db son manejados por el `EntityMagager` que 
se uso para recuperarlos.

```
// ELIMINAR
// Inicio nueva transacción. 
em.getTransaction().begin();
// borro una entidad representada por el objeto "p"
em.remove(p);
// confirmo la transaccion
em.getTransaction.commit():

// ACTUALIZAR 
em.getTransaction().begin();
// a != de eliminar, el "em" no es mencionado explicitamente
p.setX(p.getX() + 100); // update entity
em.getTransaction().commit();

```

Recordar que "p" debe ser una objeto de entidad manejado por
la `EntityManager` que se llama `em`.

En actualizar, a diferencia de eliminar, no se menciona 
explicitamente el `em` justo cuando se va a actualizar.
esto es porque el `EntityManager` que maneja la entidad
es **responsable de detectar automaticamente** los cambios 
del objeto entidad  y aplicarlos a la database cuando la
transaccion es commiteada. 

**RECORDAR** que el `setX()` y el `getX()` es un metodo
del objeto, son getters y setters que hay que tener 
definidos en la clase `Point`.

> Una transacción agrupa un conjunto de operaciones 
de base de datos que deben ejecutarse de manera atómica.