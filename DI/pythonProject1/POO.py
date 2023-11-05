class miClase:
    """docstring de la clase"""
    def __init__(self, gasolina): #param:gasolina, pertenece a func
        """se ejecuta justo despues de crear un nuevo obj"""
        self.gasolina = gasolina #atributo:gasolina, pertenece a obj
        print("Tenemos", gasolina, "litros")

    def arrancar(self):
        if self.gasolina > 0:
            print("Arranca")
        else:
            print("No arranca")

mi_coche = miClase(3)
print(mi_coche.gasolina)
mi_coche.arrancar()
