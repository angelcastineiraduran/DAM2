import socket
mysock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# --Entro en el servidor--
# arg = tupla
# recibe SOLO la direccion y el puerto al que hay que conectarse
mysock.connect(('localhost', 8080))
# --Solicito un archivo--
# creo cadena de caracteres que siga el protocolo HTTP
# `/` obtengo la raiz del servidor
# `\r` en HTTP siginifica retorno de carro
# `\n` en HTTP siginifica nueva linea
# esos caracteres de arriba son importantes para delimitar y separar las lineas de la solicitud
# por lo que `\r\n` junto signidica un cambio de linea en HTTP
# con esto me aseguro que el servidor entienda bien la peticion
cmd = "GET / HTTP/1.0\r\n\r\n".encode()
mysock.send(cmd)

while True:
    # estoy recibiendo datos del socket `mysock` de hasta 512 bytes
    data = mysock.recv(512)
    # despues de recibir los datos, se verifica la longitud de `data`
    # para determinar si hay mas datos para recibir, por lo que si es cero
    # no hay mas datos para recibir y sale del bucle
    if len(data) < 1:
        break
    # hay que decodificarlo ya que `data` recibe bytes
    # decode() utiliza el conjunto de caracteres predeterminados
    # que suele ser UTF-8
    print(data.decode())

mysock.close()