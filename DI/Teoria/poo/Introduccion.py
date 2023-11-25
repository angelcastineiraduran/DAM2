class Coche:
    """simple clase"""
    i = 1234

    # el objeto es pasado como primer argumento de la funcion
    def desplazamiento(self):
        # le indicamos al interprete que aun no le hemos definido ningun comportamiento
        # si no escribimos nada = error.
        pass

    # "self" no es obligatorio, pero si no se pasa no podras llamarlo desde la instancia de la clase,
    # si no, desde la clase misma (como las llamadas estaticas)



# objeto vacio
x = Coche()

# ambos son iguales:
# no se le pasa arg "self" pq ya se encarga la clase de esto.
print(x.desplazamiento())
print(Coche.desplazamiento(x))
