# MongoDB

## Instación y conexión :nut_and_bolt:

Instalar con ubuntu [aquí](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/#std-label-install-mdb-community-ubuntu).

Arrancar servidor mongod (+info servidor como parar servicio, reiniciar etc enlace arriba).

```bash
sudo sysudstemctl start mongod
mongosh
```

Para cargar datos a la bash, simplemente copio el código del
documento y lo pego. Ejemplo:

```javascript
// COPIAR e PEGAR no TERMINAL  cliente de MONGO DENDE AQUI ata o seguinte comentario
// crea books en test
use test

db.books.deleteMany({})
var books =
[
{
_id: 1,
  item: "TBD",
  stock: 0,
  info: { publisher: "1111", pages: 430 },
  tags: [ "technology", "computer" ],
  ratings: [ { by: "ijk", rating: 4 }, { by: "lmn", rating: 5 } ],
  reorder: false
}
,
{_id: 2,
  item: "XYZ123",
  stock: 15,
  info: { publisher: "5555", pages: 150 },
  tags: [ ],
  ratings: [ { by: "xyz", rating: 5, comment: "ratings and reorder will go away after update"} ],
  reorder: false
}
]
db.books.insertMany(books);

//ATA AQUI
// observacions:
// lembra que cando leas dende java   datos numericos creados en mongo debes lelos como Double , e decir que neste caso _id e stock por exemplo deben ser lidos como Double.
```

-----

## Introduccion teoria :book:

### MongoDB vs SQL
1. base==base
2. tables(count of rows)==colections(count of documents)
3. row==document
4. colum==key
5. value==value
6. primary key==_id - **inmutable**

### Estructura

Los `document` de una `colection` pueden tener != cantidad de campos. 
Si no hay un campo para un `document`, entonces ese campo para esa `document`
**no existe** a diferencia de SQL ya que el campo si que existiría para esa fila
solo que el valor corresonidente sería `null`.

```javascript
"edade":30 // [CLAVE]:[VALOR]
```

------


## Comandos :computer:

:warning: **IMPORTANTE** :warning:
Normalmente los comandos que empiecen `[nombre-bd]>` (ejemplo: `test>`) son comandos en los que quiero moestrar la salida y aquellos
que no tengan ese previo es pq no me interesa mostrar la salida (ya que
no me parece relevante).

### Bases de datos y colleciones

Ver bases de datos

```javascript
test> show dbs
admin   40.00 KiB
config  84.00 KiB
local   40.00 KiB
test    40.00 KiB
```
> Solo aparecen aquellas que tienes >=1 coleccion (las que NO tienen ninguna coleccion, aunque te puedas mover a ellas, NO existen)

Moverse a una base de datos
(Si no existe se crea)
```javascript
test> use prueba
// No aparece pq aun no tiene ninguna coleccion
prueba> show dbs
admin   40.00 KiB
config  72.00 KiB
local   40.00 KiB
test    40.00 KiB
prueba> 
```

Borrar base de datos

```javascript
// Borro base actual (tengo que estar en ella)
prueba> db.dropDatabase()
{ ok: 1, dropped: 'prueba' }
// pq me me sigue apareciendo? pq realmente he borrado 
// todas las colecciones de prueba. De hecho si mostramos
// todas las bd no aparece ya, pq al no tener colecciones es como si no
// existiera.
prueba> show dbs
admin    40.00 KiB
config  108.00 KiB
local    40.00 KiB
test     40.00 KiB
// comprobamos que no existe:
prueba> use test
test> show dbs
admin    40.00 KiB
config  108.00 KiB
local    40.00 KiB
test     40.00 KiB
```

Ver colecciones

```javascript
test> show collections
books
```

### :one: Insertar

Crear colecciones, documentos y campos

```javascript
// 1. creo una coleccion llamada persoas y le inserto un documento
test> db.persoas.insertOne({
... // shift+enter para que no ejecute el comando y me haga un salto de linea
... // Las comillas solo son necesarias si es un nombre compuesto, pero lo estandar es ponerselas
... "nome":"luis",
... numeros:[23,56,86]
... })
{
  acknowledged: true,
  // clave que se le da el IDE
  insertedId: ObjectId('65f2065eaa5e4786a2a0afc5')
}
// 2. comprobamos que se ha creado la coleccion
test> show collections
books
persoas

// 3. inserto otro documento
test> db.persoas.insertOne({nome:"ana", edade:31, numeros:[54, 5, 65, 7, 3, 2], enderezo: {rua:"urzaiz", numero:24, piso:3, porta:"a"}})
{
  acknowledged: true,
  insertedId: ObjectId('65f2083caa5e4786a2a0afc6')
}
```

Ver/consultar documentos de una coleccion

```javascript
test> db.persoas.find()
[
  {
    _id: ObjectId('65f2065eaa5e4786a2a0afc5'),
    nome: 'luis',
    numeros: [ 23, 56, 86 ]
  },
  {
    _id: ObjectId('65f2083caa5e4786a2a0afc6'),
    nome: 'ana',
    edade: 31,
    numeros: [ 54, 5, 65, 7, 3, 2 ],
    enderezo: { rua: 'urzaiz', numero: 24, piso: 3, porta: 'a' }
  }
]
```

### :two: Borrar

Borrar documentos

```javascript
test> db.persoas.deleteOne({_id:ObjectId("65f2065eaa5e4786a2a0afc5")})
{ acknowledged: true, deletedCount: 1 }

// borra el primero que se encuentre (no hay un orden, es aleatorio)
//creo que funcionan ambas:
db.persoas.deleteOne()
db.persoas.deleteOne({})

// borra todos los documentos
db.persoas.deleteMany({})
```

Borrar campos

```javascript
// Previo
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  {
    _id: ObjectId('65f2420e35bfe760ab7312a3'),
    name: 'Smith',
    age: 30,
    children: 2
  }
]
// Elimina el campo children
// DA IGUAL el valor que le demos a children, mientras sea más
// de uno (1=TRUE, 2=TRUE....0=FALSE) creo.
test> db.people.updateOne({name:"Smith"}, {$unset:{children:1}})
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0
}
// Comprobacion
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 }
]
```

### :three: Actualizar/Modificar

Reemplazar documentos

```javascript

// REEMPLAZAR A PARTIR DE UNA CONDICION
// Para ver el previo
test> db.people.find()
[
  { _id: 1, hello: 'world' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 }
]
// Esto reemplaza toodo, da igualos los campos que tenga
// ese _id ya que los va a sobreescribir a TODOS y solo va a quedar nome:"luis"
test> db.people.replaceOne({_id:1}, {nome:"luis"})
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0
}
// Comprobacion
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 }
]

// si ponemos una condicion por ejemplo nombre
// y hay varios que se llamen asi, sobreescribe a un o y solo
// al primero que se encuentre (aleatorio) creo.


// REEMPLAZA CUALQUIER DOCUMENTO
// si no ponemos _id, modifica el primero que encuentre
db.people.replaceOne({}, {nome:"luis"})

```

Actualizar/Modificar campos de un documento

```javascript
// Busca la fila de los Smith (el primero que encuentre y solo uno),
// y cambia el campo children por el que pongamos. Si el campo no existe
// lo crea.
db.people.updateOne({name:"Smith"}, {$set:{children:3}})

//----------------------------------------------

// como no lo encuentra, no hace nada
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 },
  { _id: 4, rua: 'pino' }
]
test> db.people.updateOne({"name":"Jones"}, {"$set":{"age":50}})
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 0,
  modifiedCount: 0,
  upsertedCount: 0
}
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 },
  { _id: 4, rua: 'pino' }
}
//si no encuentra el registro, lo crea
test> db.people.updateOne({"name":"Jones"}, {"$set":{"age":50}}, {upsert:true})
{
  acknowledged: true,
  insertedId: ObjectId('65f24b7c7a134e6af0517f5c'),
  matchedCount: 0,
  modifiedCount: 0,
  upsertedCount: 1
}
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 },
  { _id: 4, rua: 'pino' },
  { _id: ObjectId('65f24b7c7a134e6af0517f5c'), name: 'Jones', age: 50 }
]


// ----------------------------------------------

// En que se diferencia los 2 anteriores? pq uno si no lo 
// encuentra se crea y el otro no?
// pq uno es el campo por el que buscamo(2) y el otro es el campo
// que queremos modificar(1). 
```

Actualizar varios registros a la vez
  
```javascript
// prev
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 },
  { _id: 4, rua: 'pino' },
  { _id: ObjectId('65f24b7c7a134e6af0517f5c'), name: 'Jones', age: 50 }
]
// modifico
test> db.people.update(  {}, {"$set" : {"numero":2}}, {multi:true} )
DeprecationWarning: Collection.update() is deprecated. Use updateOne, updateMany, or bulkWrite.
{
  acknowledged: true,
  insertedId: null,
  matchedCount: 4,
  modifiedCount: 4,
  upsertedCount: 0
}
// compruebo
test> db.people.find()
[
  { _id: 1, nome: 'luis', numero: 2 },
  {
    _id: ObjectId('65f2420e35bfe760ab7312a3'),
    name: 'Smith',
    age: 30,
    numero: 2
  },
  { _id: 4, rua: 'pino', numero: 2 },
  {
    _id: ObjectId('65f24b7c7a134e6af0517f5c'),
    name: 'Jones',
    age: 50,
    numero: 2
  }
]

```

### :four: Consultar

La condición va entre llaves `{}`.

Entre dos cosas, o con más condiciones `[cosa1, cosa2]` y se pone al principio de 
esos corchetes un `$x:` dd `x` es palabra reservada (`$x:[cosa1, cosa2]`).

Posibles `x`:
* `or`
* `and`
* `eq` (igual)
* `gt` (mayor que)
* `gte` (mayor o igual que)
* `lt` (menor que)
...

Buscar por condicion

```javascript
// IGUAL A
db.persoas.find({nome:"luis"})
// es lo mismo que:
db.personas.find({“nome”:{$eq:”luis”}})

// MAYOR QUE
db.persoas.find({"edade":{$gt:30}})

// IGUAL O MAYOR QUE
db.persoas.find({"edade":{$gte:30}})

// MENOR QUE
db.persoas.find({"edade":{$lt:30}})

// IGUAL O MENOR QUE
// los que no tienen el campo edad TAMPOCO los muestra
db.persoas.find({"edade":{$lte:30}})
// es lo mismo que:
// ERROR! En realidad no es lo mismo ya que los que tienen no tienen el
// campo edad SI que los muestra.
db.persoas.find({"edade":{$not:{$gt:30}}})

// NO ES IGUAL A
db.persoas.find({"nome":{$ne:"luis"}})

// O UNO U OTRO
// los que no tienen campo nombre, tampoco los muestra
db.persoas.find({"nome":{$in:["luis","ana"]}})

// NI UNO NI OTRO
// tambien me va a mostrar aquellos que no tienen campo nombre
db.persoas.find({"nome":{$nin:["luis","ana"]}})

// buscar por id
db.persoas.find({_id:ObjectId("65f2065eaa5e4786a2a0afc5")})
```

Buscar por condicion en campo anidado

```javascript
// IGUAL A
// enderezo.rua es un campo anidado
db.persoas.find({"enderezo.rua":"urzaiz"})

// MAYOR QUE
db.persoas.find({"enderezo.numero":{$gt:23}})
// asi no funcionaria, no te encuentra nada:
db.persoas.find({"numero":{$gt:23}})

```

Buscar por condicion doble/multiple

```javascript
// buscar dd la edad sea mayor a 31 o que se llame ana
db.persoas.find({$or:[{"edade":{$gt:31}}, {"nome":"ana"}]})

// buscar dd la edad sea mayor a 31 y que se llame ana
db.persoas.find({$and:[{"edade":{$gt:31}}, {"nome":"ana"}]})

// buscar aquellos que tengan el campo edade y que no sea 30 ni 40
db.persoas.find({"edade":{$exists:true, $nin:[30,40]}})
// ERROR! Funciona igual pero no es correcta.
// el $and se utiliza para buscar en un mismo campo.
// ademas estoy aplicando multimples condiciones a un mismo campo
db.persoas.find({$and: [ {"edade":{$exists:true}} , {"edade":{$nin: [30,40] }}] })
```

Buscar la primera que se encuente
  
```javascript
db.persoas.findOne()
```

Buscar por letras
  
```javascript
// EMPIEZA POR
db.persoas.find({nome:{$regex:"^l"}})

// TERMINA POR
// con l^ NO FUNCIONA, no existe
db.persoas.find({nome:{$regex:"l$"}})

// listar documentos que comenzen por “f” ou teñan o campo “enderezo”
db.persoas.find({$or:[  {nome:{$regex:”^f”}}, {enderezo: {$exists:true} } ]  } )
```

### Ejemplos :test_tube:

En esta consulta, al no existir el campo “nomes” (ya que realmente existe “nome”, NO “nome”) te muestra todos.

```javascript
db.persoas.find({nomes:{$nin:[“luis”,”ana”]}})
```

### Dudas :question:

* Diferencias entre el `$or` y el `$in`??

Son lo mismo, solo que uno se utiliza junto y otro separado. Se suele
utilizar `$or` cuando se quiere buscar en distintos campos y `$in` cuando se busca en un mismo campo.

```javascript
// $or
test> db.persoas.find( {$or: [ {"edade":{$eq:31}} , {"edade":{$eq:40}} ] } )
[
  {
    _id: ObjectId('65f2083caa5e4786a2a0afc6'),
    nome: 'ana',
    edade: 31,
    numeros: [ 54, 5, 65, 7, 3, 2 ],
    enderezo: { rua: 'urzaiz', numero: 24, piso: 3, porta: 'a' }
  }
]

// $in
test> db.persoas.find({"edade":{$in: [31, 40] }})
[
  {
    _id: ObjectId('65f2083caa5e4786a2a0afc6'),
    nome: 'ana',
    edade: 31,
    numeros: [ 54, 5, 65, 7, 3, 2 ],
    enderezo: { rua: 'urzaiz', numero: 24, piso: 3, porta: 'a' }
  }
]


```

* Que pasa si insertamos una fila con das campos
que tienen el mismo nombre pero con distintos valores?

Solo se inserta uno de esos valores:
```javascript
test> db.people.insertOne({_id:4, rua:"urzaiz", rua:"pino"})
{ acknowledged: true, insertedId: 4 }
test> db.people.find()
[
  { _id: 1, nome: 'luis' },
  { _id: ObjectId('65f2420e35bfe760ab7312a3'), name: 'Smith', age: 30 },
  { _id: 4, rua: 'pino' }
]

```

## Proyecciones :mag:

* `1` para mostrar, `0` para no mostrar.
* El `2` hace lo mismo que `1`.
* Se pueden combinar varios `1` o varios `0` pero **NO** entre 
ellos (excepto con el `id`).
* El primer corchete se pone vacío pq representa a las condiciones.

```javascript

// Muestra filas y de esas filas el campo edad
test> db.persoas.find({}, {edade:1})
[
  // aunque no tenga el campo edad, muetra el identificador del obj
  { _id: ObjectId('65f2065eaa5e4786a2a0afc5') },
  { _id: ObjectId('65f2083caa5e4786a2a0afc6'), edade: 31 }
]

// Muestra filas y de esas filas muestra todos los campos menos el campo edad
test> db.persoas.find({}, {edade:0})
[
  {
    _id: ObjectId('65f2065eaa5e4786a2a0afc5'),
    nome: 'luis',
    numeros: [ 23, 56, 86 ]
  },
  {
    _id: ObjectId('65f2083caa5e4786a2a0afc6'),
    nome: 'ana',
    numeros: [ 54, 5, 65, 7, 3, 2 ],
    enderezo: { rua: 'urzaiz', numero: 24, piso: 3, porta: 'a' }
  }
]

// Muestro campos edade y nome
db.persoas.find({}, {edade:1, nome:1})

// ERROR! No se pueden combinar 1 y 0
test> db.persoas.find({}, {edade:1, nome:0})
MongoServerError[Location31254]: Cannot do exclusion on field nome in inclusion projection

// PERO si se puede combinar 1 y 0 con el campo _id
test> db.persoas.find({}, {edade:1, nome:1})
[
  { _id: ObjectId('65f2065eaa5e4786a2a0afc5'), nome: 'luis' },
  { _id: ObjectId('65f2083caa5e4786a2a0afc6'), nome: 'ana', edade: 31 }
]
test> db.persoas.find({}, {edade:1, nome:1, _id:0})
[ { nome: 'luis' }, { nome: 'ana', edade: 31 } ]

```

## Proyeccions & Consultas :green_salad:

```javascript
// Condicion que muestre edad superior a 30 y que me muestre solo
// los campos nombre y edad
test> db.persoas.find({edade:{$gt:30}}, {edad:1,nome:1,_id:0})
[ { nome: 'ana' } ]

// Devolver a rua de todos os documentos que tengan por edad mayor a 29
test> db.persoas.find({edade:{$gt:29}}, {"enderezo.rua":1,_id:0})
[ { enderezo: { rua: 'urzaiz' } } ]

```

----

## Java

Drivers a importar:

```bash
bson-4.11.1.jar           
mongodb-driver-core-4.11.1.jar
mongodb-driver-3.4.3.jar  
mongodb-driver-sync-4.11.1.jar
```


