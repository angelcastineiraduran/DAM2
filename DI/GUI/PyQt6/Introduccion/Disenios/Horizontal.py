import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget, QHBoxLayout
)
from PyQt6.QtCore import Qt

from WidgetPersonalizado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super(QMainWindow, self).__init__()

        miLayout = QHBoxLayout()
        miLayout.addWidget(Color("red"))
        miLayout.addWidget(Color("blue"))
        miLayout.addWidget(Color("green"))
        miWidget = QWidget()
        miWidget.setLayout(miLayout)

        self.setCentralWidget(miWidget)





app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()