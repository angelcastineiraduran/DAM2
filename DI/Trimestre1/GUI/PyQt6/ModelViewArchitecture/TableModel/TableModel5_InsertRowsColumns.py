import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel, QAbstractTableModel
from enum import Enum, Flag, auto


class PaletteTableModel(QAbstractTableModel):
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

    def headerData(self, section, orientation, role):
        if role == Qt.ItemDataRole.DisplayRole:
            if orientation == QtCore.Qt.Orientation.Horizontal:
                # implementamos este metodo para que en el caso de que haya mas columnas de las que
                # pongamos en el constructror, las columnas restantes tendran "not implemented" por defecto
                if section < len(self.__headers):
                    return self.__headers[section]
                else:
                    return "not implemented"
            else:
                return f"Color {section}"

    def insertRows(self, position, rows, parent=QtCore.QModelIndex):
        self.beginInsertRows(QtCore.QModelIndex(), position, position + rows -1)
        for i in range(rows):
            # en vez de insertar un color, tenemos que insertar una lista
            #self.__colors.insert(position, QColor("#000000"))
            # None = parent pq no lo necesitamos si no es en treeview
            # 1. En definitiva, esta linea crea la fila que contiene esos items
            defaultValues = [QColor("#000000") for i in range(self.columnCount(None))]
            # 2. Insertamos esas fila a la lista privada de colores
            self.__colors.insert(position, defaultValues)
        self.endInsertRows()
        return True

    def insertColumns(self, position, columns, parent=QtCore.QModelIndex):
        self.beginInsertRows(QtCore.QModelIndex(), position, position + columns -1)
        rowCount = len(self.__colors)
        for i in range(columns):
            for j in range(rowCount):
                self.__colors[j].insert(position, QColor("#000000"))
        self.endInsertRows()
        return True


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

headers = ["Palette0", "Colors", "Brushes", "Omg", "Technical", "Artist"]
tableData0 = [ [QColor("#FFFF00") for i in range(columnCount)] for j in range(rowCount)]

model = PaletteTableModel(tableData0, headers)
#model.insertRows(0,3)
# como en este caso implento mas columnas que headers hay, unas cuentas columnas se quedaran sin header
# por lo que tenemos que modificar tambien el headerData
model.insertColumns(0, 5)

listView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

app.exec()