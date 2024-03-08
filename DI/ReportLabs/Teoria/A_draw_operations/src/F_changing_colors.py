from reportlab.pdfgen import canvas
from reportlab.lib.units import inch, cm
from reportlab.lib import colors

# Existen 3 tipos de modelos para representar los colores:
# gray level, additive y substractive
# Existen 2 param de color
# strike(borde) y fill

# 0 = ausencia de color
# 1 = intensidad max

def hello(c):
    # 1. Gray Level - NO LO USO
    #c.setFillGray(...)

    # 2. Additive (red/green/blue or RGB)
    c.setFillColorRGB(r=0, g=0, b=1)

    # 3. Subscanvas.setFillColorRGB(r, g, b) tractive with darkness parameter (cyan/magenta/yellow/darkness or CMYK)
    #c.setFillColorCMYK(c=0, m=1, y=0, k=0)
    c.setStrokeColorCMYK(0,1,0,0)

    # ReportLab tambien proporciona colores ya nombrados como `lawngreen`
    #c.setFillColor(colors.red)

    # para aplicar el color lo tengo que hacer ANTES de que se cree el obj
    c.rect(0.2 * inch, 0.2 * inch, 1 * inch, 1.5 * inch, fill=1)

    print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/changingColors.pdf")

hello(c)
c.showPage()
c.save()