import sys

from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget
)
from PyQt6.QtCore import Qt

class Color(QWidget):

    def __init__(self, color):

        super(Color, self).__init__()
        # para que el color del widget se rellene automaticamente con el color especificado
        self.setAutoFillBackground(True)

        # obtiene la paleta de colores actual del widget.
        # una paleta en PyQt6 es un conjunto de colores predefinidos que se puede aplicar a diferentes partes del widget
        miPaleta = self.palette()
        # defino el color de la ventana en la paleta del widget.
        miPaleta.setColor(QPalette.ColorRole.Window, QColor(color))
        # aplico la paleta modificada a mi widget
        self.setPalette(miPaleta)


