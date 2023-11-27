import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        miBoton = QPushButton("Presioname")
        miBoton.setCheckable(True)
        miBoton.clicked.connect(self.boton_clicked)

        self.setCentralWidget(miBoton)

    def boton_clicked(self):
        print("Clicked!")

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()