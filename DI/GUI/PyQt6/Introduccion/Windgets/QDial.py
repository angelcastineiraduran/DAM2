import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget, QDial
)
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        miDial = QDial()

        miDial.setRange(-10,100)

        miDial.valueChanged.connect(self.value_changed)
        miDial.sliderMoved.connect(self.slider_position)
        miDial.sliderPressed.connect(self.slider_pressed)
        miDial.sliderReleased.connect(self.slider_released)

        self.setCentralWidget(miDial)

    def value_changed(self, i):
        print(i)

    def slider_position(self, p):
        print("position", p)

    def slider_pressed(self):
        print("Pressed!")

    def slider_released(self):
        print("Released")

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()