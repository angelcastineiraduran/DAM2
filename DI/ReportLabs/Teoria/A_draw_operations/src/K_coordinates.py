from reportlab.pdfgen import canvas
from reportlab.lib.units import inch, cm

# Pto origin por defecto, el (0, 0), posicionado en la esquina abajo-izquierda de la hoja.
def translate(canvas):
 # translada pto de origen por defecto a nuevo pto de origen determinado por (x,y)
 canvas.translate(4.7*cm, 5.3*cm)

def scale(canvas):
 # estrecha o amplia la dimension x e/o y.
 # canvas.scale(dx,dy)
 # valores por defecto (1, 1)
 canvas.scale(0.5, 1)

def hello(c):
 c.translate(inch, inch)
 c.setFont('Helvetica', 14)
 c.setStrokeColorRGB(0.2, 0.5, 0.3)
 c.setFillColorRGB(1, 0, 1)
 c.line(0, 0, 0, 1.7*inch)
 c.line(0, 0, 1*inch, 0)
 c.rect(0.2*inch, 0.2*inch, 1*inch, 1.5*inch, fill=1)

 # usamos saveState() para guardar el estado actual
 c.saveState()
 # llamamos a translate() despues de dibujar el rectangulo y antes de rotar el lienzo
 translate(c)

 scale(c)
 #c.restoreState()

 # todito lo que se dibuje despues de "translate()" sera relativo a ese nuevo punto de origen
 # por lo tanto, lo unico que va a estar afectado por el metodo scale() y translate() es el txt
 c.rotate(90)
 c.setFillColorRGB(0, 0, 0.77)
 c.drawString(0.3*inch, -inch, 'Hello World!')

 # lo usamos para restaurar el estado anteriormente guardado.
 # si no va precedido de un saveState() no funciona y da ERROR!
 # RECORDAR: ningun save/restore funciona funciona a traves de distintas paginas, solo en la actual = ERROR!
 c.restoreState()
 c.drawString(inch, 2 * inch, "hola mundo")


c = canvas.Canvas('../pdfs/myFirstCoodinates.pdf')
hello(c)
c.showPage()
c.save()