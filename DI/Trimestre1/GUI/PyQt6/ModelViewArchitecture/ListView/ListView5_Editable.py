import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel
from enum import Enum, Flag, auto
#from PySide6.QtCore import QEnum, QFlag, QObject


# LOS colores se actualizan en los demas widgets cd clickamos en ellos
class PaletteListModel(QAbstractListModel):
    def __init__(self, colors = [], parent = None):
        QAbstractListModel.__init__(self, parent)
        self.__color = colors

    def headerData(self, section, orientation, role = ...):
        if role == 0:
            if orientation == QtCore.Qt.Orientation.Horizontal:
                return "Palette"
            else:
                return f"Color {section}"

    def rowCount(self, parent):
        return len(self.__color)

    def data(self, index, role):
        if role == 3:
            return "Hex code:" + self.__color[index.row()].name()
        if role == 1:
            row = index.row()
            value = self.__color[row]
            pixmap = QtGui.QPixmap(26,26)
            pixmap.fill(value)
            icon = QtGui.QIcon(pixmap)
            return icon
        if role == 0:
            row = index.row()
            value = self.__color[row]
            return value.name()

    # Para que sea editable hay que implementar 2 nuevos metodos:
    # es llamado por el View para comprobar algunos estados
    # por ejemplo: cd le damos doble click en algo, el View va a comprobar a este metodo
    # si es editable o no. Si lo es, va a crear un editor para nosotros para que lo podemos editar.
    def flags(self, index):
        return Qt.ItemFlag.ItemIsEditable | Qt.ItemFlag.ItemIsEnabled | Qt.ItemFlag.ItemIsSelectable

    # index: item information como el row, el colum y el parent
    # value: creo que es el tipo de valor
    # el role por defecto es "Qt.EditRole"
    def setData(self, index, value, role = Qt.ItemDataRole.EditRole):
        if role == Qt.ItemDataRole.EditRole:
            row = index.row()
            color = QColor(value)
            if color.isValid():
                self.__color[row] = color
                return True
        return False # si el color NO es editable





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