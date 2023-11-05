class Animal:
    def __init__(self, alimentacion, reproduccion):
        self.alimentacion = alimentacion
        self.reproduccion = reproduccion

    def __str__(self):
        #return super().__str__() #imprime ref obj
        return f"Alimentacion = {self.alimentacion} , Reproduccion = {self.reproduccion}"

    def reproducir(self):
        print ("se reproduce de manera vivipara")

class Tiburon(Animal):
    def reproducir(self):
        """sobreescribo conversando metodo de clase padre"""
        Animal.reproducir(self) #pq no es con super()?
        print("se reproduce de manera ovipara")
class Mono(Animal):
    def __init__(self, alimentacion, reproduccion, inteligencia):
        """sobreescribimos metodo pero conservando tambien clase padre"""
        super().__init__(alimentacion, reproduccion) #aqui no pasamos el self pq?
        self.inteligencia = inteligencia

    def __str__(self):
        return f"{super().__str__()}, Inteligencia = {self.inteligencia}"

class Avestruz(Animal):
    def reproducir(self):
        print("se reproduce de manera ovipara")

print("--TIBURON--")
tiburon = Tiburon("carnivora", "vivipara")
tiburon.reproducir()

print("--AVESTRUZ--")
avestruz = Avestruz(alimentacion="hervibora",reproduccion="ovipara")
avestruz.reproducir()

print("--MONO--")
mono = Mono(alimentacion="omnivora",reproduccion="vivipara",inteligencia="muy alta")
print(str(mono))
