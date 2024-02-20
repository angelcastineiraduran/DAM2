import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel, QAbstractTableModel
from enum import Enum, Flag, auto

# -- Muestra un tabla vacia --
# pq aun no le hemos añadido el metodo data()
class PaletteTableModel(QAbstractTableModel):
    # colors[] -> colors[[]]
    def __init__(self, colors = [[]], parent = None):
        QAbstractTableModel.__init__(self, parent)
        self.__colors = colors

    def rowCount(self, parent):
        return len(self.__colors)

    # implentamos:
    def columnCount(self, parent):
        # devuelve 4 columnas de tableData0
        return len(self.__colors[0]) # == colors[[0]] // es el internal list, que corresponde al num columnas
        # return 10 # devolveria 10 columnas


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

tableData0 = [
        ["0", "1", "2", "3"],
        ["4", "5", "6", "7"],
        ["8", "9", "10", "11"],
        ["12", "13", "14", "15"]
    ]

model = PaletteTableModel(tableData0)
#model = PaletteListModel([red, green, blue])

listView.setModel(model)
treeView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

#model.insertRows(2,5)
#model.removeRows(2,3)

app.exec()