# secuencia de valores que pueden ser de cualquier tipo
l1 = [1,2,3,4,5,6,7,8,9,10] # de enteros
l2 = ["uno", "dos", "tres"] # de caracteres
l3 = ["hola", 32, 3.4, [10, 32]] # de todos

print(l3)

# el corchete permite acceder a los ele de una lista
print(l3[1])
# ultimo elemento de la lista
print(l3[-1]) # > [10, 32]
# elemento de sublista
print(l3[-1][1]) # > 32
# varios elementos
print(l2[0:2]) # > ['uno', 'dos']

# --Funciones--
print(len(l1))
# acceder al ultimo elemento de la l2 pero no se que longitud tiene
print(l1[len(l1)-1]) # > 10
