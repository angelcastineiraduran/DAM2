# Eventos
La conexión entre señal y ranura se puede 
lograr de varias maneras
```python
QtCore.QObject.connect(widget, QtCore.SIGNAL(‘signalname’), slot_function)
QtCore.QObject.connect(button, QtCore.SIGNAL(“clicked()”), slot_function)

# mas conveniente
widget.signal.connect(slot_function)
button.clicked.connect(slot_function)
```