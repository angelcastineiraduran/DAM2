import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi App")
        self.setMouseTracking(True)
    def mousePressEvent(self, event):
        print("Mouse pressed")
        super().mousePressEvent(event)

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()