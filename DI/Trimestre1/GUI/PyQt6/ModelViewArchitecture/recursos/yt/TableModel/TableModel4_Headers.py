import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel, QAbstractTableModel
from enum import Enum, Flag, auto


class PaletteTableModel(QAbstractTableModel):
    # introducir headers en en el constructor
    def __init__(self, colors = [[]], headers = [], parent = None):
        QAbstractTableModel.__init__(self, parent)
        self.__colors = colors
        self.__headers = headers

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
            return self.__colors[row][column].name()

        if role == Qt.ItemDataRole.ToolTipRole:
            row = index.row()
            column = index.column()
            return "Hex code:" + self.__colors[row][column].name()

        if role == Qt.ItemDataRole.DecorationRole:
            row = index.row()
            column = index.column()
            value = self.__colors[row][column]
            pixmap = QtGui.QPixmap(26,26)
            pixmap.fill(value)
            icon = QtGui.QIcon(pixmap)
            return icon

        if role == Qt.ItemDataRole.DisplayRole:
            row = index.row()
            column = index.column()
            value = self.__colors[row][column]
            return value.name()

    def setData(self, index, value, role = Qt.ItemDataRole.EditRole):
        if role == Qt.ItemDataRole.EditRole:
            row = index.row()
            column = index.column()
            color = QColor(value)
            if color.isValid():
                self.__colors[row][column] = color
                self.dataChanged.emit(index,index)
                return True
        return False

    # vamos a usar el section para indexar nuestro nuevo lista creada
    def headerData(self, section, orientation, role):
        if role == Qt.ItemDataRole.DisplayRole:
            if orientation == QtCore.Qt.Orientation.Horizontal:
                #return "Palette"
                # lo va a llamar tantas veces como columnas haya por lo que, secuencia:
                # headers[0], headers[1], headers[2]...
                # nosotros, pasando el arg por el contructor, tenemos que indicar que representan esos elementos de la lista
                return self.__headers[section]
            else:
                return f"Color {section}"

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

rowCount = 4
columnCount = 6

# creamos nuestro header
# como tenemos 6 columnas, tenemos que crear 6 headers
headers = ["Palette0", "Colors", "Brushes", "Omg", "Technical", "Artist"]
tableData0 = [ [QColor("#FFFF00") for i in range(columnCount)] for j in range(rowCount)]

# PASAMOS LOS HEADERS AL CONSTRUCTOR
model = PaletteTableModel(tableData0, headers)

listView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

app.exec()