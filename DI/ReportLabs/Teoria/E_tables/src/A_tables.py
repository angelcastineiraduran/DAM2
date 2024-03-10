from reportlab.pdfgen import canvas
from reportlab.pdfgen.canvas import Canvas
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import Paragraph, Frame, Table

c = canvas.Canvas("../pdfs/A_tables.pdf")
styles = getSampleStyleSheet()
c.translate(inch, inch * 10)

aW = 460
aH = 800

data0 = [["Tabla con 1 columna y una fila"]]

data = [
    ["F1", "C1", "C2", "C3"],
    ["F2", 4, 23, 13],
    ["F3", 3, 0, 2],
]

txtP = ("Esto es el parrafo 1") * 3
p = Paragraph(text=txtP, style=styles["Normal"])
dataP = [[p], [p], [p]]

txtP2 = ("Esto es el parrafo 2") * 3
txtP3 = ("Esto es el parrafo 3") * 3
p2 = Paragraph(text=txtP2, style=styles["Normal"])
p3 = Paragraph(text=txtP3, style=styles["Normal"])
dataP2 = [
    [p, p2, p3],
    [p, p2, p3],
    [p, p2, p3]
]

Story = []
Story.append(p)
Story.append(p2)
Story.append(p3)
# una solo celda
dataS = [[Story]]
# 3 filas
dataS2 = [
    [Story],
    [Story],
    [Story]
]
dataS3 = [
    [Story, Story, Story],
    [Story, Story, Story],
    [Story, Story, Story]
]

#table = Table(data=data0)
#table = Table(data=dataP)
#table = Table(data=dataP2)
#table = Table(data=dataS)
#table = Table(data=dataS2)
table = Table(data=dataS3)

w,h = table.wrap(aW, aH)
table.drawOn(c, 0, 0)

print("Documento creado correctamente")

c.showPage()
c.save()