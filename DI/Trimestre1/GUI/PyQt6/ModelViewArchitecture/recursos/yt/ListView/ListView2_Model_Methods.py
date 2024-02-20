import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel

class PaletteListModel(QAbstractListModel):
    def __init__(self, colors = [], parent = None):
        QAbstractListModel.__init__(self, parent)
        self.__color = colors

    # TODOS los Model tienen que incluir al menos 2 clases: data y rowCount
    # lo necesita saber la View para representar ese numero de columnas
    # parent: como estamos trabajando en una lista, este param es INNECESARIO
    def rowCount(self, parent):
        #return 5 # representa 5 columnas
        return len(self.__color)
    # cd la View pide un dato de una row, por ej: 0, le devuelve el item de la lista[0] y demas
    # por ello tambien NECESITAMOS este metodo para que la lista sepa que item coger
    # responsable de devolver el item del param "index" solicitado
    def data(self, index, role):
        row = index.row()
        value = self.__color[row]
        #return "HARDCORE ITEMS" # todas las filas tienen ese txt
        return value.name()

app = QApplication(sys.argv)

listView = QListView()
listView.show()

treeView = QTreeView()
treeView.show()

comboBox = QComboBox()
comboBox.show()

tableView = QTableView()
tableView.show()

red = QColor(255,0,0)
green = QColor(0,255,0)
blue = QColor(0,0,255)

model = PaletteListModel([red, green, blue])

listView.setModel(model)
treeView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

app.exec()