# Table and TableStyles

* `Table` y `LongTable` son clases que derivan
de la clase `Flowable`.
* `LongTable` para hacer grandes tablas dd la velocidad importa.
* Ponen en celdas todo aquello que es un `String`
o un `Flowable` o `Story` (lista de `Flowable`).
  * Si una celda contiene un `Flowable` o lista de estos,
  estos deben tener deperminado un ancho o la columna
  debe tener un ancho fijo.
* Pueden calcular alturas de las filas para que quepan
los datos. Tambien los anchos pero esto mejor manualmente.
* Pueden splitearse entre pags. tambien puedes especificar
el numero de filas que se deberan repetir en el top/bottom
de la pag despues de que se haya dividido la tabla.
* Estilo y data separados.

>[WARINING]
> Comparado con HTML = 1 limitacion: no hay forma de hacer
> span en filas/columnas. Si necesitas abarcar celdas
> tengo que anidar tablas dentro de celdas.

```python
Table(data, 
      colWidths=None, 
      rowHeights=None, 
      style=None, 
      splitByRow=1, 
      repeatRows=0, 
      repeatCols=0, 
      rowSplitRange=None, 
      spaceBefore=None, 
      spaceAfter=None, 
      cornerRadii=None)

# siempre este formato independientemente de lo que
# sea i (str, flowables etc)
# esta es una tabla de solo una fila y una columna
data=[[i]]
```

* Valores del celda `data[i][j]`
* `\\n` dentro de celda es tratado como un line spliter
* `colWidths` una secuencia de numeros que representan el ancho de 
las columnas y determinan el num de columnas en la tabla. Si 
esta en `None` se calcula automaticamente.
* `splitByRow` solo se usa para tablas demasiado anchas
y altas para caber en el contexto.
* `repeatRows` num filas que se deben repetir cd la tabla
se splitea. Si es una tupla, que filas se quieren repetir.
* `rowSplitRange` para evitar que se splitee demasiado 
cerca del principio o final de la tabla.
* `spaceBefore` & `spaceAfter` espacio antes y despues de tabla.
* `cornerRadii` para forma las 4 esquinas.
  * 0 = redondeadas

`Table.setStyle(tblStyle)` aplica una determinada
instancia de `TableStyle` a la instancia de `Table`.
Si se usa varias vecer este metodo, los posteriores
anulan a los anteriores.

## Clase `TableStyle`
