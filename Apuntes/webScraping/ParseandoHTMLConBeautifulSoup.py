import urllib.request
from bs4 import BeautifulSoup

html = urllib.request.urlopen('https://openwebinars.net')
soup = BeautifulSoup(html, 'html.parser')

# -- Extraer info separada de las etiquetas con href --
# todos los hipervinculos vienen en una etiqueta llamada <a>
# esto se llama parseas un html
tags = soup("a")
for tag in tags:
    print("TAG:", tag)
    # printeo, de esas etiquetas extraidas, SOLO el contenido de href
    print("URL:", tag.get('href'))
    # printeo contenido de la etiquetas
    print("CONTENIDO:", tag.contents)
    # printeo atributos si tiene
    print("ATRIBUTO:", tag.attrs)
    print("\n")
