# convierte el diseño que hicimos en un codigo python
# que nosotros podamos manipular
from PyQt6 import uic
from PyQt6.QtWidgets import QMessageBox

# va a hacer las importaciones necesarias para poder pintar la
# pantalla dentro del archivo
class Login():
    def __init__(self):
        # le digo que quiero utilizar la libreria `ui` para
        # cambiar la IG
        self.login = uic.loadUi("gui/login.ui")
        self.initGUI()
        self.login.lblMensaje.setText("")
        self.login.show()

    def ingresar(self):
        if len(self.login.txtUsuario.text()) < 2:
            self.login.lblMensaje.setText("Ingrese usuario valido")
            self.login.txtUsuario.setFocus()
        else:
            pass

    def initGUI(self):
        self.login.btnAcceder.clicked.connect(self.ingresar)