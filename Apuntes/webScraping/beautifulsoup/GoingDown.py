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

# -- .contents --
# los hijos de una etiqueta son conseguibles en una lista
# llamando a .contents()
head_tag = soup.head
print(head_tag) # > <head><title>The Dormouse's story</title></head>
# hijos de la etiqueta head_tag
print(head_tag.contents) # > [<title>The Dormouse's story</title>]
tittle_tag = head_tag.contents[0]
print(tittle_tag) # > <title>The Dormouse's story</title>
print(tittle_tag.contents) # > ["The Dormouse's story"]

# el hijo del obj BeautifulSoup es la etiquete <html>
print(len(soup.contents))
for ele in soup.contents:
    print(ele.name)
print(soup.contents[0].name) # deberia ser solo la etiqueta <html>

# el string NO tiene .contents ya que no contienen nada
text = tittle_tag.contents[0]
print(text) # > The Dormouse's story
#print(text.contents) # error

# -- .children --
for child in tittle_tag.children:
    print(child) # > The Dormouse's story

