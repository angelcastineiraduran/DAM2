from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image, PageBreak
from reportlab.lib.styles import getSampleStyleSheet
#from reportlab.rl_config import defaultPageSize # me da error
from reportlab.lib.units import inch
from reportlab.pdfgen import canvas

doc = SimpleDocTemplate("../pdfs/BB_images.pdf")
styles = getSampleStyleSheet()

# story
elements = []
spacer = Spacer(width=1, height=2*inch)

image1 = Image("../media/pull-shark-default.png", width=2*inch, height=2*inch)
elements.append(image1)

# si no se pone width/height se supone que la dimension actual de la imagen estan en "points" (ej. 800*600)
image2 = Image("../media/pull-shark-default.png")
image2.hAlign = "RIGHT"
elements.append(image2)

pageBreak = PageBreak()
elements.append(pageBreak)
elements.append(image1)

doc.build(elements)
