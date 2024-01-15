from reportlab.pdfgen import canvas


def hello(c):
 # importo la unidad "inch" que son pulgadas
 from reportlab.lib.units import inch
 # mueve el pto origen (0,0) hacia arriba a la izq en distancia de una pulgada ("inch")
 c.translate(inch, inch)
 c.setFont('Helvetica', 14)
 # las 2 lineas abajo = color de los bordes
 c.setStrokeColorRGB(0.2, 0.5, 0.3)
 c.setFillColorRGB(1, 0, 1)
 # para dibujar las lineas desde el pto origen
 c.line(0, 0, 0, 1.7*inch)
 c.line(0, 0, 1*inch, 0)
 # dibuja un rectangulo, activo el relleno (fill=1)
 c.rect(0.2*inch, 0.2*inch, 1*inch, 1.5*inch, fill=1)
 # rota lienzo en sentido de las agujas del reloj
 c.rotate(90)
 # se establece un nuevo color despues de la rotacion
 c.setFillColorRGB(0, 0, 0.77)
 # dice hola (despues de que se rota la coord "y" a negativo)
 c.drawString(0.3*inch, -inch, 'Hello World!')


c = canvas.Canvas('../drawingOperations.pdf')
hello(c)
c.showPage()
c.save()