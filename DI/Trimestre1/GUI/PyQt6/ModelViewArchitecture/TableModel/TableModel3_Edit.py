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
            return self.__colors[row][column].name()

        if role == Qt.ItemDataRole.ToolTipRole:
            row = index.row()
            column = index.column()
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
            row = index.row()
            column = index.column()
            value = self.__colors[row][column]
            return value.name()

    # RECORDAR que en este metodo recibe el `value` de la View despues de que hayamos editado un item
    # y nosotros usamos ese valor para crear un color y reemplazaar el viejo color en esa fila...por tanto:
    def setData(self, index, value, role = Qt.ItemDataRole.EditRole):
        if role == Qt.ItemDataRole.EditRole:
            row = index.row()
            column = index.column()
            color = QColor(value)
            if color.isValid():
                #self.__colors[row] = color
                self.__colors[row][column] = color
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

rowCount = 4
columnCount = 4
tableData0 = [ [QColor("#FFFF00") for i in range(columnCount)] for j in range(rowCount)]

model = PaletteTableModel(tableData0)

# tanto en la listView como en el comboBox, cuando EDITAMOS y cambiamos un color en la tableModel,
# si cambiamos algun item de la PRIMERA columna los cambios se van a reflejar en estas 2 PERO
# si cambiamos un item en cualquiera OTRA COLUMNA (independientemente de la FILA), pues NO se va
# a reflejar este cambio en ninguna de las 2, ya que como ES LOGICO estas SOLO tienen 1 COLUMNA
listView.setModel(model)
comboBox.setModel(model)
tableView.setModel(model)

app.exec()