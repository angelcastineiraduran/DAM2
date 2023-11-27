# QtWidgets es un modulo de PyQt6 y estoy importando las clases que hay dentro de este.
# Los principales modulos de Qt son: QtWidgets y QtGui.QtCore
from PyQt6.QtWidgets import QApplication, QWidget

import sys

# le pasamos una python list que contienen los argumentos de la linea de comando pasados
# a la app
miApp = QApplication(sys.argv)
# se se sabe que no se va a usar los arg de la linea de comandos, podemos usar lista vacia
#miApp = QApplication([])
# creo un widget vacio, es la clase base para el resto de widgets
miVentana = QWidget()
# los widgets son invisibles de forma predeterminada.
miVentana.show()

# para iniciar el bucle de eventos
miApp.exec()