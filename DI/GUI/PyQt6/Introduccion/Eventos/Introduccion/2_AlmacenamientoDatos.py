import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.button_is_checked = True # para que el atributo sea del obj y no sea local.

        miBoton = QPushButton("Presioname")

        miBoton.setCheckable(True)
        miBoton.clicked.connect(self.miBoton_was_toggled)
        miBoton.setChecked(self.button_is_checked) # definimos que por defecto, sea true en vez de false

        self.setCentralWidget(miBoton)

    def miBoton_was_toggled(self, checked):
        self.button_is_checked = checked
        print(self.button_is_checked)

app = QApplication(sys.argv)
miVentana = MainWindow()
miVentana.show()
app.exec()