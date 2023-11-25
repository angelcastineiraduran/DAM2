class Padre:
    cabello = "negro"
    ojos = "azules"

    def conducir_coche(self):
        print("La persona sabe conducir coches")

class Hijo(Padre):
    def conducir_motos(self):
        print("La persona sabe conducir motos")

# atributo que te permite acceder a la clase base.
print(Hijo.__bases__) # >(<class '__main__.Padre'>,)
print(Padre.__subclasses__()) # >[<class '__main__.Hijo'>]


class Animal:
    def __init__(self, especie, edad):
        self.especie = especie
        self.edad = edad
    def hablar(self):
        pass

    def moverse(self):
        pass

    def describeme(self):
        print("Soy un Animal del tipo", type(self).__name__)

class Perro(Animal):
    def __init__(self, especie, edad, duenio):
        # Alternativa 1
        # self.especie = especie
        # self.edad = edad
        # self.dueño = dueño

        # Alternativa 2
        super().__init__(especie, edad)
        self.duenio = duenio

miPerro = Perro("mamifero", 4, "Alberto")
