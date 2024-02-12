from bs4 import BeautifulSoup
# corresponde a una etiqueta HTML o XML
# del docu original.
# los Tags tienen muchos atributos y metodos
soup = BeautifulSoup('<b class="boldest">Extremadamente bold</b>', 'html.parser')
tag = soup.b
print(type(tag)) # > <class 'bs4.element.Tag'>

# -- Name --
# nombres de la etiquets
name = tag.name
print(name) # > b
# si cambio el name de una tag se refleja en todo el obj
tag.name = "blockquote"
print(tag) # > <blockquote class="boldest">Extremadamente bold</blockquote>

# -- Attributes --
# puedes acceder a un atributo de una tag como si fuera un diccionario
attribute = tag['class']
print(attribute) # > ['boldest']
# puedes acceder directamente al diccionario
print(tag.attrs) # > {'class': ['boldest']}
# tambien se pueden añadir, modificar y eliminar atributos a la tag
# añado atributo
tag['otro-atributo'] = 2
print(tag)
# elimino atributo
del tag['otro-atributo']
print(tag)

# -- Muti-valued attributes --
# html tienen unos cuantos atributos que pueden
# tener multiples valores
# el mas comun atributo multivalor es `class`
# esto restulta que una etiqueta puede tener
# mas de una clase CSS
css_soup = BeautifulSoup('<p class="body"></p>', 'html.parser')
attribute = css_soup.p['class']
print(attribute) # > ["body"]
css_soup = BeautifulSoup('<p class="body strikeout"></p>',  'html.parser')
attribute2 = css_soup.p['class']
print(attribute2) # > ["body", "strikeout"]

# si un atributo parece como multivalor pero no lo es
# Beautiful Soup lo dejara en paz
id_soup = BeautifulSoup('<p id="my id"></p>', 'html.parser' )
attribute3 = id_soup.p['id']
print(attribute3) # > my id

# pasando multiples valores a un atributo
rel_soup = BeautifulSoup('<p>Back to the <a rel="index">homepage</a></p>', 'html.parser' )
rel_soup.a['rel'] = ['index', 'contents']
print(rel_soup)

# puedes deshabilitar que se puedan pasar multiples val
# a un atributo de esta forma:
rel_soup = BeautifulSoup('<p>Back to the <a rel="index">homepage</a></p>', 'html.parser', multi_valued_attributes=None)

# conseguir los valores de los atributos en una lista siempre
list_attributes = id_soup.p.get_attribute_list('id')
print(list_attributes) # > ['my id']