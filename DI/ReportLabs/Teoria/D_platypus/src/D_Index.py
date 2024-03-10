from reportlab.pdfgen.canvas import Canvas
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import Paragraph, Frame, CondPageBreak, SimpleDocTemplate
from reportlab.platypus.tableofcontents import SimpleIndex

# ¡¡¡ El siguiente codigo funciona pero los indices simpre son los mismos: 1

doc = SimpleDocTemplate("../pdfs/D_index.pdf")
# Your existing story
story = []

# 1. Utilizo la etiqueta <index> en los parrafos para indexar terminos especificos.
# los terminos que se encuentran dentro de esta etiqueta se agregan al indice
story.append(Paragraph('The third <index item="word"/> word of this paragraph is indexed.', style=getSampleStyleSheet()["Normal"]))
story.append(Paragraph('<index item="terma, termb, termc" />', style=getSampleStyleSheet()["Normal"]))
# en el indice se colocan parrafos por orden alfb y no en el orden en que se añadieron al story
# de forma que este aparece al principio de todo:
#story.append('<index item="aaa"/>') # ERROR pq no es un parrafo
story.append(Paragraph('<index item="aaa"/>', style=getSampleStyleSheet()["Normal"]))

# 2. Creo instancia SimpleIndex
# aparezca el indice.
# dot = caracter de separacion
# headers = encabezados
index = SimpleIndex(dot=' . ', headers=['Index'])

# 3. Agrego el index a la story dd me interesa que aparezca
story.append(index)

# Construyo el doc especificando el canvasMaker
doc.build(story, canvasmaker=index.getCanvasMaker())
