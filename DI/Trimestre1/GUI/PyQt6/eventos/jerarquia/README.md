# Jerarquia
En algunos widget hay que especificar el 
padre y en otros no. En estos ultimos los podemos
inducir.

A. Ejemplo: padre explicito.

El padre de `QMenu` es `self` el cual hace
referencia al widget `MiVentanaPrincipal`
el cual hereda de `QMainWindow`.
```python
class MiVentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

    def contextMenuEvent(self, e):
        miContexto = QMenu(self)
        print(QMenu.parent())
        miContexto.addAction(QAction("test 1", self))
        miContexto.exec(e.globalPos())

app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()
```
Por lo tanto el padre de `QMenu` es `MiVentanaPrincipal`
`<__main__.MiVentanaPrincipal object at 0x7f49f2bee710>`

B. Ejemplo padre inducido
```python
class MiVentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi App")
        self.miBoton = QPushButton("Press me!")
        self.miBoton.clicked.connect(self.mouse_clicked)

        self.setCentralWidget(self.miBoton)

    def mouse_clicked(self):
        print(self.miBoton.parent())
        # ><__main__.MiVentanaPrincipal object at 0x7f902a192710>


app = QApplication(sys.argv)
miVentana = MiVentanaPrincipal()
miVentana.show()
app.exec()
```
-------
**Enconces, quien recibe el evento?**

>Explicacion en base al ejemplo del boton

Primero lo recibe el widget que lo emitio: 
`miBoton`.

Si el widget no puede manejar el evento o decide
no hacerlo, y recibe un turno. Este burbujeo 
continua hasta que se maneja el evento o llega
a la ventana principal.

En los propios controladores de eventos
podemos marcar un evento como llamada manejada:
```python
    class CustomButton(QPushButton)
        def mousePressEvent(self, e):
            e.accept()
```

O como no manejado:
```python
    class CustomButton(QPushButton)
        def mousePressEvent(self, e):
            e.ignore()
```