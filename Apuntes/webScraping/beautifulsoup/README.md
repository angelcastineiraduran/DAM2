# Beautiful Soup
[Ver docu oficial](https://beautiful-soup-4.readthedocs.io/en/latest/#)

## Tipos de objetos
Transforma un documento HTML en 3 complejos
objetos Python, pero nosotros solo tendremos
que tratar con 4 tipos de objetos:

* `Tag`
* `NavigableString`
* `BeautifulSoup`
* `Comment`

### `BeautifulSoup`
BeautifulSoup representa el documento
analizado como un todo.
* Se podria tratar como un objeto tipo Tag
esto significa que soporta muchos de los metodos
del `NavegatingTheTree` y `SearchingTheTree`.
* Como se puede tratar como un tipo `Tag` 
, un obj BS se puede meter dentro de otro obj BS,
siendo el primero una `Tag` del segundo.
* Al contrario que las tags, los obj BS **no tienen
ni names ni attributes**. Aunque sea absurdo
````python
doc = BeautifulSoup("<document><content/>INSERT FOOTER HERE</document", "xml")
soup.name
# u'[document]'
````

## Navegating the tree

### `NavegatingTheTree`

### Acceder a etiquetas
Las etiquetas pueden contener string y otras etiquetas. Las etiquetas
que estas dentro de otras etiquetas, son las etiquetas hijas de la anterior.

Beautiful Soup proporciona muchos atributos para acceder y navegar a esas etiquetas hijas.
> Recordar que las string no pueden contener esos atributos ya que estas NO pueden contener hijas.

#### Formas de acceder a etiquetas

A) F1
* Usando el nombre de las etiquetas como atributo del objeto `soup` de tipo `BeautifulSoup`.
* **Forma mas sencilla**
* Ejemplos: `soup.head`, `soup.tittle`, `soup.head.b` (puedes hacer tanto "zoom" como quieras)...
* De esta forma solo te devuelve la primera etiqueta encontrada
* si queremos encontrar todas con ese nombre: `soup.find_all('a')`

B) F2
* Utilizando el `.contens` para que me devuelva una lista de las etiquetas hijas
* Ejemplos: `GoingDown`

C) F3
* En vez de obtnerlos en una lista, puedes iterar en una etiqeuta hija usando un generador `.children`

D) F4
* Me quede en los descendants...

