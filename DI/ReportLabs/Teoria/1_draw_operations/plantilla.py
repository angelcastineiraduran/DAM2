from reportlab.pdfgen import canvas
def hello(c):

 # ...

 print("Documento creado correctamente")

c = canvas.Canvas("../pdfs/hello.pdf")

hello(c)
c.showPage()
c.save()