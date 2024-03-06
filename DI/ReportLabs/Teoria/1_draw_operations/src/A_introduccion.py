from reportlab.pdfgen import canvas
def hello(c):
 # utiliza metodo del obj "canvas" pasado por parametro
 c.drawString(100,100,"Hello World")

# objeto de la interfaz que provee operanciones de dibujado
c = canvas.Canvas("../pdfs/hello.pdf")

# dibuja "Hello World" en la primera pagina.
hello(c)

# para indicar que la pagina actual del docu esta completa.
# hace que el obj canvas pare de dibujar en la pagina actual.
# si hay mas operaciones de dibujado, se realizan en la siguiente pagina (en este caso
# no hay mas ya que se llama despues al metodo save()).
# si no hay mas paginas, se crea.
c.showPage()

# debe ser llamado despues de que la construccion del documento es finalizada
# genera el documento pdf
c.save()