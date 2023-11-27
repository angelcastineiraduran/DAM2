import sys

from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (
    QMainWindow, QApplication,
    QLabel, QCheckBox, QComboBox, QListWidget, QLineEdit,
    QLineEdit, QSpinBox, QDoubleSpinBox, QSlider, QVBoxLayout, QWidget
)
from PyQt6.QtCore import Qt

class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super(MiVentanaPrincipal, self).__init__() #????

        self.setWindowTitle("Mi App")
        miLayout = QVBoxLayout()

        miEtiqueta = QLabel("Introzca su edad")
        miEtiqueta.setText("Introduzca su nombre")

        # guardo en una variable mi funte para posteriormente poder editarla y setearla a mi etiqueta
        miFuente = miEtiqueta.font()
        miFuente.setPointSize(30)
        miEtiqueta.setFont(miFuente)

        miEtiqueta.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter)

        miImagen = QLabel("Esto es una imagen")
        miMapaDePixeles = QPixmap("shrek.jpeg")
        # al utilizar el siguiente metodo reemplazo el contenido de la etiqueta por lo que haya en miMapaDePixeles
        miImagen.setPixmap(miMapaDePixeles)

        # se ajusta a la ventana
        miImagen.setScaledContents(True)

        miLayout.addWidget(miEtiqueta)
        miLayout.addWidget(miImagen)

        miWidget = QWidget()
        miWidget.setLayout(miLayout)
        self.setCentralWidget(miWidget)


app = QApplication(sys.argv)
w = MiVentanaPrincipal()
w.show()
app.exec()
