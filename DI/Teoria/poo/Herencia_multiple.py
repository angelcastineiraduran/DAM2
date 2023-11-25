class Clase1:
    pass
class Clase2:
    pass
class Clase3:
    pass
class Clase4(Clase1, Clase2, Clase3):
    pass

print(Clase4.__mro__)
# >(<class '__main__.Clase4'>, <class '__main__.Clase1'>, <class '__main__.Clase2'>, <class '__main__.Clase3'>, <class 'object'>)