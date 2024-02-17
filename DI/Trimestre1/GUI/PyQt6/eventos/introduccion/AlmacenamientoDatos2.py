import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

# Si un widget no proporciona una señal que envie el estado actual, debera recuperar
# el valor del widget directamente DESDE SU CONTROLADOR
class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        self.btn_esta_checked = True

        self.miBoton = QPushButton("Presioname")
        self.miBoton.setCheckable(True)

        # esta señal en concreto no envia el estado de verificacion
        self.miBoton.released.connect(self.btn_fue_alternado)
        self.miBoton.setChecked(self.btn_esta_checked)

        self.setCentralWidget(self.miBoton)

    # este metodo es en caso de que el widget SI que DEVUELVE su ESTADO ACTUAL
    #def btn_fue_alternado(self, checked):
    #    self.btn_esta_checked = checked
    #    print("Checked?:", self.btn_esta_checked)

    # este metodo es en caso de que el widget NO DEVUELVE su ESTADO ACTUAL.
    # este metodo actua como CONTROLADOR de la señal RELEASED
    # tengo que hacer miBoton propiedad de la instancia de MainWindow para poder acceder a el.
    # imprime lo mismo que en el anterior.
    def btn_fue_alternado(self):
        # isChecked() pregunta el estado del obj
        self.btn_esta_checked = self.miBoton.isChecked()
        print("Checked?:", self.btn_esta_checked)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()