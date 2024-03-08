from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
def hello(c):

 #c.setMiterLimit(limit=1.6) # no se lo que hace, no creo que sea muy relevante

 c.translate(inch, inch)
 c.setLineWidth(inch * 0.5)

 # extremo cuadrado (predeterminado)
 c.setLineCap(mode=0)
 # Establecer el límite del ángulo miter a 2.0
 c.setMiterLimit(limit=2.0)
 c.rect(5 * inch, 2 * inch, 1 * inch, 1.5 * inch, fill=1)
 # union en puntiaguda (predeter)
 c.setLineJoin(mode=0)
 c.line(0, 0, 0, 5)

 c.setLineWidth(inch * 0.2)
 # extremo redondo
 c.setLineCap(mode=1)
 c.line(300, 300, 400, 300) # linea horizontal extremos redondeados
 # union en redondeada
 c.setLineJoin(mode=1)
 c.rect(5 * inch, 5 * inch, 1 * inch, 1.5 * inch, fill=1) # cuadrado con extremos redondeados
 c.setLineJoin(mode=0)
 c.rect(5 * inch, 7 * inch, 1 * inch, 1.5 * inch, fill=1) # cuadrado con extremos rectos
 c.setLineJoin(mode=2)
 c.rect(5 * inch, 9 * inch, 1 * inch, 1.5 * inch, fill=1) # cuadrado con extremos recortados

 # extremo en forma de proyectil
 c.setLineCap(mode=2)
 # union en angulo recto
 c.setLineJoin(mode=2)
 c.line(200, 100, 200, 200) # linea vertical

 c.setLineWidth(inch * 0.1)
 # no se que significan los param
 c.setDash(array=[2, 2, 16, 10], phase=0)
 c.line(50, 50, 250, 50)

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/lineStyles.pdf")

hello(c)
c.showPage()
c.save()