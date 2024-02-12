import urllib.request

f = urllib.request.urlopen('https://www.marca.com')
for line in f:
    # le pongo 'ignore' pq algun byte especifico recibido no pertenece a UTF-8
    # y por lo tanto estaba dando problemas
    print(line.decode('utf-8', 'ignore').strip())