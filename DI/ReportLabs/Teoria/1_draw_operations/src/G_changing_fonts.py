from reportlab.pdfgen import canvas
def hello(c):
 # leading = interlineado, pero creo que no me funciona bien
 c.setFont(psfontname='Times-Roman', size=60, leading=None)
 c.drawString(100, 100, "Hello World")
 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/changingFonts.pdf")

hello(c)
c.showPage()
c.save()