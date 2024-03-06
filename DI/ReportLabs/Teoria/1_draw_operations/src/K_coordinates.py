from reportlab.pdfgen import canvas
from reportlab.lib.units import inch, cm

def translate(canvas):
    canvas.translate(4.7*cm, 5.3*cm)

def scale(canvas):
 # valores por defecto (1, 1)
 canvas.scale(0.75, 0.5)

def hello(c):
 c.translate(inch, inch)
 c.setFont('Helvetica', 14)
 c.setStrokeColorRGB(0.2, 0.5, 0.3)
 c.setFillColorRGB(1, 0, 1)
 c.line(0, 0, 0, 1.7*inch)
 c.line(0, 0, 1*inch, 0)
 c.rect(0.2*inch, 0.2*inch, 1*inch, 1.5*inch, fill=1)

 #c.saveState()
 # llamamos a translate() despues de dibujar el rectangulo y antes de rotar el lienzo
 translate(c)

 # llamamos al metodo scale()
 scale(c)
 #c.restoreState()

 # todito lo que se dibuje despues de "translate()" sera relativo a ese nuevo punto de origen
 c.rotate(90)
 c.setFillColorRGB(0, 0, 0.77)
 c.drawString(0.3*inch, -inch, 'Hello World!')


c = canvas.Canvas('../pdfs/myFirstCoodinates.pdf')
hello(c)
c.showPage()
c.save()