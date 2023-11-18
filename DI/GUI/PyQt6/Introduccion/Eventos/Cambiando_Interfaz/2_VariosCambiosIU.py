from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QPushButton
from random import choice
import sys

nombres_ventanas = [ # fuera de la clase pq¿
            "Bienvenida",
            "Ventana nueva",
            "Ventana nueva 2.0",
            "Algo ha ido mal"
]
class miVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Nombre Principal")
        self.miBoton = QPushButton("Presioname")
        self.miBoton.setCheckable(True)
        self.miBoton.clicked.connect(self.miBoton_fue_clickado)
        self.windowTitleChanged.connect(self.nombre_ventana_ha_cambiado)

        self.setCentralWidget(self.miBoton)

    def miBoton_fue_clickado(self):
        print("Clickado!")
        nuevo_nombre_ventana = choice(nombres_ventanas)
        print("El nuevo nombre de la ventana sera: ", nuevo_nombre_ventana)
        self.setWindowTitle(nuevo_nombre_ventana)
    def nombre_ventana_ha_cambiado(self, nuevo_nombre_ventana):
        print("Ha cambiado el nombre de la ventana a", nuevo_nombre_ventana)
        if(nuevo_nombre_ventana) == "Algo ha ido mal": self.miBoton.setEnabled(False)

app = QApplication([])
miVentana = miVentanaPrincipal()
miVentana.show()
app.exec()