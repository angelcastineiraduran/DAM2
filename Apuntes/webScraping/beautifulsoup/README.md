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

1. `NavegatingTheTree`
2. GoingDown 
3. GoingUp
4. GoingSideWays

## Searching the tree
