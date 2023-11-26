caracEspecial = "hola\nangel"
print(caracEspecial)
caracNoEspecial = r"hola\nangel"
print(caracNoEspecial) #hola\nangel

# LISTAS
print("\n**LISTAS**")
l = [22, True, "es una lista", [1, 2]]
mi_var = l[0]
mi_var1 = l[-1] #[1, 2]
print(mi_var1)
# Slicing
mi_var2 = l[1:4:2] #[True, [1, 2]]
print(mi_var2)
# Modificar listas
l[0:2] = ["sustitucion"] #l=['sustitucion' 'es una lista', [1, 2]]
print(l)

# TUPLAS
print("\n**TUPLAS**")
t = (1, 2, True, "python")
#t[0:2] = (2, 4) #error, no modificable


# BUCLE FOR
print("\n**BUCLE FOR**")
secuencia = ["uno", "dos", "tres"]
for i in secuencia:
    print(i)

#for i in range(5): #0,1,2,3,4
#for i in range(1,5): #1,2,3,4
for i in range(1,5,2): #1,3
    print(i)

# FUNCIONES

def mi_funcion1(param1, param2):
    """Esto es una docstring"""
    print (param1)
    print(param2)

mi_funcion1("Hola ", 3)
mi_funcion1(param1="Hola",param2=3)

def func_valPorDefecto(param1, param2="defecto"):
    print(param1 + param2)

func_valPorDefecto(param1="Por ")

def func_numArgVariable(param1, param2, *otros):
    """se crea una tupla: otros"""
    print(param1 + " " + param2 + " es: ")
    for val in otros:
        print(val)
func_numArgVariable("Mi", "edad") # tupla vacia
func_numArgVariable("Mi", "edad",1,2,3,4,5)

def func_numArgVariable(param1, param2, **otros):
    """se crea diccionario: otros"""
    print(param1 + " " + param2 + " es: ")
    for val in otros.items(): #items() devuelve lista con sus elementos
        print(val)

func_numArgVariable("Mi","Edad", tres = 3, cuatro = 4, cinco = 5)

def f(x, y): #pasar variable a param por referia o por valor
    x = x + 3
    y.append(23) # añade elemento a una lista
    print (x, y) # creo tupla con esos valores

x = 22
y = [22]
f(x, y) # 25 [22, 23]
print(x, y) # 22 [22, 23]

def sumar(x, y):
    """no devulve varios valores, si no que devuelve una tupla"""
    return x + y, x - y

suma = sumar(5,2)
print(suma) #(7, 3)
