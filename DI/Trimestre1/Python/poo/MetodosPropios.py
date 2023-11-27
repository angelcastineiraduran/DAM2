class Cachorro:
    # Constructor: le da un estado inicial a una clase

    # Contructor predeterminado
    # el self es el this de otros lenguajes y representa al obj de la clase.
    # pq querriamos llamar a este contructor? para llamar a func de inicilizaciones dentro del mismo.
    # tambien podemos establecer variabes
    def __init__(self):
        self.tamanio = 20
        self.peso = 5

    # Constructor parametrizado
    def __init__(self, color, raza):
        self.color = color
        self.raza = raza

# para instanciar, no usamos el "new" si no que llamamos a la clase
# como si fuera un metodo, pasandole los argumentos que se definen en "__init__"
# la idea del constructor es establecer variables de objeto (como hacemos arriba)

perrito = Cachorro("marron", "Beagle")
print("Esto es un cachorro de color {} y de la raza {}".format(perrito.color, perrito.raza))
print(perrito) # ><__main__.Cachorro object at 0x000002882115A888>

class Cachorro:

    def __init__(self, color, raza, id):
        self.color = color
        self.raza = raza
        self.id = id

    # Metodo String
    def __str__(self):
        return """
Raza: {}
Color: {}""".format(self.raza, self.color)

    # igual que String pero diferencia es que se utiliza para que el mismo
    # lenguaje Python identifique que hay dentro. El metodo String utilizado para
    # que un humano sepa lo que hay dentro del obj y el repr() para que un programador
    # sepa que hay dentro del objeto
    def __repr__(self):
        # este es el formato en el que el interprete de python hace ref a los obj (aunque
        # falten cosas como la ref en memoria...)
        return "<Cachorro {}>".format(self.id)

perrito = Cachorro("marron", "Beagle", 1)
print(perrito)
print(repr(perrito)) # ><Cachorro 1>