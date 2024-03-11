import sys

from PyQt6.QtGui import QKeySequence
from PyQt6.QtWidgets import (QApplication, QMainWindow, QPushButton, QVBoxLayout,
                             QWidget, QHBoxLayout, QTableView, QLineEdit, QCheckBox, QGridLayout, QHeaderView)
from PyQt6.QtCore import QSize
from PyQt6.QtSql import QSqlDatabase, QSqlTableModel

from factura import Factura


class Ventana(QMainWindow):
    def __init__(self):
        # Inicializa la clase base QMainWindow
        super().__init__()
        self.setWindowTitle("Ejemplo QSTableModelView con modelo, con base de datos sql con Qt")

        bd = QSqlDatabase("QSQLITE")
        bd.setDatabaseName("baseFactura.dat")
        bd.open()

        cajaV = QVBoxLayout()

        self.tabla = QTableView()
        self.modelo = QSqlTableModel(db=bd)
        # cuando se cambia un campo se cambia en la base de datos
        # self.modelo.setEditStrategy(QSqlTableModel.EditStrategy.OnFieldChange)
        # no se sabe
        # self.modelo.setEditStrategy(QSqlTableModel.EditStrategy.OnRowChange)
        # no se aplican hasta que se haga un submit (boton aceptar)
        self.modelo.setEditStrategy(QSqlTableModel.EditStrategy.OnManualSubmit)

        self.tabla.setModel(self.modelo)
        # poner que se seleccione una fila entera
        self.tabla.setSelectionBehavior(QTableView.SelectionBehavior.SelectRows)
        # poner que se seleccione solo una fila
        self.tabla.setSelectionMode(QTableView.SelectionMode.SingleSelection)
        self.selection = self.tabla.selectionModel()
        self.selection.selectionChanged.connect(self.on_row_selected)
        self.tabla.horizontalHeader().setSectionResizeMode(QHeaderView.ResizeMode.ResizeToContents)

        self.modelo.setTable("facturar")
        self.modelo.select()

        grid = QGridLayout()
        self.cliente = QLineEdit()
        self.cliente.setPlaceholderText("Cliente")
        self.domicilio = QLineEdit()
        self.domicilio.setPlaceholderText("Domicilio")
        self.codigoPostal = QLineEdit()
        self.codigoPostal.setPlaceholderText("Código Postal")
        self.nif = QLineEdit()
        self.nif.setPlaceholderText("NIF")
        self.fecha = QLineEdit()
        self.fecha.setPlaceholderText("Fecha")
        self.nPedido = QLineEdit()
        self.nPedido.setPlaceholderText("Nº Pedido")
        self.fechaVencimiento = QLineEdit()
        self.fechaVencimiento.setPlaceholderText("Fecha Vencimiento")
        self.condicionesPago = QLineEdit()
        self.condicionesPago.setPlaceholderText("Condiciones de Pago")
        # (widget, fila, columna, rowspan, colspan)
        grid.addWidget(self.cliente,0,0,1,1)
        grid.addWidget(self.domicilio,1,0,1,1)
        grid.addWidget(self.codigoPostal,2,0,1,1)
        grid.addWidget(self.nif,3,0,1,1)
        grid.addWidget(self.fecha,0,1,1,1)
        grid.addWidget(self.nPedido,1,1,1,1)
        grid.addWidget(self.fechaVencimiento,2,1,1,1)
        grid.addWidget(self.condicionesPago,3,1,1,1)
        cajaV.addLayout(grid)


        cajaH = QHBoxLayout()
        btnAceptar = QPushButton("Aceptar")
        shorcut = QKeySequence("Ctrl+A")
        btnAceptar.setShortcut(shorcut)

        btnCancelar = QPushButton("Cancelar")
        cajaH.addWidget(btnAceptar)
        cajaH.addWidget(btnCancelar)
        btnAceptar.clicked.connect(self.on_btnAceptar_clicked)
        btnCancelar.clicked.connect(self.on_btnCancelar_clicked)

        cajaV.addWidget(self.tabla)
        cajaV.addLayout(cajaH)

        btnImprimir = QPushButton("Imprimir")
        btnImprimir.clicked.connect(self.on_btn_imprimir_clicked)
        cajaV.addWidget(btnImprimir)

        contenedor = QWidget()
        contenedor.setLayout(cajaV)
        self.setCentralWidget(contenedor)
        self.setMinimumSize(QSize(680, 300))
        self.show()

    def on_btn_imprimir_clicked(self):
        Factura(
            cliente=self.cliente.text().strip(),
            domicilio=self.domicilio.text().strip(),
            codigo_postal=self.codigoPostal.text().strip(),
            nif=self.nif.text().strip(),
            fecha=self.fecha.text().strip(),
            n_pedido=self.nPedido.text().strip(),
            fecha_vencimiento=self.fechaVencimiento.text().strip(),
            condiciones_pago=self.condicionesPago.text().strip()
        )

    def on_btn_engadir_clicked(self):
        # añadir un registro a la base de datos
        self.modelo.insertRow(self.modelo.rowCount())

    def on_btnAceptar_clicked(self):
        self.modelo.submitAll()
        print("Aceptar")

    def on_btnCancelar_clicked(self):
        self.modelo.revertAll()
        print("Cancelar")

    def on_row_selected(self):
        print("on_row_selected")
        index = self.tabla.selectedIndexes()
        print(index)
        if index:
            record = self.modelo.record(index[0].row())
            if not record.isEmpty():
                cliente = record.value(0)
                self.cliente.setText(record.value(0) if not record.isNull(0) else "")
                self.domicilio.setText(record.value(1) if not record.isNull(1) else "")
                self.codigoPostal.setText(str(record.value(2)) if not record.isNull(2) else "")
                self.nif.setText(record.value(3) if not record.isNull(3) else "")
                self.fecha.setText(record.value(4) if not record.isNull(4) else "")
                self.nPedido.setText(str(record.value(5)) if not record.isNull(5) else "")
                self.fechaVencimiento.setText(record.value(6) if not record.isNull(6) else "")
                self.condicionesPago.setText(record.value(7) if not record.isNull(7) else "")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = Ventana()
    app.exec() # para que se cierre la ventana al pulsar la x de la ventana