# Menús Contextuales
Menus que aparecen normalmente al hacer click 
derecho en una ventana (como el de windows).

```python
    def contextMenuEvent(self, e):
        miContexto = QMenu(self)
        miContexto.addAction(QAction("test 1", self))
        miContexto.addAction(QAction("test 2", self))
        miContexto.addAction(QAction("test 3", self))
        miContexto.exec(e.globalPos())
```
Al pasar la posición inicial a la exec() función, 
esta debe ser relativa al padre pasado durante 
la definición. En este caso lo pasamos `self` como padre, 
por lo que podemos usar la posición global.

También existe un menú basado en señales para crear
menús contextuales:


