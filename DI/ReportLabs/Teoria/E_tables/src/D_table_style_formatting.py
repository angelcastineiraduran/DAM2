from reportlab.lib import colors
from reportlab.lib.pagesizes import letter, inch
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle

doc = SimpleDocTemplate("../pdfs/D_table_style_formatting.pdf", pagesize=letter)

elements = []

data= [['00', '01', '02', '03', '04'],
       ['10', '11', '12', '13', '14'],
       ['20', '21', '22', '23', '24'],
       ['30', '31', '32', '33', '34']]

# si aumentamos los margenes de colum y filas no vamos a notar las
# propiedades de ALIGN y VALIGN
t = Table(data=data, colWidths=5*[0.4*inch], rowHeights=4*[0.4*inch])
t.setStyle(TableStyle([
    ("ALIGN", (1,1), (-2,-2), "RIGHT"),
    ("TEXTCOLOR", (1,1), (-2,-2), colors.red),
    ("VALIGN", (0,0), (0,-1), "TOP"),
    ("TEXTCOLOR", (0,0), (0,-1), colors.blue),
    ("ALIGN", (0,-1), (-1,-1), "CENTER"),
    ("VALIGN", (1,-1), (-1,-1), "MIDDLE"),
    ("TEXTCOLOR", (0,-1), (-1,-1), colors.green),
    ("INNERGRID", (0,0), (-1,-1), 0.25, colors.black),
    ("BOX", (0,0), (-1,-1), 0.25, colors.black)
]))

elements.append(t)

doc.build(elements)