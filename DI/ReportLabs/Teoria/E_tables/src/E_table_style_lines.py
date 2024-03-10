from reportlab.lib import colors
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle

doc = SimpleDocTemplate("../pdfs/E_table_style_lines.pdf", pagesize=letter)

elements = []

data= [['00', '01', '02', '03', '04'],
       ['10', '11', '12', '13', '14'],
       ['20', '21', '22', '23', '24'],
       ['30', '31', '32', '33', '34']]

t = Table(data=data)
t.setStyle(TableStyle([
       ("BOX", (0,0), (-2,-2), 1, colors.red),
       ("GRID", (1,1), (-2,-2), 2, colors.blue),
       ('LINEABOVE', (1,2), (-1,2), 1, colors.green),
       ('LINEBEFORE', (2,0), (2,-1), 1, colors.pink),
       ('LINEABOVE', (2,0), (2,-1), 1, colors.yellow),
       ('LINEAFTER', (-1,1), (-1,-1), 1.5, colors.black),
       ('LINEBELOW', (-1,1), (-1,-1), 1.5, colors.brown),
]))

elements.append(t)

doc.build(elements)