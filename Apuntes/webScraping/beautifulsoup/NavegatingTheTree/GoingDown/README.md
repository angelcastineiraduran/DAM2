# Carpeta: GoingDown

## Acceder a etiquetas
Las etiquetas pueden contener string y otras etiquetas. Las etiquetas
que estas dentro de otras etiquetas, son las etiquetas hijas de la anterior.

Beautiful Soup proporciona muchos atributos para acceder y navegar a esas etiquetas hijas.
> Recordar que las string no pueden contener esos atributos ya que estas NO pueden contener hijas.

---

### Formas de acceder a etiquetas - `GoingDown`

A) F1
* Usando el nombre de las etiquetas como atributo del objeto `soup` de tipo `BeautifulSoup`.
* **Forma mas sencilla**
* Ejemplos: `soup.head`, `soup.tittle`, `soup.head.b` (puedes hacer tanto "zoom" como quieras)...
* De esta forma solo te devuelve la primera etiqueta encontrada
* si queremos encontrar todas con ese nombre: `soup.find_all('a')`

B) F2
* Utilizando el `.contents` para que me devuelva una lista de las etiquetas hijas
* Ejemplos: `GoingDown`

C) F3
* En vez de obtnerlos en una lista, puedes iterar en una etiqueta hija usando un generador `.children`

D) F4
* Al contratrio de `.contents` y/o `.children` los cuales obtienen sus hijos directos, 
el atributo `.descendants` puede iterar entre todos los hijos de una tag.

### Caracteristicas

* Si una etiqueta SOLO tiene un hijo y ese hijo es una `NavigableString`, ese hijo puede ser
accesible con un `.string`:

```python
head_tag.contents # [<title>The Dormouse's story</title>]
tittle_tag.string # The Dormouse's story
```

* Si una etiqueta tiene como unico hijo otra etiqueta y esa unica etiqueta tienen como unico hijo
una `.string`, entonces la etiqueta padre es considerada de que tienen **la misma `.string`**.

```python
head_tag.contents # [<title>The Dormouse's story</title>]
tittle_tag.string # The Dormouse's story
head_tag.string # The Dormouse's story
```

> Sin embargo, la etiqueta padre tiene mas de una cosa, no esta claro a que `.string` referencia,
> por lo que es si intentamos acceder al `.string` de esa etiqueta, nos dará `None`.

## `.strings` y `.stripped_strings`
Si hay mas cosas dentro de una etiqueta `Strings`