import os
import sys
from PyQt6 import QtCore
from PyQt6.QtCore import QSize, Qt
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (QApplication, QMainWindow, QGridLayout, QVBoxLayout, QHBoxLayout, QWidget,
                             QLabel, QListWidget, QPushButton, QComboBox,  QLineEdit,
                             QRadioButton, QGroupBox, QTableView)
from PyQt6.QtSql import QSqlDatabase, QSqlTableModel
from conexionBD import ConexionBD

class TableModel(QtCore.QAbstractTableModel):
    def __init__(self, data):
        super().__init__()
        self._data = data

    def data(self, index, role):
        if role == Qt.ItemDataRole.DisplayRole:
            return self._data[index.row()][index.column()]

    def rowCount(self, index):
        return len(self._data)

    def columnCount(self, index):
        return len(self._data[0])

    def insertRows(self, position, rows, parent=QtCore.QModelIndex, valores = []):
        self.beginInsertRows(QtCore.QModelIndex(), position, position + rows -1)
        for i in range(rows):
            self._data.insert(position, valores)
        self.endInsertRows()
        return True

    def removeRows(self, position, rows, parent=QtCore.QModelIndex):
        self.beginRemoveRows(QtCore.QModelIndex(), position, position + rows - 1)
        del self._data[position:position + rows]
        self.endRemoveRows()
        return True
class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exame 19-02-2024")

        gpbCliente = QGroupBox("Cliente")

        lblNumeroCliente = QLabel("Número Cliente")
        lblNomeCliente = QLabel("Nome")
        lblApelidosCliente = QLabel("Apelidos")
        lblDirección = QLabel("Dirección")
        lblCidade = QLabel("Cidade")
        lblProvinciaEstado = QLabel("Provincia")
        lblCodigoPostal = QLabel("Código postal")
        lblTelefono = QLabel("Teléfono")
        self.txtNumeroCliente = QLineEdit()
        self.txtNomeCliente = QLineEdit()
        self.txtApelidosCliente = QLineEdit()
        self.txtDireccion = QLineEdit()
        txtCidade = QLineEdit()
        txtProvinciaEstado = QLineEdit()
        txtCodigoPostal = QLineEdit()
        txtTelefono = QLineEdit()

        self.btnEngadir = QPushButton("Engadir")
        self.btnEngadir.pressed.connect(self.engadir_pressed)
        btnEditar = QPushButton("Editar")
        self.btnBorrar = QPushButton("Borrar")
        self.btnBorrar.pressed.connect(self.borrar_pressed)
        layoutBtns = QHBoxLayout()
        layoutBtns.addWidget(self.btnEngadir)
        layoutBtns.addWidget(self.btnBorrar)
        containerBtns = QWidget()
        containerBtns.setLayout(layoutBtns)

        btnAceptar = QPushButton("Aceptar")
        btnCancelar = QPushButton("Cancelar")

        self.table = QTableView()
        data = [
        [4, 1, 3, 3, 7],
        [9, 1, 5, 3, 8],
        [2, 1, 5, 3, 9],
        ]

        # =====================
        #         DATA
        # =====================
        """self.conexion = ConexionBD(
            "/home/ubuntu/DAM2/DI/Trimestre1/GUI/PyQt6/ModelViewArchitecture/pruebaExamen/perfisUsuarios.bd")"""
        self.conexion = ConexionBD("/home/dam2/DAM2/DI/Trimestre1/GUI/PyQt6/ModelViewArchitecture/pruebaExamen/perfisUsuarios.bd")
        self.conexion.conectaBD()
        self.conexion.creaCursor()
        registros = self.conexion.consultaSenParametros("SELECT t.* FROM usuarios t")

        #self.model = TableModel(data)
        self.model = TableModel(registros)
        self.table.setModel(self.model)

        layoutCampos = QGridLayout()
        layoutCampos.addWidget(lblNomeCliente, 0, 0)
        layoutCampos.addWidget(lblApelidosCliente, 1, 0)
        layoutCampos.addWidget(lblNumeroCliente, 2, 0)
        layoutCampos.addWidget(lblDirección, 3, 0)
        layoutCampos.addWidget(self.txtNomeCliente, 0, 1)
        layoutCampos.addWidget(self.txtApelidosCliente, 1, 1)
        layoutCampos.addWidget(self.txtNumeroCliente, 2, 1)
        layoutCampos.addWidget(self.txtDireccion, 3, 1)
        containerCampos = QWidget()
        containerCampos.setLayout(layoutCampos)

        layout = QVBoxLayout()
        layout.addWidget(containerCampos)
        layout.addWidget(self.table)
        layout.addWidget(containerBtns)
        container = QWidget()
        container.setLayout(layout)
        self.setCentralWidget(container)

    def engadir_pressed(self):
        nome = self.txtNomeCliente.text()
        apelidos = self.txtApelidosCliente.text()
        numero = self.txtNumeroCliente.text()
        direccion = self.txtDireccion.text()
        registro = [nome, apelidos, numero, direccion]
        if self.conexion.insertarUsuario(nome=nome):
                print("Insercion a la BD exitosa!")
                #insertado = self.model.insertRows(rows=1, position=ultimaPosicion+1, valores=registro)
                registros = self.conexion.consultaConParametros("SELECT t.* FROM usuarios t")
                insertado = self.model.insertRows(rows=1, position=len(registros), valores=registros[-1])
                if insertado:
                    print(f"Usuario añadido a tabla: {nome}, {apelidos}, {direccion}, {numero}")
                else:
                    print("Ha ocurrido un error insertando")
        else:
            print("Algo ha fallado en la insercion a la BD")
    def borrar_pressed(self):
        # Obtén la fila seleccionada
        row = self.table.currentIndex().row()
        column_dni = 1

        if row >= 0:
            # Paso 1: Obtener el ID del usuario seleccionado
            id_usuario = self.model._data[row][column_dni]
            # Paso 2: Eliminar la fila del modelo
            self.model.removeRows(position=row, rows=1)
            # Paso 3: Eliminar la fila de la base de datos
            if self.conexion.eliminarUsuario(id_usuario):
                print("Usuario eliminado de la BD")
            else:
                print("Error al eliminar el usuario de la BD")
        else:
            print("Por favor, selecciona una fila antes de pulsar 'Borrar'")

aplicacion = QApplication(sys.argv)
fiestra = FiestraPrincipal()
fiestra.show()
aplicacion.exec()

"""conexion = ConexionBD("/home/ubuntu/DAM2/DI/Trimestre1/GUI/PyQt6/ModelViewArchitecture/pruebaExamen/perfisUsuarios.bd")
conexion.conectaBD()
conexion.creaCursor()
consulta = conexion.consultaSenParametros("SELECT t.* FROM usuarios t")
print(consulta)"""