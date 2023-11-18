import sys
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider
)
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        widget = QComboBox()
        widget.addItems(["Angel", "Oscar", "Marga"])
        widget.addItem("Rebeca")
        widget.addItem("Angel")

        widget.currentIndexChanged.connect(self.indice_modificado)
        widget.currentTextChanged.connect(self.texto_modificado)

        widget.setEditable(True)
        # el nuevo item que se añade desde la IU del usu, se agregara alfabeticamente a la lista
        widget.setInsertPolicy(QComboBox.InsertPolicy.InsertAlphabetically)
        widget.setMaxCount(10)

        self.setCentralWidget(widget)

    def indice_modificado(self, i):
        print("Nuevo indice", i)

    def texto_modificado(self, s):
        print("Nuevo txt", s)

app = QApplication(sys.argv)
w = MainWindow()
w.show()
app.exec()