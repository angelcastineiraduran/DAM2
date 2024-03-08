from reportlab.pdfgen import canvas
from reportlab.lib.units import inch

# PATH OBJECTS
# para figuras graficas
# son dibujados como una figura (como el rectangulo)
# en figuras mas complejas como intentar dibujar un lapiz, se combinan diferenter pathobjects
# hay muchos metodos para los path objects, para moder toda la figura de una: moveTo(), curveTo(), close()...
def hello(c):
 pathobject = c.beginPath()
 # Definir las coordenadas de los puntos para dibujar una estrella
 x, y = 100, 400
 pathobject.moveTo(x, y)
 pathobject.lineTo(x + 50, y)
 pathobject.lineTo(x + 60, y + 40)
 pathobject.lineTo(x + 70, y)
 pathobject.lineTo(x + 120, y)
 pathobject.lineTo(x + 80, y + 20)
 pathobject.lineTo(x + 100, y - 20)
 pathobject.lineTo(x + 60, y - 40)
 pathobject.lineTo(x + 20, y - 20)
 pathobject.lineTo(x + 40, y + 20)
 pathobject.lineTo(x, y)

 # Configurar el modo de dibujo para la figura completa
 c.setStrokeColorRGB(0,0,1)
 c.setFillColorRGB(1,0,0)

 # - Modificacion de vertices
 #c.setLineJoin(0)  # vertices puntuados (pointed)
 c.setLineJoin(1)  # vertices redondeados (rounded)
 #c.setLineJoin(2) # vertices cuadrados (square)
 c.setLineWidth(6) # si no le meto mas ancho a las lineas, no se nota el setLineJoin

 # - Modificacion de guiones
 c.setDash(6,3)

 # Dibujar la figura (la estrella) en el lienzo
 c.drawPath(aPath=pathobject, stroke=1, fill=1)

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/D_path_&_lines.pdf")

hello(c)
c.showPage()
c.save()