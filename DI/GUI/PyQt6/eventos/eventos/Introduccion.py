import sys

from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QLabel, QMainWindow, QTextEdit

class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.miEtiqueta = QLabel("Clicka en esta ventana")
        self.setCentralWidget(self.miEtiqueta)
        # se supone que registra el movimiento de raton sin tener que presionalo pero no me funciona ?!
        self.setMouseTracking(True)

    def mouseMoveEvent(self, e):
        self.miEtiqueta.setText("mouseMoveEvent")

    def mousePressEvent(self, e):
        self.miEtiqueta.setText("mousePressEvent")

    def mouseReleaseEvent(self, e):
        self.miEtiqueta.setText("mouseReleaseEvent")

    def mouseDoubleClickEvent(self, e):
        self.miEtiqueta.setText("mouseDoubleClickEvent")


app = QApplication(sys.argv)

window = MiVentanaPrincipal()
window.show()

app.exec()