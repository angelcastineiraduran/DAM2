import re



html_doc = """
<html><head><title>The Dormouse's story</title></head>
<body>
<p class="title"><b>The Dormouse's story</b></p>

<p class="story">Once upon a time there were three little sisters; and their names were
<a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
<a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
<a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
and they lived at the bottom of a well.</p>

<p class="story">...</p>

"""

from bs4 import BeautifulSoup
soup = BeautifulSoup(html_doc, 'html.parser')

print("\n -- Strings --")
b_tags = soup.find_all("b")
print(b_tags)

print("\n -- Regular expressions --")
# busca todas las etiquetas cuyo nombre empiece por "b" (caseSensitive)
# `^` inicio de la linea
# `re.compile()` toma una expresion regular y la compila
# para buscar coincidencias eficazmente en el txt, en este caso
# `re.compile("^b")` crea un obj de expresion regular y que busca tagas
# cuyo nombre empieza por "b".
for tag in soup.find_all(re.compile("^b")):
    # imprime nombre de la etiqueta que cumpla dicho criterio
    print(tag.name)

# encuentra todas las etiquetas que contienen el nombre t
for tag in soup.find_all(re.compile("t")):
    print(tag.name)

print("\n -- A list --")

# todas las etiquetas que contengan una "a" y/o una "b"
list = soup.find_all(["a", "b"])
for tag in list:
    print(tag)

# con el True consigue todas las etiquetas que pueda
for tag in soup.find_all(True):
    print(tag.name)


print("\n -- A Function --")
# la funcion debe retornar True si encuentra algo y False
# si no encuentra nada
# NO ENTIENDO MUY BIEN EL METODO:
# 1. find_all() busca todas las etiquetas que cumplen ciertos criterios
# 2. la funcion has_class_but_no_id se pasa como arg a find_all() sin ser ejecutada explicitamente.
# 3. Esto se debe a que find_all() se encarga de llamar a la funcion con cada tag del documento, por
# lo que find_all() toma cada tag y lo pasa como arg a has_class_but_no_id() y verifica si cumple la condicion.
def has_class_but_no_id(tag):
    return tag.has_attr('class') and not tag.has_attr('id')
filtered_tags = soup.find_all(has_class_but_no_id)
for tag in filtered_tags:
    print(tag)
# Por lo que NO se imprimiran etiquetas como la de <html> y/o <title>

def not_lacie(href):
    # devuelve True si href no es nulo (es decir, si existe) y False en caso contrario
    return href and not re.compile("lacie").search(href)
# href atributo de una etiqueta que se pasa como arg
print(soup.find_all(href=not_lacie))



