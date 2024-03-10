from reportlab.lib import colors
from reportlab.lib.pagesizes import letter, inch
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle, Image, Paragraph

doc = SimpleDocTemplate("../pdfs/F_complex_cell_values.pdf", pagesize=letter)

elements = []
style = getSampleStyleSheet()

I = Image("../media/pull-shark-default.png")
#???????
I.drawHeight = 1.25*inch*I.drawHeight / I.drawWidth
I.drawWidth = 1.25*inch

P0 = Paragraph('A paragraph 1', style=style["BodyText"])

multiple_text = '''
The reportlab Left
Logo
Image
'''

# CENTRO el txt en la celda:
style_centered = style["BodyText"].clone("Centered")
#style_centered = style["BodyText"] # Funciona igual que arriba pq????
style_centered.alignment = 1 # 0: Izquierda, 1: Centro, 2: Derecha
#P1 = Paragraph(text=multiple_text, style=style["BodyText"])
P1 = Paragraph(text=multiple_text, style=style_centered)

data= [["A", "B", "C", P0, "D"],
       ['00', '01', '02', [I,P1], '04'],
       ['10', '11', '12', [P1,I], '14'],
       ['20', '21', '22', '23', '24'],
       ['30', '31', '32', '33', '34']]

# Las lineas ('ALIGN',(3,1),(3,1),'CENTER') y ('ALIGN',(3,2),(3,2),'LEFT'),
# solo centran las imagenes y no el txt en la celda. esto se debe a que al insertar
# en celdas objs mas complejos (en este caso combinacion de parrafo e imagen) a veces
# es necesario ajustar el alineamiento de cada componente individualmente. Por ello,
# esto lo hacemos arriba cd centramos el txt
t = Table(data=data, style=[
    ("GRID",(1,1),(-2,-2),1,colors.green),
    ('BOX',(0,0),(1,-1),2,colors.red),
    ('LINEABOVE',(1,2),(-2,2),1,colors.blue),
    ('LINEBEFORE',(2,1),(2,-2),1,colors.pink),
    ('BACKGROUND', (0, 0), (0, 1), colors.pink),
    ('BACKGROUND', (1, 1), (1, 2), colors.lavender),
    ('BACKGROUND', (2, 2), (2, 3), colors.orange),
    ('BOX', (0, 0), (-1, -1), 2, colors.black),
    ('GRID', (0, 0), (-1, -1), 0.5, colors.black),
    ('VALIGN', (3, 0), (3, 0), 'BOTTOM'),
    ('BACKGROUND',(3, 0),(3,0),colors.limegreen),
    ('BACKGROUND',(3,1),(3,1),colors.khaki),
    ('ALIGN',(3,1),(3,1),'CENTER'),
    ('BACKGROUND',(3,2),(3,2),colors.beige),
    ('ALIGN',(3,2),(3,2),'LEFT'),
])

# establece el ancho de la 4 columna de la tabla
# _argW se utiliza internamente en Table para almacenar los anchos de columnas
t._argW[3] = 3*inch

elements.append(t)

doc.build(elements)