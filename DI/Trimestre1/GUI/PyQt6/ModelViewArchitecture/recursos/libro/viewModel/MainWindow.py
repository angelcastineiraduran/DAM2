# Form implementation generated from reading ui file 'mainwindow.ui'
#
# Created by: PyQt6 UI code generator 6.4.2
#
# WARNING: Any manual changes made to this file will be lost when pyuic6 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt6 import QtCore, QtGui, QtWidgets


class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName("Dialog")
        Dialog.resize(400, 320)
        Dialog.setStyleSheet("background-color: rgb(255, 255, 255);")
        self.todoList = QtWidgets.QListView(parent=Dialog)
        self.todoList.setGeometry(QtCore.QRect(50, 20, 291, 141))
        self.todoList.setStyleSheet("color: rgb(0, 0, 0);")
        self.todoList.setObjectName("todoList")
        self.btnDelete = QtWidgets.QPushButton(parent=Dialog)
        self.btnDelete.setGeometry(QtCore.QRect(80, 180, 89, 25))
        self.btnDelete.setStyleSheet("color: rgb(0, 0, 0);")
        self.btnDelete.setObjectName("btnDelete")
        self.btnComplete = QtWidgets.QPushButton(parent=Dialog)
        self.btnComplete.setGeometry(QtCore.QRect(210, 180, 89, 25))
        self.btnComplete.setStyleSheet("color: rgb(0, 0, 0);")
        self.btnComplete.setObjectName("btnComplete")
        self.lineEdit = QtWidgets.QLineEdit(parent=Dialog)
        self.lineEdit.setGeometry(QtCore.QRect(50, 230, 291, 25))
        self.lineEdit.setObjectName("lineEdit")
        self.btnAdd = QtWidgets.QPushButton(parent=Dialog)
        self.btnAdd.setGeometry(QtCore.QRect(50, 260, 291, 25))
        self.btnAdd.setStyleSheet("color: rgb(0, 0, 0);")
        self.btnAdd.setObjectName("btnAdd")

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Dialog"))
        self.btnDelete.setText(_translate("Dialog", "Delete"))
        self.btnComplete.setText(_translate("Dialog", "Complete"))
        self.btnAdd.setText(_translate("Dialog", "Add Todo"))
