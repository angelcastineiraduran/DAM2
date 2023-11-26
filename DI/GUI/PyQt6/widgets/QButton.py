import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QVBoxLayout, QWidget, QRadioButton

class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi App")
        miLayout = QVBoxLayout()

        self.miBoton = QPushButton("Press me!")
        self.miBotonRedondo = QRadioButton("Press radio button")
        self.miBoton.setCheckable(True)
        self.miBotonRedondo.setCheckable(True)

        self.miBoton.toggled.connect(self.btn_alternado)
        self.miBotonRedondo.toggled.connect(self.btn_redondo_alternado)

        miLayout.addWidget(self.miBoton)
        miLayout.addWidget(self.miBotonRedondo)

        miWidget = QWidget()
        miWidget.setLayout(miLayout)
        self.setCentralWidget(miWidget)

    def btn_alternado(self):
        if(True == self.miBoton.isChecked()):
            print("btn normal ENCENDIDO", self.miBoton.text())
        else:
            print("btn normal APAGADO", self.miBoton.text())

    def btn_redondo_alternado(self):
        if(True == self.miBotonRedondo.isChecked()):
            print("btn redondo ENCENDIDO", self.miBotonRedondo.text())
        else:
            print("btn redondo APAGADO", self.miBotonRedondo.text())


app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()