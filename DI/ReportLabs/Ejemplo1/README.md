# Introduccion

Las coordenadas (0, 0) se identifican
abajo de todo a la izquierda en el documento.

## Parametros

`bottomup`
* Cambia el sistema de Coordenadas. Algunos
framework ponen el origen en vez de abajo
a la izq, lo poner arriba a la izquierda.
* Este paramtro esta en desuso, suele ser re
comendado suprimirlo.

`pageCompression`
* La opción pageCompression determina si se 
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
* determina cuanta informacion de registro 
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

## The tools: the "draw" operations

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

### Strings

```python
canvas.drawString(x, y, text):
canvas.drawRightString(x, y, text)
canvas.drawCentredString(x, y, text)
```

### Objetos de txt

Para cambiar formatos de txt que no son 
soportados directamente por la interfaz
de canvas.

```python
textobject = canvas.beginText(x, y)
canvas.drawText(textobject)
```

### Objetos de ruta

Similar a obj de txt, opciones no soportadas
directamente por la inter de canvas.

**no lo entiendo muy bien**

```python
path = canvas.beginPath()
canvas.drawPath(path, stroke=1, fill=0, fillMode=None)
canvas.clipPath(path, stroke=1, fill=0, fillMode=None) 
```

### Imagen