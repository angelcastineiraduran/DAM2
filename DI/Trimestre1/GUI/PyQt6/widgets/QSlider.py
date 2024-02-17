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

        miWidget = QSlider(Qt.Orientation.Horizontal)

        miWidget.setMaximum(5)
        miWidget.setMinimum(-5)

        miWidget.setSingleStep(3)

        miWidget.sliderMoved.connect(self.barra_deslizada)
        miWidget.sliderPressed.connect(self.control_barra_presionado)
        miWidget.sliderReleased.connect(self.control_barra_liberado)
        # te proporciona devuelve mas info que sliderMoved
        miWidget.valueChanged.connect(self.valores_cambiados)

        self.setCentralWidget(miWidget)

    def barra_deslizada(self):
        print("se ha deslizado")

    def control_barra_presionado(self):
        print("se ha presionado")

    def control_barra_liberado(self):
        print("Liberado!")

    def valores_cambiados(self, i):
        print("Cambiados los valores, ", i)

# para recoger el valor desde el obj
# valur = self.miSlider.value
# para reiniciar:
# self.sliderVolume.setSliderPosition(0)

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()