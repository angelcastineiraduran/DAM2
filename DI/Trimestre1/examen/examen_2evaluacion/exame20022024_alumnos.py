import sys
from PyQt6 import QtGui
from PyQt6 import QtCore
from PyQt6.QtCore import QSize, Qt
from PyQt6.QtGui import QImage, QColor
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (QApplication, QMainWindow, QGridLayout, QVBoxLayout, QHBoxLayout, QWidget,
                             QLabel, QListWidget, QPushButton, QComboBox,  QLineEdit,
                             QRadioButton, QGroupBox, QTableView)
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

        self.setWindowTitle("Exame 20-02-2024")
        gpbAlbara = QGroupBox("Albará")

        lblNumeroAlbara = QLabel("Número Albará")
        lblDataAlbara = QLabel("Data")
        lblDataEntrega = QLabel("Data entrega")
        lblNumeroCliente = QLabel("Número cliente")
        self.cmbNumeroAlbara = QComboBox()
        self.cmbNumeroAlbara.setEditable(False)
        self.cmbNumeroAlbara.currentTextChanged.connect(self.txt_modificado)
        self.txtDataAlbara = QLineEdit()
        self.txtDataEntrega = QLineEdit()
        self.txtNumeroCliente = QLineEdit()

        self.btnEngadir = QPushButton("Engadir")
        self.btnEditar = QPushButton("Editar")
        iconStick = QtGui.QIcon("tick.png")
        self.btnEngadir.setIcon(iconStick)
        self.btnBorrar = QPushButton("Borrar")
        color = QColor(QColor(Qt.GlobalColor.red))  # Color rojo en formato RGB
        self.btnBorrar.setStyleSheet(f"background-color: {color.name()};")
        iconCross = QtGui.QIcon("cross.png")
        self.btnBorrar.setIcon(iconCross)
        self.btnBorrar.pressed.connect(self.borrar_pressed)
        self.btnAceptar = QPushButton("Aceptar")
        self.btnCancelar = QPushButton("Cancelar")

        # ==================================
        #        TABLEVIEW
        # ==================================
        # -- CONEXION A LA BD --
        self.table = QTableView()
        self.conexion = ConexionBD(
            "/home/dam2/DAM2/DI/Trimestre1/examen/examen_2evaluacion/modelosClasicos.dat")
        self.conexion.conectaBD()
        self.conexion.creaCursor()

        # -- ALBARAN --
        # Consulto numeros albaran, los paso a tuple int y los paso a tuple str para poder
        # representarlos en el comboBox, si no no deja
        numerosAlbaran = self.conexion.consultaSenParametros("SELECT numeroAlbaran FROM ventas")
        numerosAlbaranInt = []
        for i in numerosAlbaran:
            na = int(i[0])
            numerosAlbaranInt.append(na)
        numerosAlbaranStr = tuple(map(str, numerosAlbaranInt))
        self.cmbNumeroAlbara.addItems(numerosAlbaranStr)

        # -- TABLE MODEL --
        txt = self.cmbNumeroAlbara.currentText()
        numAlba = str(txt)
        registros = self.conexion.consultaConParametros("SELECT codigoProducto,cantidade,prezoUnitario FROM detalleVentas WHERE numeroAlbaran=?", numAlba)
        self.model = TableModel(registros)
        self.table.setModel(self.model)

        # ==================================
        #        LAYOUTS
        # ==================================
        # -- LAYOUT ALBARAN --
        layoutAlbaran = QGridLayout()
        layoutAlbaran.addWidget(lblNumeroAlbara, 0, 0)
        layoutAlbaran.addWidget(lblDataAlbara, 1, 0)
        layoutAlbaran.addWidget(lblDataEntrega, 2, 0)
        layoutAlbaran.addWidget(lblNumeroCliente, 3, 0)

        layoutAlbaran.addWidget(self.cmbNumeroAlbara, 0, 1)
        layoutAlbaran.addWidget(self.txtDataAlbara, 1, 1)
        layoutAlbaran.addWidget(self.txtDataEntrega, 2, 1)
        layoutAlbaran.addWidget(self.txtNumeroCliente, 3, 1)

        containerAlbaran = QWidget()
        containerAlbaran.setLayout(layoutAlbaran)

        # -- LAYOUT BOTONES --
        layoutBotones = QHBoxLayout()
        layoutBotones.addWidget(self.btnEngadir)
        layoutBotones.addWidget(self.btnEditar)
        layoutBotones.addWidget(self.btnBorrar)
        containerBotones = QWidget()
        containerBotones.setLayout(layoutBotones)

        # -- LAYOUT BOTONES APP --
        layoutBotonesApp = QHBoxLayout()
        layoutBotonesApp.addWidget(self.btnCancelar)
        layoutBotonesApp.addWidget(self.btnAceptar)
        containerBotonesApp = QWidget()
        containerBotonesApp.setLayout(layoutBotonesApp)

        # -- LAYOUT PRINCIPAL --
        layoutPrincipal = QVBoxLayout()
        layoutPrincipal.addWidget(containerAlbaran)
        layoutPrincipal.addWidget(containerBotones)
        layoutPrincipal.addWidget(self.table)
        layoutPrincipal.addWidget(containerBotonesApp)
        containerPrincipal = QWidget()
        containerPrincipal.setLayout(layoutPrincipal)
        self.setCentralWidget(containerPrincipal)

    def txt_modificado(self):
        txt = self.cmbNumeroAlbara.currentText()
        numAlba = str(txt)
        print(f"Nuevo numero de albaran seleccionado: {numAlba}")
        dataAlbaran = self.conexion.consultaConParametros("SELECT dataAlbaran FROM ventas WHERE numeroAlbaran=?",
                                                          numAlba)
        dataEntrega = self.conexion.consultaConParametros("SELECT dataEntrega FROM ventas WHERE numeroAlbaran=?",
                                                          numAlba)
        numeroCliente = self.conexion.consultaConParametros("SELECT numeroCliente FROM ventas WHERE numeroAlbaran=?",
                                                          numAlba)

        self.txtDataAlbara.setText(str(dataAlbaran[0][0]))
        self.txtDataEntrega.setText(str(dataEntrega[0][0]))
        self.txtNumeroCliente.setText(str(numeroCliente[0][0]))
        registros = self.conexion.consultaConParametros(
            "SELECT codigoProducto,cantidade,prezoUnitario FROM detalleVentas WHERE numeroAlbaran=?", numAlba)
        self.model = TableModel(registros)
        self.table.setModel(self.model)

    def borrar_pressed(self):
        mensaje = input("Estas seguro que quieres borrar(SI/NO)?:")
        if mensaje=="SI":
            # Obtén la fila seleccionada
            row = self.table.currentIndex().row()
            column_codigoProducto = 0

            if row >= 0:
                try:
                    # Paso 1: Obtener el ID del usuario seleccionado
                    codigo_producto = self.model._data[row][column_codigoProducto]
                    codigo_productoStr = str(codigo_producto)
                    print("codigo prod", str(codigo_producto))
                    # Paso 2: Eliminar la fila del modelo
                    self.model.removeRows(position=row, rows=1)
                    # Paso 3: Eliminar la fila de la base de datos
                    #self.conexion.consultaConParametros("DELETE FROM detalleVentas WHERE codigoProducto = ?",2)
                    bien = self.conexion.eliminarUsuario(codigo_producto)
                    if bien: print("Se ha borrado la fila exitosamente")
                    else: print("***Algo ha fallado durante la eliminacion de la fila***")
                except Exception as e:
                    print(f"Error: {e}")
            else:
                print("Por favor, selecciona una fila antes de pulsar 'Borrar'")
        elif mensaje=="NO":
            print("Se ha cancelado la operacion de borrado")
        else: print("**consulta no entendida***")



aplicacion = QApplication(sys.argv)
fiestra = FiestraPrincipal()
fiestra.show()
aplicacion.exec()


"""conexion = ConexionBD(
    "/home/dam2/DAM2/DI/Trimestre1/examen/examen_2evaluacion/modelosClasicos.dat")
conexion.conectaBD()
conexion.creaCursor()

registros = conexion.consultaSenParametros("SELECT * FROM detalleVentas")
print(registros)
numerosAlbaran = conexion.consultaSenParametros("SELECT numeroAlbaran FROM ventas")
print(numerosAlbaran)
numerosAlbaranTuple = []
for i in numerosAlbaran:
    num = int(i[0])
    print(num)
    numerosAlbaranTuple.append(num)"""





