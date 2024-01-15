from reportlab import rl_config
from reportlab.lib.pagesizes import letter, A4


class Canvas:
    def __init__(self,
             filename,
             #pagesize = (595.27,841.89),
             pagesize=letter,
             bottomup = 1,
             pageCompression = 0,
             encoding = rl_config.defaultEncoding,
             verbosity = 0,
             encrypt = None):
        print("Creado con el archivo")

#myCanvas = Canvas("myfile.pdf", pagesize=A4)
myCanvas = Canvas("myfile.pdf", pagesize=letter)

# extraemos el ancho y el alto ya que en algunos documento diseñamos el contenido
# en base al ancho y alto de la pagina, por eso extraemos esos parametros en una variable
# por si queremos utilizarlas en un futuro
width, height = letter