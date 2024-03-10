from reportlab.lib import colors
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle

doc = SimpleDocTemplate("../pdfs/C_table_style.pdf", pagesize=letter)

# container for de `Flowables` objects
elements = []

data= [['00', '01', '02', '03', '04'],
       ['10', '11', '12', '13', '14'],
       ['20', '21', '22', '23', '24'],
       ['30', '31', '32', '33', '34']]

t = Table(data=data)

# en caso de que empiece a contar desde columna/fila = 0...
# (columna, fila)
# -- A. Fondo verde: desde C1, F1 a C3, F2 --
# ("BACKGROUND", (1,1), (-2,-2), colors.green)
# (0,0) esquina superior izq --> (1,1) == C1, F1
# (-1,-1) esquina inferior derecha --> (-2,-2) == C3, F2 == (3, 2) ES LO MISMO!
# -- B. Color txt: desde C0, F0 a C1, F4 --
# Recordar: (1, -1) == (-4, -1)
t.setStyle(TableStyle([("BACKGROUND", (1,1), (-2,-2), colors.green),
                       ("TEXTCOLOR", (0,0), (1,-1), colors.red)]))

elements.append(t)

# write the document to disk
doc.build(elements)