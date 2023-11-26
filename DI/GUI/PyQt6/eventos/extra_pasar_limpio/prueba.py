from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow #QApp..=controlador; QWid...=widget GUI basico

# Only needed for access to command line arguments
import sys

'''creamos instancia de QApplication donde le pasamos como argumento una list que contiene los 
argumentos de la linea de comando pasados a la app'''
app = QApplication(sys.argv)
#app = QApplication(sys.argv) #si se sabe que no se pasaran argumentos de la linea de comando para controla la Qt

'''instancia de QWidget(). en qt todos los widgets de nivel superior son ventanas, es decir, no tienen un padre.
Los widgets sin padre son invisibles de forma predeterminada. 
La app tiene que tener al menos 1 ventan y la app se cerrara cd se cierre la ultima ventana.
En Qt cualquier Widget puede ser una ventana'''
#window = QWidget() # agrega una ventana
window = QPushButton("Push me") # agrega un solo boton
window.show()  # IMPORTANT!!!!! Windows are hidden by default.

'''inicia el bucle de eventos'''
app.exec()
