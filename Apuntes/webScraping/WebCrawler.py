# -- EJEMPLO SENCILLO DE WEB CRAWLER CON 2 NIVELES DE PROFUNDIDAD --
# 1. entramos en una pag
# 2. extraer sus enlaces
# 3. acceder a todos sus enlaces
# 4. volvemos a imprimir todos los enlaces de esas webs

import urllib.request
from bs4 import BeautifulSoup

url = 'https://math.mit.edu/~gs/'
# peticion con urllib al servidor para que
# me devuelva el contenido html de esa url
html = urllib.request.urlopen(url)
# el html lo transformo a un obj BeautifulSoup
soup = BeautifulSoup(html)

tags = soup('a')

print('Enlaces en la pagina principal: \r\n')
for tag in tags:
    # imprimo txt del enlace y el enlace en si
    print(tag.contents[0], tag.get('href'))

print('Enlaces de las paginas secunadarias: \r\n')
for tag in tags:
    newurl = tag.get('href')
    print('* Accediendo a los enlaces dentro de la pagina:', newurl)
    # creo bloque try/catch debido a que dentro de alguna de las url
    # no haya mas enlaces, por lo que al no encontrarlo puede que me salte
    # un error. tambien puede que no todas las url empiecen por http
    # por ejemplo: "./videos/index.html" (url relativa ya que se consigue juntandola
    # con otra). Esto podria tambien saltar un error
    try:
        if newurl[0:4] == 'http': html2 = urllib.request.urlopen(newurl)
        # si es url relativa, la tengo que concatenar con la principal
        else: html2 = urllib.request.urlopen(url+newurl)
        soup2 = BeautifulSoup(html2)
        newtags = soup2('a')
        # solo quiero que me imprima en caso de que
        # haya al menos UNA etiqueta "a" en esa newurl
        if len(newtags) > 0:
            # si los hay, quiero que me digas cuantos hay y cuales
            print(len(newtags), 'enlaces:')
            for newtag in newtags:
                print(newtag.get('href'))
        # en el caso de que no encuentre mas enlaces en esa url
        else: print('No hay mas enlaces')
    except:
        print('Algo ha fallado')

