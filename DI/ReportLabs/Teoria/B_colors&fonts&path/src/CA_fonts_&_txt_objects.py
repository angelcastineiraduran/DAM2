from reportlab.pdfgen import canvas
from reportlab.lib.units import inch

def hello(c):

 c.translate(inch,inch*5)

 # (tipografia, tamanio letra)
 c.setFont('Courier', 14)
 c.drawString(0, 0, 'Courier')

 c.setFont('Helvetica', 30)
 c.drawString(0, inch, 'Heveltica')

 # para la presentacion espeficica de texto, usar: txt objects
 # +control, +smallpdf, +fasterrender (mejor que muchos metodos drawStrings)
 c.translate(inch*3, 0)
 textobject = c.beginText()
 textobject.setTextOrigin(0, inch*2)
 textobject.setFont('Times-Roman', 12) # (psfontname='Times-Roman', size=12, leading=None)
 # añade un txt y de seguido agrega un salto de linea
 textobject.textLine("Primera linea")
 textobject.setFillColorRGB(1,0,0)
 # se van imprimiendo hacia abajo
 textobject.textLine("Segunda linea")
 # el cursor se mueve a la misma linea donde esta
 textobject.moveCursor(0, 0)
 textobject.textLine("Tercera linea")
 # el cursor se mueve hacia abajo en 1*inch desde donde esta
 textobject.moveCursor(0, inch)
 textobject.textLine("Cuarta linea")
 textobject.textLine("Quinta linea")
 (x, y) = textobject.getCursor()
 print("x:", x, ", ", "y:", y) # > x: 0 ,  y: 143.99999999999997
 x = textobject.getX()
 y = textobject.getY()
 # añade texto y NO agreaga un salto de linea/enter
 textobject.textOut("Sexta linea")
 textobject.textLine("Septima linea")
 multiline_text = """
     Línea 1
         Línea 2
     Línea 3
     """
 # NO agrega las lineas de txt aunque esten puestas con salto de linea en la var
 textobject.textLine(multiline_text)
 # SI agrega varias linea de txt
 textobject.textLines(multiline_text) # trim=1 por defecto. elimina espacios en blanco entre lineas
 textobject.textLines(multiline_text, trim=0) # trim=0 NO elimina espacios en blanco

 c.drawText(textobject)


 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/CA_fonts_txt.pdf")

hello(c)
c.showPage()
c.save()