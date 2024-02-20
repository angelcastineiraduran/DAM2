# Querying SQL databases with Qt models

## Connecting to a database
```python
import os
from PySide6.QtSql import QSqlDatabase
basedir = os.path.dirname(__file__)
db = QSqlDatabase("QSQLITE")
db.setDatabaseName(os.path.join(basedir, "chinook.sqlite"))
db.open()
```

## Displaying a table with QSqlTableModel

`QSqlTableModel` es un modelo que despliega la data
directamente a la tabla, permitiendo editar.

Con lo siguiente ya sería suficiente para desplegar la tabla:
(hay que tener en cuenta que la base de datos la descargamos 
y la introducimos en este directorio):

```python
import os
import sys
from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QTableView
from PyQt6.QtSql import QSqlDatabase, QSqlTableModel
basedir = os.path.dirname(__file__)
db = QSqlDatabase("QSQLITE")
db.setDatabaseName(os.path.join(basedir,"chinook.sqlite"))
db.open() # para inicializar la conexion

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.table = QTableView()

        # primero tenemos que crear la instancia pasandole la db creada arriba
        self.model = QSqlTableModel(db=db)
        # solo necesitamos esto para desplegar la data en el QTableView
        self.table.setModel(self.model)
        # nombre tabla
        self.model.setTable("Track")
        self.model.select()
        self.setCentralWidget(self.table)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()
```
