import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget
)
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        miLayout = QVBoxLayout()
        miSpinEntero = QSpinBox()
        miSpinDoble = QDoubleSpinBox()

        miSpinEntero.setMaximum(10)
        miSpinEntero.setMinimum(3)

        miSpinEntero.setPrefix("$")
        miSpinEntero.setSuffix("c")

        # salta de 3 en 3
        miSpinEntero.setSingleStep(3)

        # envia solo el valor numerico
        miSpinEntero.valueChanged.connect(self.valor_cambiado)
        # envia en formate de txt tanto valor num, como sufijos y prefijos
        miSpinEntero.textChanged.connect(self.txt_cambiado)

        # para que no se pueda en el recuadro el numero y solo funcione con el selector
        miSpinEntero.lineEdit().setReadOnly(True)

        miWidget = QWidget()
        miWidget.setLayout(miLayout)
        miLayout.addWidget(miSpinEntero)
        miLayout.addWidget(miSpinDoble)
        self.setCentralWidget(miWidget)

    def valor_cambiado(self, i):
        print(i)

    def txt_cambiado(self, s):
        print(s)

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()