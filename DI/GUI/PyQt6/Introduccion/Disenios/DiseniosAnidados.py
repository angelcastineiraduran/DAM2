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

        miLayout_1 = QVBoxLayout()
        miLayout_2 = QHBoxLayout()
        miLayout_3 = QVBoxLayout()

        miLayout_1.addWidget(Color("green"))

        miLayout_2.addWidget(Color("red"))
        miLayout_2.addWidget(Color("Blue"))

        miLayout_3.addWidget(Color("yellow"))
        miLayout_3.addWidget(Color("white"))

        miLayout_1.addLayout(miLayout_2)
        miLayout_1.addLayout(miLayout_3)

        # espacio entre los widget y los bordes del layout
        miLayout_1.setContentsMargins(0,0,0,0)
        miLayout_1.setSpacing(20)


        miWidget = QWidget()
        miWidget.setLayout(miLayout_1)
        self.setCentralWidget(miWidget)




app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()