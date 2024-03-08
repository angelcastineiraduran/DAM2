from reportlab.pdfgen import canvas
from reportlab.lib.units import inch, cm

# no me da funcionado
def hello(c):
 c.scale(inch, inch)

 # Definir una región de enlace específica
 link_rect = (0, 0, inch, inch)

 # React = region rectangular dd se aplica el enlace (x0, y0, x1, y1), None = todo el area
 # addtopage = indica si el enlace debe agregarse a la pag actual
 # name = nombre opcional del enlace
 #c.linkAbsolute(contents="esto es un enlace", destinationname="Meaning_of_life", Rect=inch, addtopage=1, name=None)

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/otherMethods.pdf")

hello(c)
c.showPage()
c.save()