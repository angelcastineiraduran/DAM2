from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
def hello(c):
 c.translate(inch, inch * 10)
 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/hello.pdf")

hello(c)
c.showPage()
c.save()