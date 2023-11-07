import sys
from random import choice

from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

window_titulos = [
    "Mi app",
    "Todabia mi app",
    "Esto es una locura",
    "Algo va mal",
]

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi app")

        self.miBoton = QPushButton("Presioname")
        self.miBoton.clicked.connect(self.el_boton_fue_clickeado)

        self.windowTitleChanged.connect(self.el_titulo_de_ventana_ha_cambiado)

        self.setCentralWidget(self.miBoton)

    def el_boton_fue_clickeado(self):
        self.miBoton.setText("Ya me has clickeado")
        #self.miBoton.setEnabled(False) #deshabilita el poder volver a presionar el boton

        #self.setWindowTitle("App con sola una ejecucion") #cambia el nombre de la ventana
        nuevo_nombre_venta = choice(window_titulos)
        print("Cambiando nombre ventana a: %s" % nuevo_nombre_venta)
        self.setWindowTitle(nuevo_nombre_venta)

    def el_titulo_de_ventana_ha_cambiado(self, nombreVentana):
        print("El titulo de la ventana: %s" % nombreVentana)

        if nombreVentana == "Algo va mal":
            self.miBoton.setDisabled(True)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()