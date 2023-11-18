import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        miBoton = QPushButton("Press Me!")
        # la da al boton la capacidad de alternarse entre un estado y otro
        miBoton.setCheckable(True)
        # la señal es clicked, que se conecta a ese metodo
        miBoton.clicked.connect(self.miBoton_fue_clickado)
        miBoton.clicked.connect(self.miBoton_fue_alternado)

        # Set the central widget of the Window.
        self.setCentralWidget(miBoton)

    # slot personalizado:
    def miBoton_fue_clickado(self):
        print("Clicked!")

    def miBoton_fue_alternado(self, checked):
        print("Checked?", checked)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()