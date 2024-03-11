from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Table, Frame, TableStyle, Image
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib import colors
from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
from reportlab.lib.pagesizes import A4

class Factura:
    def __init__(self, cliente, domicilio="", codigo_postal="", nif="", fecha="",n_pedido="", fecha_vencimiento="", condiciones_pago=""):

        self.hojaEstilo = getSampleStyleSheet()
        self.elementosDoc = []
        self.espacioNormal = Spacer(0.5*inch, 0.5*inch)
        # llamo a todos los metodos...
        self.titulos()
        self.tablaFactura(cliente=cliente, domicilio=domicilio, codigo_postal=codigo_postal, nif=nif, fecha=fecha, n_pedido=n_pedido, fecha_vencimiento=fecha_vencimiento, condiciones_pago=condiciones_pago)
        self.tablaConcepto()
        self.metodoPago()
        self.txtDespedida()

        doc = SimpleDocTemplate("facturaSimplificada.pdf", pagesize = A4)
        doc.build(self.elementosDoc)

    def titulos(self):

        pFactura = Paragraph(text="FACTURA Proforma", style=self.hojaEstilo["Heading1"])
        logoImagen = Image("./pair-extraordinaire-default.png", width=0.5*inch, height=0.5*inch)

        tabla_titulos = Table(data=
                              [[pFactura, logoImagen]],
                              style=TableStyle([
                                  ("VALIGN", (0,0), (-1,-1), "TOP"),
                                  ("ALIGN", (0,0), (-1,-1), "RIGHT"),
                              ]),
                              )
        tabla_titulos._argW[1] = 2.3*inch
        self.elementosDoc.append(tabla_titulos)
        self.elementosDoc.append(self.espacioNormal)

    def tablaFactura(self, cliente, domicilio, codigo_postal, nif, fecha, n_pedido, fecha_vencimiento, condiciones_pago):

        elementos_izquierda = [
            [""],
            ["Cliente", cliente],
            ["Domicilio", domicilio],
            ["Codigo Postal", codigo_postal],
            ["NIF", nif],
            [""]
        ]
        tablaIzquierda = Table(data=elementos_izquierda, style=None, colWidths=100, rowHeights=15)
        tablaIzquierda.hAlign = "LEFT"

        elementos_derecha = [
            ["Fecha", fecha],
            ["Numero de pedido", n_pedido],
            ["Fecha de vencimiento", fecha_vencimiento],
            ["Condiciones de pago", condiciones_pago],
        ]
        tablaDerecha = Table(data=elementos_derecha, style=None, colWidths=100, rowHeights=25)
        tablaDerecha.hAlign = "RIGHT"

        tablaTotal = Table(
            data=[
                ["FACTURAR A:", "Nº FACTURA"],
                [tablaIzquierda, tablaDerecha]
            ]
        )

        tablaTotal.setStyle(TableStyle([
            ("BACKGROUND", (0,0), (-1,-1), colors.lightgrey)
        ]))

        self.elementosDoc.append(tablaTotal)
        self.elementosDoc.append(self.espacioNormal)

    def tablaConcepto(self):
        elementos_concepto = [
            ["Pos", "Concepto/Descripcion", "Cantidad", "Unidad", "Precio Unitario", "Importe"],
            [1],
            [2],
            []
        ]
        tabla_concepto = Table(data=elementos_concepto)
        tabla_concepto.setStyle(TableStyle([
            ("GRID", (0,0), (-1,-1), 0.25, colors.black),
            ("BACKGROUND", (0,0), (-1, 0), colors.lightgrey),
            ("ALIGN", (0,0), (-1,0), "CENTER"),
            ("VALIGN", (0, 0), (-1, 0), "TOP")
        ]))
        tabla_concepto._argW[1] = 2 * inch
        tabla_concepto._argH[0] = 0.4 * inch
        self.elementosDoc.append(tabla_concepto)
        self.elementosDoc.append(self.espacioNormal)

    def metodoPago(self):
        elementos_pago = [
            ["Metodo de pago:"]
        ]

        estilo_pago = TableStyle([
            ("BOX", (0,0), (-1,-1), 0.25, colors.black),
            ("VALIGN", (0, 0), (-1, -1), "TOP"),
            ("ALIGN", (0, 0), (-1, -1), "LEFT"),
            ("BACKGROUND", (0,0), (-1,-1), colors.lightgrey)
        ])

        tabla_pago = Table(data=elementos_pago, style=estilo_pago, colWidths=245, rowHeights=60)
        tabla_pago.hAlign="LEFT"

        elementos_neto = [
            ["Importe neto", ""],
            ["+IVA de X %", ""],
            ["-IRPF de X %", ""],
            ["IMPORTE BRUTO", ""],
        ]

        estilo_neto = [
            ("GRID", (0, 0), (-1, -1), 0.25, colors.black),
            ("LINEABOVE", (0,-1), (-1,-1), 1, colors.black),
            ("BACKGROUND", (0,-1), (-1,-1), colors.lightgrey)
        ]

        tabla_neto = Table(data=elementos_neto, style=estilo_neto)
        tabla_neto._argW[1] = 1*inch
        tabla_neto.hAlign = "RIGHT"

        tablaTotal = Table(data=
                           [[tabla_pago, tabla_neto]],
                           style=
                           TableStyle([
                               ("VALIGN", (0, 0), (-1, -1), "TOP"),
                           ]))

        self.elementosDoc.append(tablaTotal)
        self.elementosDoc.append(self.espacioNormal)

    def txtDespedida(self):
        gracias = Paragraph(text="Gracias por su confianza")
        atentamente = Paragraph(text="Atentamente")
        self.elementosDoc.append(gracias)
        self.elementosDoc.append(self.espacioNormal)
        self.elementosDoc.append(atentamente)

if __name__ == "__main__":
    factura = Factura2(cliente="alberto")
    print("Docu creado correctamente")