# Python

## Operadores

```python
^ xor
- not
<< desplazamento a esquerda
# 128<<1 --> 64
>> desplacemento a derecha
# 128>>3 --> 16
```

## Colecciones

### Listas

```python
lista = [1,2,3,4,5]
print(lista[3]) # imprime 4

lista2 = [[1,2,4],
        [2,4,2]]
print(lista2[1][2]) # imprime 7
lista[1][2] = 77 # cambio el valor de 2 --> 77
print(lista[1] ) # [2,4,77]


lista3 = [1, 2.0, "hola que tal", [3+7j, 23], 22, 33, 44, 55] # objetos:entero,float,string,lista
print(lista3[3][0]) # imprime [3+7j]
print(lista3[3]) # imprime [(3+7j),(23)]
print(lista3[0:8:3]) # empieza en 0, ultimo ele lista el 8, saltos de 3. imprime: [1,[(3+7j),23],44]
lista3 ) [0:3] = ["un", "dous", "tres", "catro"] # sustituyo el 0,1 y 2 por eso. imprime ["un", "dous", "tres", "catro", [3+7j, 23], 22, 33, 44, 55]

l = list() # lista vacia
```

### Tupla
No es dinamica al contrario que la lista. No se puede reasignar como en el ejemplo del 77 de antes.
Cualquier objeto que es dinamico es muy pesado. Porque estas añadiendo software extra para que sea posible esa funcionalidad extr que tiene la lista (mayor numero de librerias)

Caracteristicas
* Utilizo parentesis
* inmutable

```python
# lista de un elemento vs tupla de un elemento
lista1 = ["un"]
tupla1 = ("un") # no crea un tipo dupla, crea string
print(tupla1[0]) # u
tupla1 = ("un",) # crea un tipo dupla
print(tupla1[0]) # un
# cuando hay + de 1 ele no hay problema, porque ya poner cmas para separar los distintos elementos
# utilizando el constructor "tuple()" no hace falta utilizar el operador ","
tupla2 = tuple("un") # puedo crearla con palabra reservada
tupla3 = tuple(["un"]) # tupla de una lista
```

Una String es parecida a una tupla ya que es una coleccion de caracteres inmutable y por eso podemos hacer cosas como esta:

```python
cadea = "el patio de mi casa"
print(cadea [4:10]) # atio d
```

### Diccionarios
* Las claves son inmutables, los valores no. Accedes a los valores por las claves
* creo que se pueden añadir elementos

```python
diccionario =
{1 : "Un",
 2 : "Dous",
 3 : "Tres"
}
print(diccionario[3]) # tres
diccionario[3] ? 2
print(diccionario[3]) # 2

```

### Condicionales
* si en el bloque no hay por lo menos 1 instruccion, da error. de que tipo? en java
no pasaria esto?No
* codigo se tabula con espacios - bloque de codigo todo lo que esta tabulado
* num bloques libre

```python
variable = 3
if variable == 3: # bloque de codigo se marca con ":"
 # bloque codigo
else
 # ""
# finaliza
```

### Bucles
```python
while variable < 20:
 variable = variable + 1
 print ("O valor é" + str(variable)) # necesario es cast para que me imprima el int
 if variable = 16:
  break
 else
  print ("sigo en bucle")

numeros = [1,2,3,4,5] # toda collecion debe llamarse en plural: antes se llamaba "lista" pero lista no dice nada (muy generico)
suma = 0
for numero in numeros:
 print (numero)
 suma = suma + numero
print suma

# generadores = funcion que genera ...??

" REPRESENTACION en Java: for(int i = 1; i < 20; i++) con for x in "
for i in range(5)
 print (i) # 1,2,3,4

for i in range(5,17,3) # empiez 5, acaba en 17 (no incluido), saltos de 3 en 3

numeros = ("cero", "un", "dous", "tres")

for i in range(len(numeros)): # len = longitud, serian 4 -> *1
 print(numeros[i]) # imprime posiciones del 1 al 3 (pq 4 esta en el limite)

# no la entiendo???
for i, numero in enumerate (numeros): # enumerate me devuelve una tupla ...????
 print (str(i) + " " + numeros[i]) # no hay que castearlo????
```


PREGUNTAR MANUEL ARRIBAAAAAAA!!!!





