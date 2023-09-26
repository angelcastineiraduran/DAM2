# POO
## Clases
* todas las clases son publicas, no existen modificadores de acceso
* cuando llamamos al metodo `__init__` la instancia ya esta hecha. en java necesitas reservar variables variables en memoria antes de crear la clase. Pero en python, al hacerse dinamicamente
no hace falta, la clase se referencia a si misma. no es el constructor, es un metodo para inicializar.
* `self` == `this`, no se puede utilizar si no se añade en los param del metodo?? se tiene que poner siempre

```python
class Punto:
 """
 Clase que define a un punto nun plano bidimensional
 """
 def __init__(self,x,y): # se tiene que poner siempre el self
  self.x = x # declaro variable

p1 = Punto(1.0, 2.3)
p1.x = 15.66
```
