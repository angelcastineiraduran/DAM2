from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
def hello(c):
 c.translate(inch, inch)
 # (posicion X, posicion Y, tamanio X, tamanio Y)
 c.rect(0, 0, inch, inch, fill=1)

 # como si rotates el lienzo 10 grandos (sentido antihorario) y lo solapases con el lienzo normal.
 # por esto mismo el rectangulo aparece movido y desplazado hacia la izq.
 #c.rotate(theta=10)
 c.rect(0, 2*inch, inch, inch, fill=1)

 # todas las operaciones de dibujo se haran 3 veces mayor en ambas direcciones = *3
 #c.scale(2, 2)
 c.rect(0, 4*inch, inch, inch, fill=1)


 #c.transform(1.4, 0, 0, 1.3, 0, 0)
 #c.rect(2*inch, 0, inch, inch, fill=1)

 # Aplicar sesgo a los ejes "x" de 30 grados y en "y" de 15 grados
 c.skew(30, 15)
 c.rect(0, 6 * inch, inch, inch, fill=1)

 # Establecer el tamaño de la página a 8.5 x 11 pulgadas (612x792 puntos)
 #c.setPageSize((612, 792))

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/changingGeometry.pdf")

hello(c)
c.showPage()
c.save()