
import sys
import os

from datetime import datetime

from PyQt6 import QtCore, QtWidgets, QtGui
from PyQt6.QtCore import QAbstractTableModel, Qt
from PyQt6.QtGui import QImage, QColor
from PyQt6.QtWidgets import QApplication, QMainWindow

basedir = os.path.dirname(__file__)

class TableModel(QtCore.QAbstractTableModel):
    def __init__(self, data, headersH=(), headersV=()):
        super(TableModel, self).__init__()
        self._data = data
        self._headersH = headersH
        self._headersV = headersV

    def data(self, index, role):

        if role == Qt.ItemDataRole.DisplayRole:
            value = self._data[index.row()][index.column()]
            if isinstance(value, datetime):
                return value.strftime("%Y-%m-%d")
            if isinstance(value, float):
                return "%.2f" % value
            if isinstance(value, str):
                return '"%s"' % value
            return value

        if role == Qt.ItemDataRole.BackgroundRole and index.column() == 2:
            return QColor(Qt.GlobalColor.blue)

        if role == Qt.ItemDataRole.TextAlignmentRole:
            value = self._data[index.row()][index.column()]
            if isinstance(value, int) or isinstance(value, float):
                return Qt.AlignmentFlag.AlignVCenter | Qt.AlignmentFlag.AlignRight

        if role == Qt.ItemDataRole.ForegroundRole:
            value = self._data[index.row()][index.column()]
            if(
                isinstance(value, int) or isinstance(value, float)
            ) and value < 0:
                return QColor(Qt.GlobalColor.red)

        if role == Qt.ItemDataRole.DecorationRole:
            value = self._data[index.row()][index.column()]
            if isinstance(value, datetime):
                return QtGui.QIcon(
                    os.path.join(basedir, "calendar.png")
                )
            elif isinstance(value, bool):
                if value:
                    return QtGui.QIcon("tick.png")
                return QtGui.QIcon("cross.png")

            elif isinstance(value, int):
                pixmap = QtGui.QPixmap(26,26)
                pixmap.fill(Qt.GlobalColor.yellow)
                icon = QtGui.QPixmap(pixmap)
                return icon

    def rowCount(self, index):
        return len(self._data)

    def columnCount(self, index):
        return len(self._data[0])

    # NO lo hice de la manera del libro
    def headerData(self, section, orientation, role):
        if role == Qt.ItemDataRole.DisplayRole:
            if orientation == QtCore.Qt.Orientation.Horizontal:
                return self._headersH[section]
            else:
                return self._headersV[section]

class MainWindow(QtWidgets.QMainWindow):
    def __init__(self):
        super().__init__()

        self.table = QtWidgets.QTableView()

        data = [
            [True, 1, 3],
            [False, -1, 'hello'],
            [2.330, 1, datetime(2017,10,1)],
        ]

        # añadimos headers para luego pasarselos al constructor:
        columns = ("A", "B", "C")
        index = ("Row 1", "Row 2", "Row 3", "Row 4", "Row 5")

        self.model = TableModel(data, headersH=columns, headersV=index)
        self.table.setModel(self.model)
        self.setCentralWidget(self.table)


app = QtWidgets.QApplication(sys.argv)
window = MainWindow()
window.show()

app.exec()