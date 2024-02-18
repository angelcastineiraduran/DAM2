import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox, QTreeView, QTableView
from PyQt6.QtGui import QColor
from PyQt6.QtCore import Qt, QAbstractListModel

class PaletteListModel(QAbstractListModel):
    def __init__(self, colors = [], parent = None):
        QAbstractListModel.__init__(self, parent)
        self.__color = colors

    def rowCount(self, parent):
        return len(self.__color)

    def data(self, index, role):

        if role == Qt.ItemDataRole.ToolTipRole:
        #if role == 3:
            # cd paso el raton por encima me devuelve ese txt
            return "Hex code:" + self.__color[index.row()].name()

        if role == Qt.ItemDataRole.DecorationRole: # no me funciona...
        #if role == 1:
            row = index.row()
            value = self.__color[row]
            pixmap = QtGui.QPixmap(26,26)
            pixmap.fill(value)
            icon = QtGui.QIcon(pixmap)
            return icon

        if role == Qt.ItemDataRole.DisplayRole: # no se pq no me funciona con esto...
        #if role == 0: # Qt.DisplayRole = 0 // mirar en libro
            row = index.row()
            value = self.__color[row]
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