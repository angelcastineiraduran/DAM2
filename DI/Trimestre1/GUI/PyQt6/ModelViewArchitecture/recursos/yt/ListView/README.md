# List View 

Principio de la implementacion de datos

Algunas cosas las tengo que buscar en 
https://doc.qt.io/qt-6/qt.html#ItemFlag-enum
ya que no me deja

## Insertando y eliminando filas - `ListView6_InsertRemoveRows`
Antes y despues de insertar ningun fila hay que llamar a estos metodos:
```python
self.beginInsertRows()
# DO INSERT HERE
self.endInsertRows()
```
Estos metodos que se llaman cd utilizamos el metodo `insertRows`
**emiten una señal** que esta conectada a las vistas (View), asi que las
Views manejan los datos que ellos muestran correctamente. Si no hacemos esto
la View va a estar **desincronizada** con el Model

El metodo `self.beginInsertRows()` tiene 3 params para asistir
a las Views...`self.beginInsertRows(index, first, last)`
* first y last son los indices entre los cuales la View tiene que actualizar sus items (incluido ambos). 
Esto lo permite saber a la VIew que hay que actualizarse exactamente
* `index` SOLO lo necesitamos cd estaos trabajando con estruc de datos jerarquicas, por lo que pasaremos 
un lista vacia.

## Bibliografia
* canal de yt: Yasin Uludag