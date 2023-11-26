import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.boton_es_checkeado = True #atributo para rastrear estado de boton

        self.setWindowTitle("Mi App")

        self.miBoton = QPushButton("Presioname!")
        self.miBoton.setCheckable(True) #para qued boton tenga 2 estados, marcada y descamarcado
        self.miBoton.released.connect(self.el_boton_fue_liberado) #cd se hace click y se suelta = boton liberado
        self.miBoton.setChecked(self.boton_es_checkeado)

        self.setCentralWidget(self.miBoton)

    def el_boton_fue_liberado(self):
        self.boton_es_checkeado = self.miBoton.isChecked() #para que se establezca en el atributo el estado actual del boton

        print(self.boton_es_checkeado) #para comprobar por salida si el boton esta marcado o no despues de que se haga click en el


app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()