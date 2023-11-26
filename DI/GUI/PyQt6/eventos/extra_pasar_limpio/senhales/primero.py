import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi app")

        miBoton = QPushButton("Presioname guarri")
        miBoton.setCheckable(True)
        miBoton.clicked.connect(self.el_boton_fue_clickado)
        miBoton.clicked.connect(self.el_boton_fue_alternado) #pq no hay que pasarle ningun param?

        self.setCentralWidget(miBoton)
    def el_boton_fue_clickado(self):
        print("Has clickado el boton")

    def el_boton_fue_alternado(self, checked):
        print("Chekeado?: ", checked)


app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()