# --Tipos--
# internas: max, min, len
# conversion de tipos: int("32"), float("34.23"), str(32)
# matematicas (hay que importar modulo math): math.log10(20), math.sin(90)
def mi_exponencial(numero, exponente, cte):
    import math
    exp = (numero**exponente)-math.sin(cte)
    return exp
print(mi_exponencial(3,2,90))


