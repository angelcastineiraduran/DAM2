import sys
from PyQt6.QtWidgets import (
    QApplication,
    QMainWindow,
    QPushButton,
    QWidget,
    QVBoxLayout,
    QHBoxLayout,
    QLabel,
    QLineEdit,
    QGridLayout,
    QComboBox,
    QListWidget,
    QRadioButton,
)

from PyQt6.QtCore import Qt, QAbstractListModel

class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()
        self.setWindowTitle("Examen 12-12-2022")
        self.setFixedSize(800, 600)

        # --1. PRIMER LAYOUT--
        # 1.1. Etiquetas e Input
        miEtiquetaNome = QLabel("Nome")
        miEtiquetaTratamento = QLabel("Tratamento")
        miEtiquetaApelido = QLabel("Apelido")
        miEtiquetaTelefono = QLabel("Telefono")

        self.miInputNome = QLineEdit()
        self.miInputTratamento = QLineEdit()
        self.miInputApelido = QLineEdit()
        self.miInputTelefono = QLineEdit()

        miLayoutEtiquetasInput = QGridLayout()
        miLayoutEtiquetasInput.addWidget(miEtiquetaNome, 0, 0)
        miLayoutEtiquetasInput.addWidget(miEtiquetaTratamento, 1, 0)
        miLayoutEtiquetasInput.addWidget(miEtiquetaApelido, 0, 2)
        miLayoutEtiquetasInput.addWidget(miEtiquetaTelefono, 1, 2)
        miLayoutEtiquetasInput.addWidget(self.miInputNome, 0, 1)
        miLayoutEtiquetasInput.addWidget(self.miInputTratamento, 1, 1)
        miLayoutEtiquetasInput.addWidget(self.miInputApelido, 0, 3)
        miLayoutEtiquetasInput.addWidget(self.miInputTelefono, 1, 3)
        miWidgetLayoutEtiquetasInput = QWidget()
        miWidgetLayoutEtiquetasInput.setLayout(miLayoutEtiquetasInput)

        # 1.2. Formato
        miEtiquetaFormato = QLabel("Formato")
        miComboFormato = QComboBox()
        miComboFormato.setFixedSize(700,27)

        miLayoutFormato = QHBoxLayout()
        miLayoutFormato.addWidget(miEtiquetaFormato)
        miLayoutFormato.addWidget(miComboFormato)
        miWidgetFormato = QWidget()
        miWidgetFormato.setLayout(miLayoutFormato)

        # layout PRIMERO
        miLayoutPrimero = QVBoxLayout()
        miLayoutPrimero.addWidget(miWidgetLayoutEtiquetasInput)
        miLayoutPrimero.addWidget(miWidgetFormato)
        miWidgetLP = QWidget()
        miWidgetLP.setLayout(miLayoutPrimero)

        # --2. SEGUNDO LAYOUT--
        # 2.1 Lista y direccion
        self.miLista = QListWidget()
        miEtiquetaDireccion = QLabel("Direccion de correo")
        miInputDireccion = QLineEdit()

        miLayoutDireccion = QHBoxLayout()
        miWidgetDireccion = QWidget()
        miLayoutDireccion.addWidget(miEtiquetaDireccion)
        miLayoutDireccion.addWidget(miInputDireccion)
        miWidgetDireccion.setLayout(miLayoutDireccion)


        miLayoutListaDireccion = QVBoxLayout()
        miLayoutListaDireccion.addWidget(self.miLista)
        miLayoutListaDireccion.addWidget(miWidgetDireccion)
        miWidgetListaDireccion = QWidget()
        miWidgetListaDireccion.setLayout(miLayoutListaDireccion)

        # 2.2 Formato de Correo
        miEtiquetaCorreo = QLabel("Formato de correo:")
        self.miRadioHTML = QRadioButton("HTML")
        self.miRadioHTML.setCheckable(True)
        #self.miRadioHTML.clicked.connect(self.radio_html_clicked)
        self.miRadioHTML.clicked.connect(self.radio_clicked)
        self.miRadioTextoPlano = QRadioButton("Texto Plano")
        self.miRadioTextoPlano.setCheckable(True)
        #self.miRadioTextoPlano.clicked.connect(self.radio_texto_plano_clicked)
        self.miRadioTextoPlano.clicked.connect(self.radio_clicked)
        self.miRadioPersonalizado = QRadioButton("Personalizado")
        self.miRadioPersonalizado.setCheckable(True)
        #self.miRadioPersonalizado.clicked.connect(self.radio_personalizado_clicked)
        self.miRadioPersonalizado.clicked.connect(self.radio_clicked)

        miLayoutCorreo = QVBoxLayout()
        miLayoutCorreo.addWidget(miEtiquetaCorreo)
        miLayoutCorreo.addWidget(self.miRadioHTML)
        miLayoutCorreo.addWidget(self.miRadioTextoPlano)
        miLayoutCorreo.addWidget(self.miRadioPersonalizado)
        miLayoutCorreo.setAlignment(Qt.AlignmentFlag.AlignTop)
        miWidgetCorreo = QWidget()
        miWidgetCorreo.setLayout(miLayoutCorreo)

        # layout SEGUNDO
        miLayoutSegundo = QHBoxLayout()
        miLayoutSegundo.addWidget(miWidgetListaDireccion)
        miLayoutSegundo.addWidget(miWidgetCorreo)
        miWidgetLS = QWidget()
        miWidgetLS.setLayout(miLayoutSegundo)

        # --3. TERCER LAYOUT--
        miBotonEngadir = QPushButton("Engadir")
        miBotonEngadir.clicked.connect(self.boton_engadir_clicked)
        miBotonEditar = QPushButton("Editar")
        miBotonEditar.clicked.connect(self.boton_editar_clicked)
        miBotonBorrar = QPushButton("Borrar")
        miBotonDefecto = QPushButton("Por defecto")

        # layout TERCERO
        miLayoutTercero = QHBoxLayout()
        miLayoutTercero.addWidget(miBotonEngadir)
        miLayoutTercero.addWidget(miBotonEditar)
        miLayoutTercero.addWidget(miBotonBorrar)
        miLayoutTercero.addWidget(miBotonDefecto)
        miWidgetLT = QWidget()
        miWidgetLT.setContentsMargins(0,0,100,0)
        miWidgetLT.setLayout(miLayoutTercero)

        # -- 4. CUARTO LAYOUT --
        miBotonCancelar = QPushButton("Cancelar")
        miBotonCancelar.clicked.connect(self.boton_cancelar_clicked)
        miBotonAceptar = QPushButton("Aceptar")

        # layout CUARTO
        miLayoutCuarto = QHBoxLayout()
        miLayoutCuarto.addWidget(miBotonCancelar)
        miLayoutCuarto.addWidget(miBotonAceptar)
        miLayoutCuarto.setAlignment(Qt.AlignmentFlag.AlignRight)
        miWidgetLC = QWidget()
        miWidgetLC.setLayout(miLayoutCuarto)


        miLayoutPrincipal = QVBoxLayout()
        miLayoutPrincipal.addWidget(miWidgetLP)
        miLayoutPrincipal.addWidget(miWidgetLS)
        miLayoutPrincipal.addWidget(miWidgetLT)
        miLayoutPrincipal.addWidget(miWidgetLC)
        miWidgetPrincipal = QWidget()
        miWidgetPrincipal.setLayout(miLayoutPrincipal)
        self.setCentralWidget(miWidgetPrincipal)

    def boton_cancelar_clicked(self):
        print("Has cancelado el proceso")
        self.close()

    def radio_clicked(self):
        if(True == self.miRadioHTML.isChecked()):
            print("Formato de correo:", self.miRadioHTML.text())
        elif(True == self.miRadioTextoPlano.isChecked()):
            print("Formato de correo:", self.miRadioTextoPlano.text())
        elif(True == self.miRadioPersonalizado.isChecked()):
            print("Formato de correo:", self.miRadioPersonalizado.text())

    def boton_engadir_clicked(self):
        print("Has añadido un campo a la lista")
        nome = self.miInputNome.text()
        apelidos = self.miInputApelido.text()
        tlf = self.miInputTelefono.text()
        campos = (nome, apelidos, tlf)
        self.miLista.addItem(f"{nome}, {apelidos}, {tlf}")
        self.miInputNome.setText("")
        self.miInputApelido.setText("")
        self.miInputTelefono.setText("")

    def boton_editar_clicked(self):
        itemSeleccionado = self.miLista.currentItem()
        txtItem = itemSeleccionado.text()
        print(f"Has seleccionado editar la fila: {txtItem}")
        txtLista = (txtItem.split(","))
        self.miInputNome.setText(txtLista[0])
        self.miInputApelido.setText(txtLista[1])
        self.miInputTelefono.setText(txtLista[2])





app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()