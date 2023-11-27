import sys
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QAction
from PyQt6.QtWidgets import QApplication, QLabel, QMainWindow, QMenu

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

    def contextMenuEvent(self, e): #'e' es un obj de evento que contiene info sobre el evento
        menu = QMenu(self)
        menu.addAction(QAction("Test 1", self))
        menu.addAction(QAction("Test 2", self))
        menu.addAction(QAction("Test 3", self))
        menu.exec(e.globalPos())

app = QApplication(sys.argv)

ventana = MainWindow()
ventana.show()

app.exec()