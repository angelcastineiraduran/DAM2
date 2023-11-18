from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow
import sys

app = QApplication(sys.argv)
#window = QWidget()
#window = QPushButton("Push me")
#window = QMainWindow() # widget con cosas predefinidas

# mejor practica: subclase para manejar QMainWindow()
class MainWindow(QMainWindow): # herencia
    def __init__(self):

        # para que se inicialicen los atributos y comportamientos de la clase heredada
        # sigo sin entender esto???!!!
        super().__init__()

        # self respectivo al obj de MainWindow
        self.setWindowTitle("Mi app")
        miBoton = QPushButton("Presioname")

        # tamanio fijo
        #self.setFixedSize(400, 300)
        self.setMinimumSize(200,100)
        self.setMaximumSize(600,400)

        # funcion disponible para QMainWindow
        self.setCentralWidget(miBoton)

window = MainWindow()
window.show()
app.exec()