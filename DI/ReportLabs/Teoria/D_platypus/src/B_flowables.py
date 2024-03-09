from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet
#from reportlab.rl_config import defaultPageSize # me da error
from reportlab.lib.units import inch
from reportlab.pdfgen import canvas

# El objetivo es mantener el parrafo junto y si hay suficiente espacio se
# dibuja en la pagina actual y si no lo hay se genera una excecpcion.

styles = getSampleStyleSheet()
style = styles['BodyText']
P = Paragraph("Esto es un pequeño ejemplo", style)
c = canvas.Canvas("../pdfs/B_flowables.pdf")

# width and height del area que le vamos a dar al parrafo
aW = 460
aH = 800

# -- Metodo `wrap` --
# Para determinar el espacio requerido por un Flowable (en este caso un parrafo).
# Devuele una tupla `(width_used, height_used)`:
# - `width_used` ancho REAL utiliza por el contenido despues de haber aplicado las
# reglas de envoltura del parrafo
# - `height_used` altura REAL utiliza por ""
# en este caso esta info util para verificar si el contenido (en este caso, el parrafo)
# puede caber en el area especificada (`aW` y `aH`) como hacemos en el if.
w,h = P.wrap(aW, aH)

# Se verifica si hay suficiente espacio disponible en el lienzo
# para dibujar el parrafo:
# A. Si es asi, se dibuja el parrafo y se actualiza la altura en consecuencia
# B. Si no hay suficiente espacio se lanza una excep
if (w <= aW and h <= aH):
    # -- Metodo `drawOn` --
    # se utiliza para dibujar el `Flowable` (`P`) en el lienzo (`c`) en una posicion especifica.
    P.drawOn(c, 0, aH)
    # Despues de dibujar el parrafo se actualiza la var `aH` restando la altura
    # que ocupo el parrafo (`h`).
    # Se hace para AJUSTAR la ALTURA DISPONIBLE en la pagina despues de haber colocado el contenido.
    aH = aH - h
    c.save()
else:
    raise ValueError("Not enough room")