# Ejemplo Libro Docu Oficial
Create GUI Applications with Python & Qt6 (5th edition, -- Martin Fitzpatrick -- 5, 2022 -- 910a61dce4290afe31ad619bef0c1c2b -- Anna’s Archive
**a partir de pag 312**

## 1. View
1. `pip3 install pyqt6-tools`
2. `pyqt6-tools designer`
3. creamos ui (Figura 142 del libro)
4. `crl + r` previsualizar
5. `pyuic6 mainwindow.ui -o MainWindow.py` convertirlo a .py
6. Creamos clase `Main` importamos la clase `Ui_Dialog`, la heredamos y
con el metodo `self.setupUi(self)` visualizamos la IU
7. Creamos clase `TodoModel`

## 2. Model

1. Inicializar en el constructor la data (`self.todos`)
2. Sobreescribimos `data()` y `rowCount()` perteneciente a `QAbstractListModel`
3. Instanciamos clase `TodoModel`. Le podemos pasar por el arg un lista vacia o no:
   1. `model = TodoModel()` lista vacia
   2. `todos = [(False, 'an item'), (False, 'another item')]` --> `model = TodoModel(todos)`
4. Asignamos el modelo a la lista con `setModel()`

## Add item to the list

1. conectamos `btnAdd` a al metodo `add`
2. Creamos el metodo `add` en la `MainWindow`

El `.layoutChanged` le permite a la View saber en ese widget
que ha habido un cambio de datos. Si solo los datos son alterados,
pero el numero de filas/rows no esta afectado, podemos usar la señal
`.dataChanged()` en vez de esa.

## Other buttoms perfoming

* `complete`
* `delete`

## Using DecorationRole

Para saber el estado. En el anterior, cuando ejecutamos un `complete`
el estado del item `(False, an intem)` pasa a `(True, an item)` pero 
no visualizamos este campo por lo que ahora este va a ser el objetivo.

1. Importamos `QImage`, `os`
2. Creamos carpeta x e importamos una imagen llamada `tick.png`
3. Completamos el codigo de `TodoModel`, la parte de `DecorationRole`.

Imagen descargada de ![aquí](https://p.yusukekamiyamane.com/)

## JSON

Esta parte la voy a descartar de momento pq creo que no entra