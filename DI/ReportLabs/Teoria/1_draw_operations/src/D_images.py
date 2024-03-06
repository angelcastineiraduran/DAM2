import urllib.request

import reportlab
from reportlab.pdfgen import canvas
# importamos libreria para poder utilizar los metodos que añaden la imagen
from PIL import Image
# importamos tambien
from reportlab.lib.utils import ImageReader

# -- NO ME FUNCIONA NO SE PORQUE!!! --
def hello(c):
 ruta_img = ('../imagenes/baby.png')
 img_reader = reportlab.lib.utils.ImageReader(ruta_img)

 # dibujamos imagen con el metodo nuevo +utilizado
 #c.drawImage(img_reader, 1*inch, 1*inch, width=1*inch, height=0.5*inch)
 c.drawImage(img_reader, 10, 10, mask='auto')
 print("Creado con el archivo")

c = canvas.Canvas('../pdfs/myFirstImage.pdf')
hello(c)
c.showPage()
c.save()