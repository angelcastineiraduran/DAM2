# --Concatenacion--
# se dice que el operador "+" = sobrecargado, ya que depedinedo
# de los datos que le des hace diferentes funciones.
from nis import cat

cad1 = "Hola "
cad2 = "Angel"
cadTotal = cad1 + cad2
print(cadTotal)

# --Repeticion--
# tambien "*" se considera sobrecargado
cadReptir = cad1 * 3
print(cadReptir)

# --Comparacion--
# por medio de operadores relacionales:
# >, <, >=, <=, ==, !=

# --Indexacion--
# para consultar que posicion ocupa cierto caracter.
print(cad2[2])
print(cad2[-1]) # imprime ultimo # [inicio:fin:salto]carac

# --Slicing
# para obtener subcadenas a partir de una cadena
# [inicio:fin:salto]
cad = "Hola como estas"
print(cad[0:5:2]) # >Hl
print(cad[::2]) # >Hl ooets
print(cad[:]) # >Hola como estas
print(cad[0:3]) # >Hol
print(cad[:4]) # >Hola
print(cad[4:]) # > como estas
print(cad[::-1]) # >satse omoc aloH
print(cad[-10::-1]) # >c aloH
print(cad[:-1]) # >Hola como esta
print(cad[:-5:-1]) # >sats
