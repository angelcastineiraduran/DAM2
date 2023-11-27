# --Operaciones basicas--
# index(), count(), len()
# se pueden concatenar y repetir
# permitido slicing e indexacion

ejemplo1 = ("Hola",)
repeticion = ejemplo1 * 3
print(repeticion)

ejemplo2 = (3, True)
concatenacion = ejemplo1 +ejemplo2
print(concatenacion)

# anidar
anidacion = "Hola", 223, ejemplo2
print(anidacion) # >('Hola', 223, (3, True))
anidacion = ejemplo1, ejemplo2
print(anidacion) # >(('Hola',), (3, True))

# convierte tupla a otro tipo de dato
letras = tuple("lagarto")
print(letras) # >('l', 'a', 'g', 'a', 'r', 't', 'o')

# --Comparacion--
# Mediante operadores relacionales SIEMPRE que
# tengan datos del mismo tipo.

