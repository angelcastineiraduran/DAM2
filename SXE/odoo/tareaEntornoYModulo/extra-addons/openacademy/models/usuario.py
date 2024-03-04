from odoo import fields, models

class TestModel(models.Model):
    _name = "usuarios"
    _description = "Tabla que que recopila los usuarios de la app"

    name = fields.Char(string="Nombre")
    edad = fields.Integer(string="Edad")
    direccion = fields.Text(string="Direccion")