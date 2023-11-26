from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow
from PyQt6.QtCore import QSize
import sys

app = QApplication(sys.argv)

# mejor practica: subclase para manejar QMainWindow()
class MiVentanaPrincipal(QMainWindow): # herencia
    def __init__(self):

        # para que se inicialicen los atributos y comportamientos de la clase heredada
        super().__init__()

        # self respectivo al obj de MiVentanaPrincipal
        self.setWindowTitle("Mi app")
        miBoton = QPushButton("Presioname")

        # tamanio se gestiona mediante el obj QSize el cual acepta ancho y largo
        # tamanio fijo, si intento cambiar tamanio, no funciona!
        #self.setFixedSize(QSize(400, 300))
        self.setMinimumSize(QSize(200,100))
        self.setMaximumSize(QSize(600,400))

        # funcion disponible para QMainWindow
        self.setCentralWidget(miBoton)

miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()