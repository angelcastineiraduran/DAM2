from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet
#from reportlab.rl_config import defaultPageSize # me da error
from reportlab.lib.units import inch

# para posteriormente coger una de los estilos de parrafos predefinidos.
styles = getSampleStyleSheet()
Title = "Hola mundo"
pageinfo = "ejemplo platypus"

# Defino el contenido FIJO para la primera pagina del documento
def miPrimeraPagina(c, doc):
    c.saveState()
    c.setFont("Times-Roman", 9)
    c.drawString(inch, inch, "Pagina %d %s" % (doc.page, pageinfo))
    c.restoreState()

# Defino el contenido FIJO para las paginas posteriores.
def miPaginasSiguientes(c, doc):
    c.saveState()
    c.setFont('Helvetica', 15)
    c.drawString(inch, 0.75 * inch,"Pagina %d %s" % (doc.page, pageinfo))
    c.restoreState()

# solo usamos 2 tipos de flowables: Spacers, Paragraphs
def go():
    # La clase SimpleDocTemplate proporciona un marco para la creacion de documentos pdf
    # y se utiliza para establecer la estructura del pdf y las conf del docu.
    doc = SimpleDocTemplate("../pdfs/A_introduccion.pdf")
    # Story contendra los elementos Platypus. Se iniciar con un separador vertical
    # lo que hace que haya espacio en blanco en la parte superior del docu para que no afecte al titulo.
    Story = [Spacer(1, 2 * inch)]
    # se define el estilo del parrafo llamado "Normal" utilizando los predefinidos de la func `getSimpleSytleSheet()`
    style = styles["Normal"]
    for i in range(100):
        # en cada interaccion se crea un parrafo ficticio `bogusttext` que se compone de la cadena "Este parrafo es el
        # numero [n]" repetido 20 veces.
        bogustext = ("Este parrafo es el numero %s. " % i) * 20
        # se crea un objeto `Paragrahp` con ese txt y el estilo predefinido anteriormente.
        p = Paragraph(bogustext, style)
        # se agrega el parrafo a la lista Story
        Story.append(p)
        # desspues de cada parrafo se agrega un espaciador
        Story.append(Spacer(1, 0.2 * inch))

    # se le pasa Story que contiene todos los elementos y las funciones que definen el contenido fijo
    # onFirstPage = parametro opcional que define el contenido fijo de la primera pag.  (onLaterPager lo mismo...)
    doc.build(Story, onFirstPage=miPrimeraPagina, onLaterPages=miPaginasSiguientes)

if __name__ == "__main__":
    go()