import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget, QGridLayout
)
from PyQt6.QtCore import Qt
from WidgetPersonalizado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super(QMainWindow, self).__init__()

        miLayout = QGridLayout()

        miLayout.addWidget(Color("red"), 0, 0)
        miLayout.addWidget(Color("blue"), 1, 0)
        miLayout.addWidget(Color("green"), 1, 1)
        miLayout.addWidget(Color("yellow"), 2, 1)

        miWidget = QWidget()
        miWidget.setLayout(miLayout)
        self.setCentralWidget(miWidget)

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()