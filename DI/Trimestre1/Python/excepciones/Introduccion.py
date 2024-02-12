# Comunes:
# ValueError ej: se espera un numero y se ingresa cadena.
# NameError ej: se usa una var en una expresion sin haberle dado valor previamente.
# IndexError ej: se intenta acceder a un carac te una cadena que esta fuera de su longitud.
# TypeError ej: se utiliza una operacion aritmetica en un dato que es una cadena de caracteres.
# SintaxError ej: se escribe incorrectamente una expresion aritmetica (25 * 6 /). El IDE te lo marca.

# --Manejo Errores--
try:
    numero = "edoiw"
    print("El cuadrado del numero es", numero**2)
except TypeError: # podemos poner simplemente `except:`
    print("La var numero no es un numero entero")
