
import sys
from PyQt6 import QtGui, QtCore, QtWidgets
from PyQt6.QtCore import Qt, QAbstractListModel
from PyQt6.QtWidgets import QMainWindow

# NO ES LA clase del libro, pq no la encontré pero es una que hice yo +-
from MainWindow import Ui_MainWindow

# RECORDAR. en las QListView, solo hay 2D por lo siempre va a ser la misma column()
class TodoModel(QAbstractListModel):
    # todos = almacen de datos, una simple lista de datos, una TUPLA:
    # [(bool, str), (bool, str), (bool, str)]
    # bool = estado hecho de una entrada
    # str = txt de el `todo`
    # inicializmos el self.todo como una lista vacia
    # a no ser que se le pase una lista como arg
    def __init__(self, todos=None):
        super().__init__()
        # explicado en readme
        self.todos = todos or []

    # metodo estandar de Model que debemos implementar para una list model
    # index: posicion de los datos del modelo. creo que no es un entero si no un obj: QModelIndex
    # role: el papel del dato, tipo de dato que el View esta pidiento
    def data(self, index, role):
        # Qt.DisplayRole normalmente se utiliza para solicitar datos de visualizacion
        if role == Qt.DisplayRole:
            # se selecciona la lista correspondiente a la fila `index.row`
            # la tupla contiene dos elementos: status (bool) y text (str)
            status, text = self.todos[index.row()]
            # solo devolvemos el text cd es Qt.DisplayRole ("please me give me data for display")
            return text
    # metodo estandar de Model que debemos implementar para una list model
    def rowCount(self, index):
        return len(self.todos)


class MainWindow(Ui_MainWindow, QMainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi()

        # 2 formas de instanciar Model
        self.model = TodoModel() # crea una lista vacia
        #todos = [(False, 'an item'), (False, 'another item')]
        #self.model = TodoModel(todos)




app = QtWidgets.QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()