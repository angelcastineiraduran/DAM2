import sys
from PyQt6.QtCore import QAbstractListModel, Qt
from PyQt6.QtGui import QImage
from PyQt6.QtWidgets import QApplication, QMainWindow

import os

from MainWindow import Ui_Dialog # asi es como le llame a la clase

# __init__ es una funcion que devuelve la ruta actual
basedir = os.path.dirname(__file__)
# join() para concatenar ruta completa
# QImagen para representar la imagen
tick = QImage(os.path.join(basedir, "tick.png"))

class TodoModel(QAbstractListModel):
    def __init__(self, todos=None):
        super().__init__()
        self.todos = todos or []

    def data(self, index, role):
        if role == Qt.ItemDataRole.DisplayRole:
            status, text = self.todos[index.row()]
            return text
        if role == Qt.ItemDataRole.DecorationRole:
            status, text = self.todos[index.row()]
            if status:
                return tick

    def rowCount(self, index):
        return len(self.todos)

class MainWindow(QMainWindow, Ui_Dialog):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        todos = [(False, 'an item'), (False, 'another item')]
        self.model = TodoModel(todos)
        self.todoList.setModel(self.model)
        # connect the button
        self.btnAdd.pressed.connect(self.add)
        self.btnDelete.pressed.connect(self.delete)
        self.btnComplete.pressed.connect(self.complete)

    def add(self):
        """add an item in out list, getting the text from the
        QLineEdit .lineEdit and then clearing it"""
        text = self.lineEdit.text()
        # remove whitespaces
        text = text.strip()
        if text: # dont add empty strings
            # access the list via the model
            self.model.todos.append((False, text))
            # trigger refresh
            self.model.layoutChanged.emit()
            # empty the input
            self.lineEdit.setText("")

    def delete(self):
        indexes = self.todoList.selectedIndexes()
        # se verifica si hay algun indice seleccionado
        if indexes:
            # dado que selectedIndexes() devuelve una lista de indice seleccionados
            # y como el codigo esta en modo de seleccion unica, es decir, no se pueden
            # seleccionar mas de 2 items, se toma el primer valor del indice, pq solo hay uno, el seleccionado
            index = indexes[0]
            # remove the item and refresh
            del self.model.todos[index.row()]
            self.model.layoutChanged.emit()
            # clear the selection
            self.todoList.clearSelection()

    def complete(self):
        indexes = self.todoList.selectedIndexes()
        if indexes:
            index = indexes[0]
            row = index.row()
            status, text = self.model.todos[row]
            self.model.todos[row] = (True, text)
            self.model.dataChanged.emit(index, index)
            self.todoList.clearSelection()

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()