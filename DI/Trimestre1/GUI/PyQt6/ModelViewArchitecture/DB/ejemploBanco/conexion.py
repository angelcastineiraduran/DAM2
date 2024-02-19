import sqlite3

class Conexion():
    def __init__(self, db_name):
        try:
            self.con = sqlite3.connect("banco.db")
            self.crearTablas()
        except Exception as ex:
            print(ex)

    def crearTablas(self):
        sql_create_table = """CREATE TABLE IF NOT EXISTS usuarios 
        (id INTEGER PRIMARY KEY AUTOINCREMENT, 
        nombre TEXT,
        usuario TEXT UNIQUE,
        clave TEXT)"""
        # Utilizamos conexion para conectarnos a la bd y ejecutar la consulta
        # y creo un cursor
        cur = self.con.cursor()
        # le digo que quiero ejecutar esa funcion
        cur.execute(sql_create_table)
        # cierro conexion y cursor
        cur.close()
        # hago la insercion despues de crear las tablas
        self.crearAdmin()

    # creamos usuario para conectarnos desde el sist
    def crearAdmin(self):
        try:
            sql_insert = """INSERT INTO usuarios VALUES 
            (null, {}, {}, {})""".format("Administrador", "Admin", "admin1234")
            cur = self.con.cursor()
            cur.execute(sql_insert)
            self.con.commit() # confirmamos la insercion del usuario
        except Exception as ex:
            print("Ya se creo el usuario admin",ex)

con = Conexion("holamundo")
