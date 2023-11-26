import sys

from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QLabel, QMainWindow, QTextEdit

class MainWindow(QMainWindow):
    '''EVENTOS'''

    def __init__(self):
        super().__init__()
        self.miEtiqueta = QLabel("Clicka en esta ventana")
        self.setCentralWidget(self.miEtiqueta)

    def mouseMoveEvent(self, e):
        self.miEtiqueta.setText("evento movimiento del raton")

    def mousePressEvent(self, e):
        self.miEtiqueta.setText("evento presionar del raton")

    def mouseReleaseEvent(self, e):
        self.miEtiqueta.setText("evento liberar el raton")

    def mouseDoubleClickEvent(self, e):
        self.miEtiqueta.setText("evento doble click del raton")

app = QApplication(sys.argv)
ventana = MainWindow()
ventana.show()
app.exec()