import sys
from PyQt6 import QtWidgets, QtCore, QtGui
from PyQt6.QtWidgets import QListView, QMainWindow, QApplication, QComboBox


app = QApplication(sys.argv)

data = ["uno", "dos", "tres"]

list = QListView()
list.show()
combo = QComboBox()
combo.show()

model = QtCore.QStringListModel(data)
list.setModel(model)
combo.setModel(model)

app.exec()

