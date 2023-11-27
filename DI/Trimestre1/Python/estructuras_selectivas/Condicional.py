# --if--
calificacion = 5
if calificacion >= 5:
    print("Aprobado!")

# --if-else--

# --elif--
calificacion = 7
if calificacion >= 9:
    print("Sobresaliente!")
elif calificacion >= 7:
    print("Notable!")
elif calificacion == 6:
    print("Bien!")
elif calificacion == 5:
    print("Suficiente!")
else:
    print("Suspenso!!!")

# --Estructuras selectivas en cascada--
n1 = 2
n2 = 3
n3 = 5
if n1 > n2:
    if n1 > n3:
        print("n1 mayor a todos")
    else:
        print("n1 menor a n3")
else:
    print("n1 menor a n2")