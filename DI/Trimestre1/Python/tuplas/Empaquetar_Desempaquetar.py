# Empaquetan datos cd se define la tupla:
# var saludos hace ref a 3 valores.
saludos = ("Buenos dias", "Buenas tarder", "Buenas noches")

# Desempaquetar datos cd a partir de una dupla se obtienen varios datos
manana, tarde, noche = saludos
print(manana)
print(tarde)
print(noche)

# ValueError pq el num de elementos del lado izq inferior a num ele tupla
saludo1, saludo2 = saludos
