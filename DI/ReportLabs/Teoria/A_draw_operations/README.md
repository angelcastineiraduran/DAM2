# Introduccion 

## Canvas

El paquete `pdfgen` es el nivel más bajo
para generar documentos pdf. Un programa
pdfgen en realidad es un conjunto de 
instrucciones para dibujar un documento.

La interfaz que provee de opereaciones de 
dibujo es el objeto `Canvas`.

El `Canvas` hay que verlo como una hoja de 
papel en blanco dd tenemos coordenadas cartesianas
(x, y) y el origen (0, 0) que se encuentra abajo
de todo a la izquierda.

```python
from reportlab.pdfgen import canvas
```

Algunos métodos:

```python
canvas = canvas.Canvas("hello.pdf")
# finaliza la pintura de la página actual.
# todo el dibujo adicional se hará en la siguiente pag.
canvas.showPage()
```

----

## Parametros

`bottomup`
* Cambia el sistema de Coordenadas. Algunos
framework ponen el origen en vez de abajo
a la izq, lo poner arriba a la izquierda.
* Este param esta en desuso, recomendado suprimirlo.

`pageCompression`
* Determina si se 
comprime el flujo de operaciones de PDF 
para cada página.
* por defecto paginas no comprimidas porque
ralentiza
* si lo quiero activar (pq me importa 
el tamaño) igualarlo a 1
* Las imagenes por defecto SIEMPRE estan
comprimidas por lo que esta opcion SOLO
afecta a el txt y el vectores graficos.

`encoding`
* obsoleto, omitirlo
* solo usado cd quiero representar caracteres
de MacRoman y no en Winansi.

`verbosity`
* me manda msj de cuanta informacion de registro 
se imprime.
* por defecto es cero para ayudar a las app
que desean capturar PDF a partir de una
salida estandar.
* Si ponemos valor = 1 entonces cada vez
que se genere un documento me va a imprimir
un msj de confirmacion en pantalla

`encrypt`
* por defecto no activado
* si valor = obj String, ese valor es la 
pswd del documento.
* si valor = obj de `reportlab.lib.pdfencrypt.StandardEncryption`
entonces todo el docu sera encriptado.

## (2.4) The tools: the "draw" operations

### Lineas

```python
canvas.line(x1,y1,x2,y2)
canvas.lines(linelist)
```

### Formas

```python
canvas.grid(xlist, ylist)
canvas.bezier(x1, y1, x2, y2, x3, y3, x4, y4)
canvas.arc(x1,y1,x2,y2)
canvas.rect(x, y, width, height, stroke=1, fill=0)
canvas.ellipse(x1,y1, x2,y2, stroke=1, fill=0)
canvas.wedge(x1,y1, x2,y2, startAng, extent, stroke=1, fill=0)
canvas.circle(x_cen, y_cen, r, stroke=1, fill=0)
canvas.roundRect(x, y, width, height, radius, stroke=1, fill=0)
```

### String :thread:

```python
canvas.drawString(x, y, text):
canvas.drawRightString(x, y, text)
canvas.drawCentredString(x, y, text)
```

### Objetos de txt :book:

Para cambiar formatos de txt que no son 
soportados directamente por la interfaz
de canvas.

```python
# instancia el objeto txt
textobject = canvas.beginText(x, y)
# dibuja el texto del objeto
canvas.drawText(textobject)
```
Para más info ver el repo de `B_colors&fonts&path`

### Objetos de ruta :book: :heavy_plus_sign:

Similar a obj de txt, opciones no soportadas
directamente por la inter de canvas.

**no lo entiendo muy bien**

```python
path = canvas.beginPath()
canvas.drawPath(path, stroke=1, fill=0, fillMode=None)
canvas.clipPath(path, stroke=1, fill=0, fillMode=None) 
```

### Imagen :camera_flash:
Necesaria libreria **Python Imaging Library (PIL)**
para usar imagenes en el paquete ReportLab.

2 metodos:

`drawImage`

* actual
* se define la imagen una vez y luego la podemos dibujar
muchas veces.
* Solo va a ser guardada la primera vez y despues va a ser referenciada.

```python
# mask para hacer transparente la imagen
canvas.drawImage(self, image, x,y, width=None,height=None,mask=None)
```

`drawInLineImage`

* antiguo
* No eficiente cuando repito la misma imagen varias veces.
* Eficiente cuando las imagenes son pequeñas y no se repiten.

```python
canvas.drawInlineImage(self, image, x,y, width=None,height=None)
```

## The toolbox: the "state change" operations

### State Control

```python
# marca el estado de los graficos (fuente, tranformacion, estilos...)
canvas.saveState()
# restuaracion del estado guardado MAS RECIENTE 
# que AUN NO SE HA RESTAURADO
canvas.restoreState()
```
> Estos metodos NO funcionan entre distintas páginas.

## Other canvas methods

```python
# establece el nombre del autor del docu
canvas.setAuthor()
# indices con enlaces
canvas.addOutlineEntry(title, key, level=0, closed=None)
# titulo docu
canvas.setTitle(title)
# si la pag actual tiene contenido devulve true
canvas.pageHasData()
# muestra el indice 
# previamente se tiene que haber utilizado el .addOutlineEntry()
canvas.showOutline()
# marcador/enlace interno
canvas.bookmarkPage(name)
# lo mismo que lo anterior pero horizonal
canvas.bookmarkHorizontalAbsolute(name, yhorizontal)
# los siguientes tienen que ver con formularios...
canvas.doForm()
canvas.beginForm(name, lowerx=0, lowery=0, upperx=None, uppery=None)
canvas.endForm()
# esta en src ejemplo - pero NO me funciona!!
canvas.linkAbsolute(contents, destinationname, Rect=None, addtopage=1, name=None, **kw)
# TAMPOCO me funciona
canvas.linkRect(contents, destinationname, Rect=None, addtopage=1, relative=1, name=None, **kw)
canvas.getPageNumber()
canvas.getAvailableFonts()
canvas.stringWidth(self, text, fontName, fontSize, encoding=None)
# activar (1) o no (0) la compresion
canvas.setPageCompression(onoff=1)
canvas.setPageTransition(self, effectname=None, duration=1,
                    direction=0,dimension='H',motion='I')
```

(mirar documento oficial)


## Coordinates (default user space)

