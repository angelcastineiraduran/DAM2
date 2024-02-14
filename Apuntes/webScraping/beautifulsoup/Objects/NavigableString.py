from bs4 import BeautifulSoup
# Beautiful Soup utiliza la clase `NavigableString`
# para almecenar el contenido del interior de las etiquetas.
soup = BeautifulSoup('<b class="boldest">Extremely bold</b>', 'html.parser')
tag = soup.b
string = soup.string
print(type(string)) # > <class 'bs4.element.NavigableString'>
print(string) # > Extremely bold
# convirtiendo NavigableString en Unicode string
#unicode_string = unicode(tag.string) # error?¿
# reemplazando string
tag.string.replace_with("No longer bold")
print(tag.string)

# strings no soportan atributos `.contents` ni `.string`
# ni tampoco el metodo `find()`

# **importante**
# si quieres usar una `NavigableString`
# fuera del Beautiful Soup, deberias convertirla
# a unicode para canviarla al formato normal de
# Python Unicode String
# si no hacemos esto, la string tendra de ref
# a todo el arbol de Beautiful soup
# incluso cd hayamos acabado de utilizarlo y esto
# supone un GRAN gasto de memoria
