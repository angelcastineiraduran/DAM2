from PyQt6.QtGui import QAction
from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QPushButton, QLabel, QLineEdit, QVBoxLayout, QMenu
import sys

class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

    # Evento propio de la clase MiVentanaPrincipal ya que hereda de QMainWindow
    # El metodo tiene que tener ese nombre para que lo podamos interceptar y asi anular el metodo del obj con nuestro
    # nuevo metodo con el mismo nombre.
    # El parametro "e" es un objeto de tipo QContextMenuEvent. Este tiene info sobre por ej la posicion
    # donde se generó: e.pos(), que boton se utilizo para desencadenar el evento etc.
    def contextMenuEvent(self, e):
        # constructor de QMenu() con el obj de esta clase (MiVentanaPrincipal()), es decir, la ventana.
        miContexto = QMenu(self)
        miContexto.addAction(QAction("test 1", self))
        miContexto.addAction(QAction("test 2", self))
        miContexto.addAction(QAction("test 3", self))
        # exec() es un metodo de QMenu el cual muestra el menu contex miContexto en la posicion e.globalPos()
        # globalPos() para que el menu aparezca en el lugar donde se genero el menu contextual
        miContexto.exec(e.globalPos())

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()