import sqlite3 as dbapi

"""
print(dbapi.apilevel)
print(dbapi.threadsafety)
print(dbapi.paramstyle)
"""


bbdd = dbapi.connect("baseFactura.dat")
# print(bbdd)
c = bbdd.cursor()
# print(c)

try:
    c.execute("""
    CREATE TABLE facturar (
    cliente text,
    domicilio text,
    codigo_postal integer,
    nif text,
    fecha text,
    n_pedido integer,
    fecha_vencimiento text, 
    condiciones_pago text
    )
    """)
except dbapi.DatabaseError as e:
    print("Error creando la tabla de facturar" + str(e))

try:
    c.execute("""insert into facturar values ('Ana Perez', 'Calle de la Rosa', 27001, '3333-a', '12/12/2019', 123, '12/01/2020', '30 días')""")
    c.execute("""insert into facturar values ('Ana Perez', 'Calle de la Rosa', 27001, '3333-a', '12/12/2019', 123, '12/01/2020', '30 días')""")
    c.execute("""insert into facturar values ('Ana Perez', 'Calle de la Rosa', 27001, '3333-a', '12/12/2019', 123, '12/01/2020', '30 días')""")

    bbdd.commit()
except dbapi.OperationalError as e:
    print("Error insertanto en la tabla de facturar" + str(e))



def consultaFacturaA():
    try:
        consulta = c.execute("""SELECT * FROM facturar""")
        print(type(consulta))

    except dbapi.OperationalError as e:
        print("Error en la consulta de usuarios: "+ str(e))

def insertFactura(*params):
    try:
        c.execute("""INSERT INTO factura VALUES (?,?,?,?,?,?,?,?)""", params)
        bbdd.commit()
    except dbapi.OperationalError as e:
        print("Error insertanto en la tabla de facturar" + str(e))
