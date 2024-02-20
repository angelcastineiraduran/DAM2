import sqlite3

class Conexion():
    def __init__(self):
        try:
            self.con = sqlite3.connect("perfisUsuarios.bd")
        except Exception as ex:
            print(ex)


con = Conexion("holamundo")
