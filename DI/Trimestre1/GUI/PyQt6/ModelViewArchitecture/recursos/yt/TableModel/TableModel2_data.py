import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel, QAbstractTableModel
from enum import Enum, Flag, auto


class PaletteTableModel(QAbstractTableModel):
    def __init__(self, colors = [[]], parent = None):
        QAbstractTableModel.__init__(self, parent)
        self.__colors = colors

    def rowCount(self, parent):
        return len(self.__colors)

    def columnCount(self, parent):
        return len(self.__colors[0])

    def flags(self, index):
        return Qt.ItemFlag.ItemIsEditable | Qt.ItemFlag.ItemIsEnabled | Qt.ItemFlag.ItemIsSelectable

    def data(self, index, role):
        if role == Qt.ItemDataRole.EditRole:
            row = index.row()
            column = index.column()
            #return self.__colors[index.row()].name()
            return self.__colors[row][column].name()

        if role == Qt.ItemDataRole.ToolTipRole:
            row = index.row()
            column = index.column()
            #return "Hex code:" + self.__colors[index.row()].name()
            return "Hex code:" + self.__colors[row][column].name()

        if role == Qt.ItemDataRole.DecorationRole:
            row = index.row()
            column = index.column()
            #value = self.__colors[row]
            value = self.__colors[row][column]
            pixmap = QtGui.QPixmap(26,26)
            pixmap.fill(value)
            icon = QtGui.QIcon(pixmap)
            return icon

        if role == Qt.ItemDataRole.DisplayRole:
            # RECORDAR: index is an param which is a queue model index instance
            # que contiene info del item que es
            row = index.row()
            column = index.column()
            value = self.__colors[row][column]
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

# Ahora tendriamos que cambiar esto, podemos hacerlo de forma manual (pero me llevaria mucho tiempo)
#tableData0 = [
    #[QColor(255,0,0), QColor[0,255,0], QColor[0,0,255]...]
#]
tableData1 = [
        ["0", "1", "2", "3"],
        ["4", "5", "6", "7"],
        ["8", "9", "10", "11"],
        ["12", "13", "14", "15"]
    ]
# POR LO TANTO...Lo haremos de esta forma mas rapida:
rowCount = 4
columnCount = 4
# Hay que leerlo de derecha a izq para entenderlo
# para cada fila va a poner esas columnas
# y para cada columna va a poner ese color
tableData0 = [ [QColor("#FFFF00") for i in range(columnCount)] for j in range(rowCount)]

model = PaletteTableModel(tableData0)
#model = PaletteListModel([red, green, blue])

# esto va a mostrar SOLO una columna, 1d
listView.setModel(model)
# en esta, si la expandimos la app va a crashear, AUNQUE esto creo que ya no sucede
# esto sucedia pq la treeView NO se podia usar con QAbstractTableModel
#treeView.setModel(model)
# esto va a mostrat SOLO una columna, 1d
comboBox.setModel(model)
tableView.setModel(model)

#model.insertRows(2,5)
#model.removeRows(2,3)

app.exec()