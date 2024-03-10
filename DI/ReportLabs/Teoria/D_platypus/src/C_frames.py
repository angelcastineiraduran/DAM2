from reportlab.pdfgen.canvas import Canvas
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import Paragraph, Frame, CondPageBreak

styles = getSampleStyleSheet()
styleN = styles['Normal']
styleH = styles['Heading1']
story = []

# add some flowables
story.append(Paragraph("This is a Heading", styleH))
story.append(Paragraph("This is a paragraph in <i>Normal</i> style.", styleN))

# -- CondPageBreak() --
# !! no entiendo muy bien como funciona??
# adding a conditional frame break
# intenta forzar un quibre de Frame si el espacio vertical
# restante en el Frame actual es menor a la altura especificada.
# por lo tanto, se intentara forzar el quiebre del marco si hay menos de 2 pulgadas
# de espacio vertical disponible en el marco actual
cond_page_break = CondPageBreak(2*inch) # adjust de height as needed
#cond_page_break = CondPageBreak(15*inch) # lo exagero para que se produzca ese break en el Frame
story.append(cond_page_break)

c = Canvas('../pdfs/C_frames.pdf')

story.append(Paragraph("This is another paragraph after the conditional frame break.", styleN))

f = Frame(inch, inch, 6*inch, 9*inch, showBoundary=1)
# Como vemos, no hace falta utlizar el `flowable.wrap(aW, aH)` y
# posteriormente el `flowable.drawOn(c,aW,aH)`, ya que el metodo `addFromList`
# los llama por ti.
f.addFromList(story, c)

c.save()
