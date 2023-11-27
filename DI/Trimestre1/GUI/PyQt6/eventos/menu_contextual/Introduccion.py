from PyQt6.QtGui import QAction
from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QPushButton, QLabel, QLineEdit, QVBoxLayout, QMenu
import sys

class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

    # Evento propio de la clase MiVentanaPrincipal ya que hereda de QMainWindow
    # El metodo tiene que tener ese nombre para que lo podamos interceptar y asi anular el metodo
    # del obj con nuestro nuevo metodo con el mismo nombre.
    # Este metodo (.contextMenuEvent) es un metodo de QMainWindow y por eso
    # ponemos el mismo nombre, para SOBREESCRIBIRLO.
    # El parametro "e" es un objeto de tipo QContextMenuEvent. Este tiene info sobre por ej la posicion
    # donde se generó: e.pos(), que boton se utilizo para desencadenar el evento etc.
    def contextMenuEvent(self, e):
        # Creo obj de QMenu() pasandole el obj de esta clase (MiVentanaPrincipal()),
        # es decir, la ventana.
        # El argumento pasado se comporta como el padre de QMenu
        # en algunos widgets es necesario especificar el padre (como en este) en otros no.
        # mas infor sobre esto en jerarquias
        miContexto = QMenu(self)

        miContexto.addAction(QAction("test 1", self))
        miContexto.addAction(QAction("test 2", self))
        miContexto.addAction(QAction("test 3", self))

        # exec() es un metodo de QMenu el cual muestra el menu contextual: miContexto
        # en la posicion e.globalPos()
        # globalPos() para que el menu aparezca en el lugar donde se genero el menu contextual
        miContexto.exec(e.globalPos())

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()