from reportlab.pdfgen.canvas import Canvas
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import Paragraph, Frame

styles = getSampleStyleSheet()
styleN = styles['Normal']
styleH = styles['Heading1']
story = []

# add some flowables
story.append(Paragraph("This is a Heading", styleH))
story.append(Paragraph("This is a paragraph in <i>Normal</i> style.", styleN))

c = Canvas('../pdfs/C_frames.pdf')

f = Frame(inch, inch, 6*inch, 9*inch, showBoundary=1)
# Como vemos, no hace falta utlizar el `flowable.wrap(aW, aH)` y
# posteriormente el `flowable.drawOn(c,aW,aH)`, ya que el metodo `addFromList`
# los llama por ti.
f.addFromList(story, c)

c.save()
