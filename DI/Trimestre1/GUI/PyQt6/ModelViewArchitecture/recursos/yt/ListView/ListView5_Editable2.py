import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel
from enum import Enum, Flag, auto


# Los colores se actualizan automaticamente, no es necesario que clicke en ellos
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
        # para que le cd le de doble click en un item NO se me borro MOMENTANEAMENTE el txt del mismo
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
                # notifico de que ha habido un cambio
                # pasar 2 index no tiene relevancion pq van a ser el mismo, ya que estamos trabajando con 2d
                # pero con mas dimensiones si que importa
                self.dataChanged.emit(index,index)
                return True
        return False





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