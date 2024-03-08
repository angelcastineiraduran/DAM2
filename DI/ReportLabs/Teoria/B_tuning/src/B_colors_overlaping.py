from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
from reportlab.lib import colors

def hello(c):
 c.translate(inch,inch)

 c.setFillColorRGB(1,0,0)
 c.rect(0, 0, inch, inch, fill=1)

 c.setFillColor(colors.white)
 c.drawString(0, 0, 'Hola mundo')

 c.setFillColorRGB(0,0,1)
 c.setFillAlpha(0.5)
 c.rect(0.5*inch, 0.5*inch, inch, inch, fill=1)

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/colors_overlaping.pdf")

hello(c)
c.showPage()
c.save()