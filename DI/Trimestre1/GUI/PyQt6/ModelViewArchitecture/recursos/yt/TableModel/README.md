# Table Model

## Solo metodos countRows() y countColumns()

Ejemplo tabla 2D
```python
tableData1 = [ # main list
        ["0", "1", "2", "3"], # children
        ["4", "5", "6", "7"],
        ["8", "9", "10", "11"],
        ["12", "13", "14", "15"]
    ]
tableData1[3][0] # row=3, column=0 --> "12"
```

Entonces hay que cambiar:

```python
class PaletteTableModel(QAbstractTableModel):
    # colors = [] // 1D --> colors [[]] // 2D 
    def __init__(self, colors = [[]], parent = None):
        QAbstractTableModel.__init__(self, parent)
        self.__colors = colors
```

## `data()`
**RECORDATORIO**: Lo unico que hacia este metodo es:
````python
if role == QtCore.Qt.DisplayRole:
    # 1. get the row
    role = index.row()
    # 2. pass it to the list to retrieve an item to display
    value = self.__colors[row]
    # 3. return the hex code of it
    return value.name()
````

## Bibliografia
* canal yt: yasin uludag