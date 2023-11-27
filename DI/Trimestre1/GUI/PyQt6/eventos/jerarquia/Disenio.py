import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton


# en este caso, al contrario que en el widget QMenu(self) en el cual le pasamos directamente el
# padre (self) aquí NO. Inducimos el del boton nosotros cuando lo agregamos al widget QMainWindow,
# el cual será el actual padre del boton.
class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi App")
        self.miBoton = QPushButton("Press me!")
        self.miBoton.clicked.connect(self.mouse_clicked)

        # cd añado un widget a otro widget, el segundo se convierte padre del primero
        # MiVentanaPrincipal se convierte en padre de MiBoton
        self.setCentralWidget(self.miBoton)

    def mouse_clicked(self):
        # para averiguar el padre de un widget
        print(self.miBoton.parent())
        # ><__main__.MiVentanaPrincipal object at 0x7f902a192710>


app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()
