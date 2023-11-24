cad = "angel"
print(cad.capitalize())
print(cad.center(20))
print(cad.ljust(20))
print(cad.rjust(20,"*"))
frase = "Cuantas veces aparece angel en esta frase?"
print(frase.count(cad))
# posicion de cad
print(frase.find(cad))
cadVariada = "Angel3"
# True si solo esta formada de carac
print(cadVariada.isalpha()) # >False
# si solo esta formada por digitos
print(cadVariada.isdigit())
cad.islower()
cad.isupper()
cad.isspace()
len(cad) # longitud
print(frase.replace("a", "@"))
