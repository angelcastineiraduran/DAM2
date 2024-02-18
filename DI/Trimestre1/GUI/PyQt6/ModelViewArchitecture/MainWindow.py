import sys

from PyQt6.QtWidgets import (
QApplication,
QCheckBox,
QComboBox,
QLabel,
QLineEdit,
QMainWindow,
QPlainTextEdit,
QPushButton,
QSpinBox,
QVBoxLayout,
QWidget,
QListView,
QHBoxLayout
)

# ESTA MAL, NO LO ENTIENDO!!! CAMBIAR!!!!

class Ui_MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        #self.main_window = main_window
        self.setupUi()
    def setupUi(self):
        #self.main_window.setWindowTitle("MV Tester") #?
        self.setWindowTitle("mv tst")
        self.todoList = QListView()

        self.deleteButton = QPushButton("Delete")
        self.completeButton = QPushButton("Complete")
        widgetBtns = QWidget()
        layoutBtns = QHBoxLayout()
        layoutBtns.addWidget(self.deleteButton)
        layoutBtns.addWidget(self.completeButton)
        widgetBtns.setLayout(layoutBtns)

        self.todoEdit = QLineEdit()
        self.addButton = QPushButton("Add Todo")

        widgetMain = QWidget()
        layoutMain = QVBoxLayout()
        layoutMain.addWidget(self.todoList)
        layoutMain.addWidget(widgetBtns)
        layoutMain.addWidget(self.todoEdit)
        layoutMain.addWidget(self.addButton)
        widgetMain.setLayout(layoutMain)
        self.setCentralWidget(widgetMain)
        #self.main_window.setCentralWidget(widgetMain) # ?

    def todoView(self):
        return self.todoList