from reportlab.lib.units import inch
from reportlab.pdfgen import canvas

c = canvas.Canvas("../pdfs/A_introduccion.pdf")

c.bookmarkPage("pagina2")
c.drawString(100, 500, "Introduction Page")

c.linkAbsolute("Go to pagina2", "pagina2", (100, 400, 200, 450), Border='[0 0 0]')


c.showPage()

c.bookmarkPage("pagina2")
c.drawString(100, 500, "Content on pagina2")

print("Documento creado correctamente")

c.save()