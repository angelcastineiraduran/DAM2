from PyQt6.QtWidgets import QApplication, QWidget, QMainWindow, QPushButton
import sys

class miVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.miBoton = QPushButton("Presiona")
        self.miBoton.setCheckable(True)
        self.miBoton.clicked.connect(self.miBoton_fue_clickado)

        self.setCentralWidget(self.miBoton)

    def miBoton_fue_clickado(self):
        print("Ya has clickado sobre mi!")
        self.miBoton.setEnabled(False)
        self.setWindowTitle("Ya no se puede clickar mas")

app = QApplication([])
miVentana = miVentanaPrincipal()
miVentana.show()
app.exec()