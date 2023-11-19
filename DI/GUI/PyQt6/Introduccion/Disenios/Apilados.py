import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget, QStackedLayout, QPushButton
)
from PyQt6.QtCore import Qt
from WidgetPersonalizado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super(QMainWindow, self).__init__()

        miLayout = QStackedLayout()

        miLayout.addWidget(Color("red"))
        miLayout.addWidget(Color("blue"))
        miLayout.addWidget(Color("green"))
        miLayout.addWidget(Color("yellow"))

        miLayout.addWidget(miBoton)

        # se mostrara el widget de la 3 posicion, es decir el yellow
        miLayout.setCurrentIndex(3)
        # se mostrar el widget que indiques
        #miLayout.setCurrentWidget(...)

        miWidget = QWidget()
        miWidget.setLayout(miLayout)
        self.setCentralWidget(miWidget)

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()