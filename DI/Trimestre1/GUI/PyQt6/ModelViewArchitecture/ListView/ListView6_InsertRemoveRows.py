import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel
from enum import Enum, Flag, auto

class PaletteListModel(QAbstractListModel):
    def __init__(self, colors = [], parent = None):
        QAbstractListModel.__init__(self, parent)
        self.__colors = colors

    def headerData(self, section, orientation, role = ...):
        if role == 0:
            if orientation == QtCore.Qt.Orientation.Horizontal:
                return "Palette"
            else:
                return f"Color {section}"

    def rowCount(self, parent):
        return len(self.__colors)

    def data(self, index, role):
        if role == Qt.ItemDataRole.EditRole:
            return self.__colors[index.row()].name()

        if role == 3:
            return "Hex code:" + self.__colors[index.row()].name()
        if role == 1:
            row = index.row()
            value = self.__colors[row]
            pixmap = QtGui.QPixmap(26,26)
            pixmap.fill(value)
            icon = QtGui.QIcon(pixmap)
            return icon
        if role == 0:
            row = index.row()
            value = self.__colors[row]
            return value.name()

    def flags(self, index):
        return Qt.ItemFlag.ItemIsEditable | Qt.ItemFlag.ItemIsEnabled | Qt.ItemFlag.ItemIsSelectable

    def setData(self, index, value, role = Qt.ItemDataRole.EditRole):
        if role == Qt.ItemDataRole.EditRole:
            row = index.row()
            color = QColor(value)
            if color.isValid():
                self.__colors[row] = color
                self.dataChanged.emit(index,index)
                return True
        return False

    # -- INSERTING --
    # position: posicion de la estructura de datos dd queremos insertar
    # rows: cuantas filas queremos insertar
    # parent: como en los anteriores metodos, no nos tenemos que preocupar por esto a no ser que
    # implementemos estructuras de datos con jerarquicas para las TreeViews
    def insertRows(self, position, rows, parent):
        # QtCore.QModelIndex() deja por defecto la raiz
        self.beginInsertRows(QtCore.QModelIndex(), position, position + rows -1)
        for i in range(rows):
            # si hay un item es esa `position` lo empuja hacia abajo
            self.__colors.insert(position, QColor("#000000"))
        self.endInsertRows()
        return  True # ppositionq la operacion ha sido exitos

    # -- REMOVING --
    def removeRows(self, position, rows, parent = QtCore.QModelIndex()):
        self.beginRemoveRows(parent, position, position + rows - 1)
        for i in range(rows):
            value = self.__colors[position]
            self.__colors.remove(value)
        self.endRemoveRows()
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

model = PaletteListModel([red, green, blue])

listView.setModel(model)
treeView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

# insertamos items
model.insertRows(2,5, QtCore.QModelIndex())
# si queremos ponerlo asi:
#model.insertRows(2,5) # es lo mismo que arriba
# ...tenemos que cambiar: `insertRows( , , , parent=QtCore.QModelIndex())`
# ...tambien podemos cambiar: `self.beginInsertRows(parent, , )
# ...Esto tambien es aplicable para el metodo remove...

model.removeRows(2,3)

app.exec()