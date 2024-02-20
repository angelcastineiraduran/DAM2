import os
import sys
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import (
QApplication,
QLineEdit,
QMainWindow,
QTableView,
QVBoxLayout,
QWidget,
)
from PyQt6.QtSql import QSqlDatabase, QSqlTableModel

basedir = os.path.dirname(__file__)
db = QSqlDatabase("QSQLITE")
db.setDatabaseName(os.path.join(basedir,"chinook.sqlite"))
db.open() # para inicializar la conexion

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # -- AÑADIENDO FILTRO DE BUSQUEDA --
        container = QWidget()
        layout = QVBoxLayout()
        self.search = QLineEdit()
        self.search.textChanged.connect(self.update_filter)
        layout.addWidget(self.search)

        self.table = QTableView()
        layout.addWidget(self.table)
        container.setLayout(layout)

        # primero tenemos que crear la instancia pasandole la db creada arriba
        self.model = QSqlTableModel(db=db)
        # solo necesitamos esto para desplegar la data en el QTableView
        self.table.setModel(self.model)
        # nombre tabla
        self.model.setTable("Track")

        # -- MODIFICANDO PARAMS --
        # cambio tipo de edit
        self.model.setEditStrategy(QSqlTableModel.EditStrategy.OnRowChange)
        # 1. Cambiando el orden
        # 1.1. Por el indice de la columna
        self.model.setSort(2, Qt.SortOrder.DescendingOrder)
        # 1.2. Por el nombre de la columna
        idx = self.model.fieldIndex("Milliseconds")
        self.model.setSort(idx, Qt.SortOrder.DescendingOrder)

        # -- COLUMN TITLES --

        # A. Mala practica = CONFUSION +tarde
        # por defecto vienen con el nombre de las bd
        #self.model.setHeaderData(1, Qt.Orientation.Horizontal, "Name")
        #self.model.setHeaderData(2, Qt.Orientation.Horizontal, "Album (ID)")
        #self.model.setHeaderData(2, Qt.Orientation.Vertical, "Prueba") # no funciona pq?

        # B. Buena practica (tienes claro cuales se cambian y cuales NO)
        column_titles = {
            "Name": "Name",
            "AlbumId": "Album (ID)",
            "MediaTypeId": "Media Type (ID)",
            "GenreId": "Genre (ID)",
            "Composer": "Composer",
        }
        for n, t in column_titles.items():
            idx = self.model.fieldIndex(n)
            self.model.setHeaderData(idx, Qt.Orientation.Horizontal, t)

        # -- SELECTING COLUMNS --
        # ¡¡¡Esto SOLO las elimina de la VIEW!!! no las elimna de la SQL
        # A. Mala practica
        #self.model.removeColumns(2,5)
        # B. Buena practica
        columns_to_remove = ['name', 'something']
        for cn in columns_to_remove:
            idx = self.model.fieldIndex(cn)
            self.model.removeColumns(idx, 1)


        self.model.select()

        self.setMinimumSize(QSize(1024, 600))
        #self.setCentralWidget(self.table)
        self.setCentralWidget(container)

    def update_filter(self, s):
        filter_str = 'Name LIKE "%{}%"'.format(s)
        self.model.setFilter(filter_str)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()