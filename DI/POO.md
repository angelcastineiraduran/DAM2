# POO
## Clases
* todas las clases son publicas, no existen modificadores de acceso
* cuando llamamos al metodo `__init__`(inicializador) la instancia ya esta hecha. en java necesitas reservar variables variables en memoria antes de crear la clase. Pero en python, al hacerse dinamicamente
no hace falta, la clase se referencia a si misma. no es el constructor, es un metodo para inicializar.
* `self` == `this`, no se puede utilizar si no se añade en los param del metodo?? se tiene que poner siempre. Se utiliza para hacer referencia a algo
* tiene herencia multiple. Aquí no hay interfaces (con esto resolviamos lo de la herencia unica en Java)

```python
class Punto:
 """
 Clase que define a un punto nun plano bidimensional
 """
 def __init__(self,x,y): # se tiene que poner siempre el self
  self.x = x # declaro variable

  p1 = Punto(1.0, 2.3)
  p1.x = 15.66


 def __init__(self,x=0,y=0): # inicializo
  self.x = x
  self.y = y

class Circulo (Punto): # indico que Circulo era de Punto
"""
clase que representa un circulo centrado en un punto

A partir de aquí no atendi nada
"""
 def __init__(self, x=0, x=0, r=1):
  Punto.__init__(x, y)
  self.r = r

  def superficie(self):
  return math.pi * self.r

p1 = Punto(1,3)
p1.x = 3
print (p1.x, p1.y)
p1.x3 = 3
print (p1.x, p1.y)
```
