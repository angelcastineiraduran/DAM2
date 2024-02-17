import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider
)
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow):

    def __init__(self):
        super(MainWindow, self).__init__()

        self.setWindowTitle("My App")

        miCasillaVerificacion = QCheckBox()
        # de forma predeterminada esta checkeado
        miCasillaVerificacion.setCheckState(Qt.CheckState.Checked)
        #miCasillaVerificacion.setCheckState(Qt.CheckState.PartiallyChecked)
        # decido si de primeras esta checkeada o no
        #miCasillaVerificacion.setChecked(True)
        # para que tenga 3 posibles estados:
        #miCasillaVerificacion.setTristate(True)

        miCasillaVerificacion.stateChanged.connect(self.mostrar_estado)

        self.setCentralWidget(miCasillaVerificacion)

    def mostrar_estado(self, state):
        # deberia imprimir True o False dependiendo de si esta marcada o no respectivamente
        # sin embargo solo imprime False ya que imprime la cadena "Qt.CheckState.Checked" y no el int correspondiente (2)?¿
        print(state == Qt.CheckState.Checked)
        print(Qt.CheckState.Checked)
        print("estado", state)


app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()