# Hay librerias que encapsulan todx lo del codigo anterior: urllib
# no hace falta instalarla y a que viene en python por defecto
import urllib.request

f = urllib.request.urlopen('http://localhost:8080')
# al contrario que el anterior, NO imprime la cabecera de HTTP
for line in f:
    # strip() me quita espacios en blanco
    print(line.decode().strip())