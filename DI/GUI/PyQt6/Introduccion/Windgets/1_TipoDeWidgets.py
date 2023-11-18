import sys

from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import (
    QApplication,
    QCheckBox,
    QComboBox,
    QDateEdit,
    QDateTimeEdit,
    QDial,
    QDoubleSpinBox,
    QFontComboBox,
    QLabel,
    QLCDNumber,
    QLineEdit,
    QMainWindow,
    QProgressBar,
    QPushButton,
    QRadioButton,
    QSlider,
    QSpinBox,
    QTimeEdit,
    QVBoxLayout,
    QWidget,
)

class miVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        miLayout = QVBoxLayout()
        widgets = [
            QCheckBox, # casilla de verificacion
            QComboBox, # cuadro de lista desplegable
            QDateEdit, # para editar fechas
            QDateTimeEdit, # para editar fechas y hora
            QDial, # esfera giratoria
            QDoubleSpinBox, # selector numerico
            QFontComboBox, # lista de fuentes
            QLCDNumber, # pantalla LCD
            QLabel,
            QLineEdit, # para introducir txt
            QProgressBar,
            QPushButton,
            QRadioButton, # lo mismo pero en forma circular
            QSlider, # control deslizante
            QSpinBox, # igual que el de arriba pero con entros
            QTimeEdit, # editor de horas
        ]

        for w in widgets:
            miLayout.addWidget(w())

        widget = QWidget()
        widget.setLayout(miLayout)
        self.setCentralWidget(widget)


app = QApplication(sys.argv)
window = miVentanaPrincipal()
window.show()

app.exec()
