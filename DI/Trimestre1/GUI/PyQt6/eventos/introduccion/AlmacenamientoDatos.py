import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

# a veces resulta util almacenar el estado actual de un widget en una variable de Python
class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        # creo la variable de objeto, para que se guarde.
        # este sera el valor predeterminado para establecer el estado inicial del widget
        self.btn_esta_checked = True

        miBoton = QPushButton("Presioname")
        miBoton.setCheckable(True)
        # cada vez que se presiona, se manda señal al metodo para que actualice el state del boton
        # el cual se almacenará en la variable de objeto: self.btn_esta_checked
        miBoton.clicked.connect(self.btn_fue_alternado)

        # atributo de QButton que indica el estado actual del boton
        miBoton.setChecked(self.btn_esta_checked)
        # de forma predeterminada:
        #miBoton.setChecked(False)

        self.setCentralWidget(miBoton)

    def btn_fue_alternado(self, checked):
        self.btn_esta_checked = checked
        print("Checked?:", self.btn_esta_checked)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()