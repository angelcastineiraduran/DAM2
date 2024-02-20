
import sys

from datetime import datetime

from PyQt6 import QtCore, QtWidgets
from PyQt6.QtCore import QAbstractTableModel, Qt
from PyQt6.QtGui import QImage
from PyQt6.QtWidgets import QApplication, QMainWindow
class TableModel(QtCore.QAbstractTableModel):
    def __init__(self, data):
        super(TableModel, self).__init__()
        self._data = data

    def data(self, index, role):
        if role == Qt.ItemDataRole.DisplayRole:
            value = self._data[index.row()][index.column()]
            # Perform per-type checks and render accordingly.
            if isinstance(value, datetime):
                return value.strftime("%Y-%m-%d")
            if isinstance(value, float):
                return "%.2f" % value
            if isinstance(value, str):
                return '"%s"' % value
            # por defecto si no se cap nada de arriba (ej. int)
            return value

    def rowCount(self, index):
        return len(self._data)

    def columnCount(self, index):
        return len(self._data[0])


class MainWindow(QtWidgets.QMainWindow):
    def __init__(self):
        super().__init__()

        self.table = QtWidgets.QTableView()

        data = [
            [4, 1, 3],
            [9, -1, 'hello'],
            [2.330, 1, datetime(2017,10,1)],
        ]

        self.model = TableModel(data)
        self.table.setModel(self.model)
        self.setCentralWidget(self.table)


app = QtWidgets.QApplication(sys.argv)
window = MainWindow()
window.show()

app.exec()