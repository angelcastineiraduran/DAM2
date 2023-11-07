import sys

from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): #extiende de QMainWindow
    def __init__(self):
        super().__init__() #pq necesario?

        self.setWindowTitle("Mi app")
        miBoton = QPushButton("Presioname perri")

        self.setFixedSize(QSize(400,300)) #se desactiva redimensionar venta por usu
        #self.setMaximumSize(QSize(400,300))
        #self.setMinimumSize(QSize(100, 50))

        self.setCentralWidget(miBoton)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()