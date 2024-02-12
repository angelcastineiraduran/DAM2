# Pueden tener indices de cualquier tipo
# Son asignaciones entre claves y valores
Equipo = {"Rafa": "Cientifico",
          "Pedro": "Analista",
          "Joao": "Ingeniero"
          }
# acceder elemento diccionario con la clave
# (por lo tanto me va a dar igual el orden, al contrario que las listas)
print(Equipo["Rafa"]) # > Cientifico

# key y value le puedo llamar como yo quiera
for key,value in Equipo.items():
    print(key, "-", value)