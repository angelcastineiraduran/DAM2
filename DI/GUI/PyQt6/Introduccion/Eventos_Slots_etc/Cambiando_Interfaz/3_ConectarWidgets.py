from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QPushButton, QLabel, QLineEdit, QVBoxLayout
import sys

class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        # Con los parentesis los asocio a un objeto. Si fuera QLabel (sin ()), entonces estaria asociandolo a la clase
        # QLabel() y QLineEdit() son los constructores de sus respectivas clases
        self.miEtiqueta = QLabel()
        self.miEntrada = QLineEdit()

        # el metodo setText va sin parentesis pq realmente es una referencia, es necesario que el metodo setText
        # se pase como un puntero de una funcion (una ref a un metodo) en lugar de llamar al metodo directamente en
        # ese momento. PyQt se encarga de llamar al metodo setText internamente cd la señal textChanged se emite
        self.miEntrada.textChanged.connect(self.miEtiqueta.setText)

        miLayout = QVBoxLayout()
        miLayout.addWidget(self.miEtiqueta)
        miLayout.addWidget(self.miEntrada)

        miContenedor = QWidget()
        miContenedor.setLayout(miLayout)
        self.setCentralWidget(miContenedor)

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()