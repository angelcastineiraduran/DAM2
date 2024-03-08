from reportlab.pdfgen import canvas
from reportlab.lib.units import inch

def hello(c):

 c.translate(inch,inch*10)
 textobject = c.beginText()
 textobject.textLine("Primera linea")

 # inter-character spacing.
 textobject.setCharSpace(2)
 textobject.textLine("inter-character spacing")
 textobject.setCharSpace(0)  # vuelve a la normalidad

 # Word Spacing
 textobject.setWordSpace(20)
 textobject.textLine("this is word spacing")
 textobject.setWordSpace(0)

 # horizontal scaling
 textobject.setHorizScale(500)
 textobject.textLine("horinzonal spacing")
 textobject.setHorizScale(100) # default

 # Interline spacing (Leading)
 textobject.setLeading(50) # las siguientes lineas va a tener interlineado=50 entre ellas
 textobject.textLine("starting interline spacing")
 textobject.setLeading(3)
 textobject.textLine("first interline spacing")
 textobject.setLeading(15) # dejando el interlineado +- como estaba entre las siguiente lineas
 textobject.textLine("end interline spacing")

 # RenderMode - para añadir +stroke
 textobject.setFillColorRGB(0,1,0)
 textobject.setTextRenderMode(0) # Modo 0: Fill (Relleno) - default
 textobject.textLine("Render mode en 0, fill")
 textobject.setTextRenderMode(1) # Modo 1: FillText (Relleno y recorte) - genera mucho Stroke al rededor de la letra
 textobject.textLine("Render mode en 1, Filltext")
 textobject.setTextRenderMode(2) # Modo 2: Stroke (Contorno) - no veo diferencia!?
 textobject.textLine("Render mode en 2, contorno")
 textobject.setTextRenderMode(3) # Modo 3: FillText (Relleno y contorno) - lo convierte a invisible!?
 textobject.textLine("Render mode en 3, fillstroke")
 textobject.setTextRenderMode(0)
 textobject.setFillColorRGB(0,0,0)

 # subindice y superindices
 textobject.textOut("H")
 textobject.setRise(-5)
 textobject.textOut("2")
 textobject.setRise(0)
 textobject.textLine("O")
 textobject.textOut("AreaCuadrado=l")
 textobject.setRise(5)
 textobject.textLine("2")



 c.drawText(textobject)


 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/CB_fonts_txt.pdf")

hello(c)
c.showPage()
c.save()