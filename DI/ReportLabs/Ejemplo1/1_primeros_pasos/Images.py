import reportlab
from reportlab.pdfgen import canvas
# importamos libreria para poder utilizar los metodos que añaden la imagen
from PIL import Image

# -- NO ME FUNCIONA NO SE PORQUE!!! --
def hello(c):
 from reportlab.lib.units import inch
 c.translate(inch, inch)
 c.setFont('Helvetica', 14)
 c.setStrokeColorRGB(0.2, 0.5, 0.3)
 c.setFillColorRGB(1, 0, 1)
 c.line(0, 0, 0, 1.7*inch)
 c.line(0, 0, 1*inch, 0)
 c.rect(0.2*inch, 0.2*inch, 1*inch, 1.5*inch, fill=1)
 c.rotate(90)
 c.setFillColorRGB(0, 0, 0.77)
 c.drawString(0.3*inch, -inch, 'Hello World!')
 ruta_imagen = '../imagenes/baby.png'
 img = Image.open(ruta_imagen)
 # Convertir la imagen PIL a formato RGBA
 img_rgba = img.convert("RGBA")
 img_reader = reportlab.lib.utils.ImageReader(img_rgba)

 c.drawImage(img_reader, 1*inch, 1*inch, width=1*inch, height=0.5*inch)

c = canvas.Canvas('../pdfs/myFirstImage.pdf')
hello(c)
c.showPage()
c.save()