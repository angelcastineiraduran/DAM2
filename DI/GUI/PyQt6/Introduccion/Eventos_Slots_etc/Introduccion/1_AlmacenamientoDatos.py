import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton
# lo mismo que en el anterior pero convirtiendo miBoton como una variable de instancia en vez de clase.
# Con esto conseguimos no mandar una señal de verificacion, si no que usamos el isChecked() para verificar el estado del atri
class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.button_is_checked = True

        self.miBoton = QPushButton("Presioname") # para que sea atributo de instancia

        self.miBoton.setCheckable(True)
        self.miBoton.clicked.connect(self.miBoton_was_toggled)
        self.miBoton.setChecked(self.button_is_checked) # definimos que por defecto, sea true en vez de false

        self.setCentralWidget(self.miBoton)

    def miBoton_was_toggled(self):
        self.button_is_checked = self.miBoton.isChecked() # pregunto el estado del boton de la instancia y se lo asigno
        print(self.button_is_checked)

app = QApplication(sys.argv)
miVentana = MainWindow()
miVentana.show()
app.exec()