from reportlab.pdfgen import canvas
from reportlab.pdfgen.canvas import Canvas
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import Paragraph, Frame, Table

c = canvas.Canvas("../pdfs/B_params.pdf")
styles = getSampleStyleSheet()
c.translate(inch, inch * 10)

aW = 460
aH = 800

data = [
    ["F1", "C1", "C2", "C3"],
    ["F2", 4, 23, 13],
    ["F3", 3, 0, 2],
]

table = Table(data=data, spaceBefore=0*inch, spaceAfter=3*inch)

w,h = table.wrap(aW, aH)

c.drawString(0, 0, "Hola Mundo 1")
table.drawOn(c, 0, 0)
c.drawString(0, -inch, "Hola Mundo 2")

print("Documento creado correctamente")

c.showPage()
c.save()