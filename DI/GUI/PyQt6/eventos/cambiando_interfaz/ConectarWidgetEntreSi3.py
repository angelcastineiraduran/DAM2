from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QPushButton, QLabel, QLineEdit, QVBoxLayout
import sys

# aqui no estamos usando un metodo propio que, debido a la interacion con el primer widget,
# active la señal de un segundo widget y posteriormente, en el metodo del segundo widget,
# se visualice un cambio en el mismo widget.
# Lo que hacemos aqui es que la propia activacion de la señal del primer widget visualice un cambio
# en el segundo widget.
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