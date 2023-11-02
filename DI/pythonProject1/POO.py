class miClase:
    "docstring de la clase"
    def __init__(self, gasolina): #param, pertenece a func
        self.gasolina = gasolina #atributo, pertenece a obj
        self.neumaticos #neumaticos=None
        print("Tenemos", gasolina, "litros")

    def arrancar(self):
        if self.gasolina > 0:
            print("Arranca")
        else:
            print("No arranca")

mi_coche = miClase(3)
print(mi_coche.gasolina)
mi_coche.arrancar()