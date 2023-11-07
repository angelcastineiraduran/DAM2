import sys

from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QLabel, QMainWindow, QTextEdit, QLabel, QPushButton

class MainWindow(QMainWindow):
    '''EVENTOS DEL MOUSE'''

    def __init__(self):
        super().__init__()
        self.miEtiqueta = QLabel("presioname perri")
        self.setCentralWidget(self.miEtiqueta)

    def mousePressEvent(self, e): #"e" es el obj del evento
        #Qt.MouseButton.LeftButton = enumeracion en la biblioteca PyQt6 que representa diferentes botones del raton
        if e.button() == Qt.MouseButton.LeftButton: #button() es un metodo del obj devuelto
            self.miEtiqueta.setText("Evento del mouse click izq")
        elif e.button() == Qt.MouseButton.RightButton:
            self.miEtiqueta.setText("Evento del mouse click derecho")
        elif e.button() == Qt.MouseButton.MiddleButton:
            self.miEtiqueta.setText("Evento del mouse click medio")

    def mouseReleaseEvent(self, e):
        if e.button() == Qt.MouseButton.LeftButton:
            self.miEtiqueta.setText("Evento liberar mouse izq")
        elif e.button() == Qt.MouseButton.RightButton:
            self.miEtiqueta.setText("Evento liberar mouse derecha")
        elif e.button() == Qt.MouseButton.MiddleButton:
            self.miEtiqueta.setText("Evento liberar mouse medio")

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()