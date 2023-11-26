import sys
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        miBoton = QPushButton("Presioname")
        miBoton.setCheckable(True)
        miBoton.clicked.connect(self.btn_cicked)
        # segunda ranura para la misma señal que imprime el checkstate
        miBoton.clicked.connect(self.btn_checked)

        self.setCentralWidget(miBoton)

    def btn_cicked(self):
        print("Clicked!")

    def btn_checked(self, checked):
        print("Checked?: ", checked)

app = QApplication(sys.argv)

window = MainWindow()
window.show()

app.exec()