from PyQt6.QtWidgets import QApplication

from ModelViewArchitecture.DB.ejemploBanco.gui.login import Login


# aqui tengo que hacer la app
class Banco():
    def __init__(self):
        self.app = QApplication([])
        self.login = Login()
        self.app.exec()