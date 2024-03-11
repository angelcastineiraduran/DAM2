import sqlite3 as dbapi

"""
print(dbapi.apilevel)
print(dbapi.threadsafety)
print(dbapi.paramstyle)
"""


bbdd = dbapi.connect("baseDatos.dat")
# print(bbdd)
c = bbdd.cursor()
# print(c)
try:
    c.execute("""create table usuarios (dni text,
                               nombre text,
                               edad integer,
                               genero text,
                               fallecido bool)""")
except dbapi.DatabaseError as e:
    print("Error creando la tabla de usuarios" + str(e))

try:
    c.execute("""insert into usuarios values ( '3333-a',"Ana Perez",19, "Mujer", True)""")
    c.execute("""insert into usuarios values ( '2222-b',"Roque Diz",56, "Hombre", FALSE)""")
    c.execute("""insert into usuarios values ( '1111-c',"Fiz Vidal",37, "Hombre", FALSE)""")
    c.execute("""insert into usuarios values ( '4444-c',"Rosa Pino",27, "Mujer", FALSE)""")
    bbdd.commit()
except dbapi.OperationalError as e:
    print("Error insertanto en la tabla de usuarios" + str(e))

'''
dni = "3333-a"
edad = 40
try:
    consulta = c.execute("""select dni, nombre from usuarios where dni = ? and edad <= ?""", (dni,edad,))
    print(type(consulta))

except dbapi.OperationalError as e:
    print("Error en la consulta de usuarios: "+ str(e))


# los fech sirven para ahorrar, mucho, de ser muchos los registros
for usuario in consulta.fetchall():
    print (usuario)
'''

'''
try:
    c.execute("""create table contraseñas (dni text, contraseña text)""")
except dbapi.DatabaseError as e:
    print("Error creando la tabla de contaseñas" + str(e))
'''

'''
try:
    c.execute("""insert into contraseñas values ( '3333-a',"maragato")""")
    c.execute("""insert into contraseñas values ( '2222-b',"pikachu")""")
    c.execute("""insert into contraseñas values ( '1111-c',"patatas")""")
    bbdd.commit()
except dbapi.OperationalError as e:
    print("Error insertanto en la tabla de contraseñas" + str(e))
'''


'''
try:
    consulta = c.execute("""select dni, contraseña from contraseñas""")
    print(consulta)

except dbapi.OperationalError as e:
    print("Error en la consulta de usuarios: "+ str(e))


for contraseña in consulta:
    print (contraseña)
'''



'''
try:
    c.execute("""drop table contraseñas""")
except dbapi.DatabaseError as e:
    print("Error borrando la tabla de contaseñas" + str(e))
'''