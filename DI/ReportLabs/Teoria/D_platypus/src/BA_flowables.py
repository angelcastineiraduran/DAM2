from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image
from reportlab.lib.styles import getSampleStyleSheet
#from reportlab.rl_config import defaultPageSize # me da error
from reportlab.lib.units import inch
from reportlab.pdfgen import canvas

# El objetivo es mantener el parrafo junto y si hay suficiente espacio se
# dibuja en la pagina actual y si no lo hay se genera una excecpcion.

doc = SimpleDocTemplate("../pdfs/BA_flowables.pdf")
styles = getSampleStyleSheet()
style = styles['BodyText']

# story
elements = []

P = Paragraph("Esto es un pequeño ejemplo", style)
elements.append(P)

spacer = Spacer(width=1, height=2*inch)

elements.append(spacer)

multiple_text = '''
Esto va a ser
un buen parrafo
con varias lineas de texto
'''

P2 = Paragraph(text=multiple_text*20, style=styles["Normal"])
# Esto no va a tener NINGUN EFECTO ya que el parrafo ocupa todo el
# espacio disponible
P2.hAlign = "RIGHT"
elements.append(P2)

image = Image("../media/pull-shark-default.png")
# Esto SI que va a tener EFECTO ya que la imagen no ocupa todo
# el espacio disponible
image.hAlign = "RIGHT"
elements.append(image)

doc.build(elements)
