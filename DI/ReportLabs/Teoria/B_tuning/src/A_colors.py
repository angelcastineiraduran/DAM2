from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
from reportlab.lib import colors

# 2 tipos de colores usados en pdf: RGB, CMYK
# pero hay 3 tipos de representar colores RGB y 1 de representar CMYK (creo)
def hello(c):
 c.translate(inch,inch)
 c.saveState()

 # -- 1. RGB (additive) --
 # +comun
 # (1, 1, 1) = blanco
 # 3 posibles formas de espeficificar colores RGB:

 # A. Por nombre, usando el modulo `colors` (red/blue/green), usando RGB
 c.setFillColorRGB(0, 1, 0) # verde

 # B. Por valor
 c.setFillColor(colors.red)

 # C. Por gray level
 c.setFillGray(0.5) # gris al 50%

 c.drawString(0, 0, 'RGB')
 c.rect(0, inch, inch, inch, fill=1)

 # ----------------------------------

 c.restoreState() # para que no me afecten los colores de arriba
 c.translate(inch*2, 0)
 # -- 2. CMYK (cyan, magenta, yellow, drak) --
 # usado en pintado/dibujo profesional
 # +control
 # setStroke pinta bordes
 c.setStrokeColorCMYK(0,1,0,0) # magenta
 c.drawString(0, 0, 'CMYK')
 c.rect(0, inch, inch, inch, fill=1)

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/colors.pdf")

hello(c)
c.showPage()
c.save()