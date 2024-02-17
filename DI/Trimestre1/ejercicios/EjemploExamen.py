import sys
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (
    QApplication,
    QMainWindow,
    QPushButton,
    QHBoxLayout,
    QVBoxLayout,
    QWidget,
    QRadioButton,
    QCheckBox,
    QLabel,
    QListWidget,
    QGridLayout,
    QComboBox,
    QSlider
)
from PyQt6.QtCore import Qt, QAbstractListModel

class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Examen")
        self.setFixedSize(800, 500)

        # --Mi Layout Primero--
        # 1.1
        miImagen = QLabel()
        miMapaPixeles = QPixmap("icons/cd-case.svg")
        miImagen.setPixmap(miMapaPixeles)
        miCasilla = QCheckBox("Animado")

        miLayoutAnimado = QVBoxLayout()
        miLayoutAnimado.addWidget(miImagen)
        miLayoutAnimado.addWidget(miCasilla)
        miLayoutAnimado.setAlignment(Qt.AlignmentFlag.AlignTop)
        miWidgetAnimado = QWidget()
        miWidgetAnimado.setLayout(miLayoutAnimado)

        # 1.2
        self.miLista = QListWidget()
        self.miLista.setFixedSize(200,200)
        self.miLista.setContentsMargins(0,0,0,0)

        # 1.3
        miBtn1 = QPushButton("Engadir a pista a reproducir")
        miBtn1.clicked.connect(self.boton_aniadir_clicked)
        miBtn2 = QPushButton("Subir na lista")
        miBtn2.clicked.connect(self.boton_subir_clicked)
        miBtn3 = QPushButton("Baixar na lista")
        miBtn3.clicked.connect(self.boton_baixar_clicked)
        miBtn4 = QPushButton("Saltar")
        miBtn5 = QPushButton("Abrir fichero")
        miBtn6 = QPushButton("Guardar como")
        miBtn7 = QPushButton("Eliminar pista")
        miBtn7.clicked.connect(self.boton_eliminar_clicked)
        miLayoutBotones = QVBoxLayout()
        miLayoutBotones.addWidget(miBtn1)
        miLayoutBotones.addWidget(miBtn2)
        miLayoutBotones.addWidget(miBtn3)
        miLayoutBotones.addWidget(miBtn4)
        miLayoutBotones.addWidget(miBtn5)
        miLayoutBotones.addWidget(miBtn6)
        miLayoutBotones.addWidget(miBtn7)
        miLayoutBotones.setAlignment(Qt.AlignmentFlag.AlignTop)
        miWidgetBotones = QWidget()
        miWidgetBotones.setLayout(miLayoutBotones)

        miLayoutPrimero = QGridLayout()
        miLayoutPrimero.addWidget(miWidgetAnimado, 0, 0)
        miLayoutPrimero.addWidget(self.miLista, 0, 1)
        miLayoutPrimero.addWidget(miWidgetBotones, 0, 2)
        miLayoutPrimero.setContentsMargins(0,0,0,0)
        miWidgetLP = QWidget()
        miWidgetLP.setLayout(miLayoutPrimero)

        # --Mi Layout Segundo--

        # 2.1.1
        miEtiqueta1 = QLabel("Son")
        miEtiqueta2 = QLabel("Ritmo")
        miEtiqueta3 = QLabel("Volume")
        miEtiqueta4 = QLabel("Formato")
        miEtiqueta5 = QLabel("Salida de audio")

        miLayoutEtiquetas = QVBoxLayout()
        miLayoutEtiquetas.addWidget(miEtiqueta1)
        miLayoutEtiquetas.addWidget(miEtiqueta2)
        miLayoutEtiquetas.addWidget(miEtiqueta3)
        miLayoutEtiquetas.addWidget(miEtiqueta4)
        miLayoutEtiquetas.addWidget(miEtiqueta5)
        miWidgetEtiquetas = QWidget()
        miWidgetEtiquetas.setLayout(miLayoutEtiquetas)

        # 2.1.2
        self.miComboSon = QComboBox()
        self.miComboSon.addItems(["Perfect", "Despacito", "BohemianRapsody"])
        self.miComboSon.setCurrentIndex(-1)
        miSliderRitmo = QSlider(Qt.Orientation.Horizontal)
        miSliderVoulume = QSlider(Qt.Orientation.Horizontal)
        miComboFormato = QComboBox()
        miComboFormato.addItems(["mp3", "mp4", "mp5"])
        miComboFormato.setCurrentIndex(-1)
        miComboSalida = QComboBox()
        miComboSalida.addItems(["altavoces", "cascos", "auriculares"])
        miComboSalida.setCurrentIndex(-1)

        miLayoutSelectores = QVBoxLayout()
        miLayoutSelectores.addWidget(self.miComboSon)
        miLayoutSelectores.addWidget(miSliderRitmo)
        miLayoutSelectores.addWidget(miSliderVoulume)
        miLayoutSelectores.addWidget(miComboFormato)
        miLayoutSelectores.addWidget(miComboSalida)
        miWidgetSelectores = QWidget()
        miWidgetSelectores.setLayout(miLayoutSelectores)

        miLayoutSelectoresEtiquetas = QHBoxLayout()
        miLayoutSelectoresEtiquetas.addWidget(miWidgetEtiquetas)
        miLayoutSelectoresEtiquetas.addWidget(miWidgetSelectores)
        miWigetSE = QWidget()
        miWigetSE.setLayout(miLayoutSelectoresEtiquetas)

        # 2.3
        miEtiquetaOR = QLabel("Opciones de reproduccion")

        miCasilla1 = QCheckBox("Asincrono")
        miCasilla2 = QCheckBox("E nome do ficheiro")
        miCasilla3 = QCheckBox("XML persistente")
        miCasilla4 = QCheckBox("Filtrar antes de reproducir")
        miCasilla5 = QCheckBox("E XML")
        miCasilla6 = QCheckBox("Reproducir NPL")

        miLayoutCasillas = QGridLayout()
        miLayoutCasillas.addWidget(miCasilla1, 0, 0)
        miLayoutCasillas.addWidget(miCasilla2, 1, 0)
        miLayoutCasillas.addWidget(miCasilla3, 2, 0)
        miLayoutCasillas.addWidget(miCasilla4, 0, 1)
        miLayoutCasillas.addWidget(miCasilla5, 1, 1)
        miLayoutCasillas.addWidget(miCasilla6, 2, 1)
        miWidgetCasillas = QWidget()
        miWidgetCasillas.setLayout(miLayoutCasillas)

        miLayoutOpcionesRepro = QVBoxLayout()
        miLayoutOpcionesRepro.addWidget(miEtiquetaOR)
        miLayoutOpcionesRepro.addWidget(miWidgetCasillas)
        miWidgetOpcionesRepro = QWidget()
        miWidgetOpcionesRepro.setLayout(miLayoutOpcionesRepro)

        miChek1 = QCheckBox("Check 1")
        miChek2 = QCheckBox("Check 2")
        miLayoutChecks = QVBoxLayout()
        miLayoutChecks.addWidget(miChek1)
        miLayoutChecks.addWidget(miChek2)
        miWidgetChecks = QWidget()
        miWidgetChecks.setLayout(miLayoutChecks)

        miRadioB1 = QCheckBox("Radio 1")
        miRadioB2 = QCheckBox("Radio 2")
        miLayoutRadios = QVBoxLayout()
        miLayoutRadios.addWidget(miRadioB1)
        miLayoutRadios.addWidget(miRadioB2)
        miWidgetRadios = QWidget()
        miWidgetRadios.setLayout(miLayoutRadios)

        miLayoutSegundo = QGridLayout()
        miLayoutSegundo.addWidget(miWigetSE, 0, 0)
        miLayoutSegundo.addWidget(miWidgetOpcionesRepro, 0, 1)
        miLayoutSegundo.addWidget(miWidgetChecks, 1, 0)
        miLayoutSegundo.addWidget(miWidgetRadios, 1, 1)
        miWidgetLS = QWidget()
        miWidgetLS.setLayout(miLayoutSegundo)

        miLayoutTotal = QVBoxLayout()
        miLayoutTotal.addWidget(miWidgetLP)
        miLayoutTotal.addWidget(miWidgetLS)
        miWidgetT = QWidget()
        miWidgetT.setLayout(miLayoutTotal)
        self.setCentralWidget(miWidgetT)

    def boton_aniadir_clicked(self):
        print("Has añadido una nueva cancion")
        self.miLista.addItem(self.miComboSon.currentText())

    def boton_subir_clicked(self):
        cancion = self.miLista.currentItem()
        cancionIndice = self.miLista.row(cancion)
        print(f"Has subido la cancion {cancion.text()} en la lista")
        self.miLista.takeItem(cancionIndice) # la elimino
        self.miLista.insertItem(0, cancion) # se reordenan automaticamente

    def boton_baixar_clicked(self):
        cancion = self.miLista.currentItem()
        cancionIndice = self.miLista.row(cancion)
        print(f"Has bajado la cancion {cancion.text()} en la lista")
        self.miLista.takeItem(cancionIndice)
        # deberia quedarse en la ultima fila pero sube a la primera
        self.miLista.insertItem(-1, cancion)

    def boton_eliminar_clicked(self):
        cancion = self.miLista.currentItem()
        cancionIndice = self.miLista.row(cancion)
        print(f"Has eliminado la cancion {cancion.text()} en la lista")
        self.miLista.takeItem(cancionIndice)

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()