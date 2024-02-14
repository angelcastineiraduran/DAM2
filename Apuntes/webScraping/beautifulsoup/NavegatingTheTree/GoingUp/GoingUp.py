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
</body>
</html>
"""

from bs4 import BeautifulSoup
soup = BeautifulSoup(html_doc, 'html.parser')

title_tag = soup.title
print(title_tag)
print(title_tag.parent)
print(title_tag.string.parent)

html_tag = soup.html
# el parent de la etiqueta mas grande es el obj BeautifulSoup
print(type(html_tag.parent))
# el padre del obj BeautifulSoup es definidido como None
print(soup.parent)

# podemos iterar con los otros parentes
print("\n -- ITERANDO PADRES --")
link = soup.a
print(link)
# por ultimo deberia imprimir None correspondiente
# al padre del obj BeautifulSoup, sin embargo
# no lo imprime... El error puede deberse a un
# error en la version de la libreria
for parent in link.parents:
    if parent is None:
        print(parent)
    else:
        print(parent.name)