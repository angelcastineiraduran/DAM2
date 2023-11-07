from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QLineEdit, QVBoxLayout, QWidget

import sys #para interactuar con el sistema y manejar arg de linea de comandos


class MainWindow(QMainWindow):
    '''conectar widgets entre si directamente'''

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi app")

        self.miEtiqueta = QLabel() #widget de etiqueta vacia
        self.miEntrada = QLineEdit() #widget de entrada de texto

        #cd se cambie txt de miEntrada, se actualiza el txt de miEtiqueta
        self.miEntrada.textChanged.connect(self.miEtiqueta.setText)

        layout = QVBoxLayout() #diseño para organizar widget de manera vertical
        #añado los widget al layout:
        layout.addWidget(self.miEntrada)
        layout.addWidget(self.miEtiqueta)

        #widger para contener otros widgets, en este caso QVBoxLayout
        container = QWidget()
        container.setLayout(layout) #el contenedor central contendra todos los widgets

        self.setCentralWidget(container)


app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()
