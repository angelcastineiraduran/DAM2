# -*- coding: utf-8 -*-

from odoo import fields, models

class TestModel(models.Model):
    # atributo mas importante
    # define el nombre para el modelo en el sist de odoo
    _name = "test_model"
    _description = "Modelo de prueba"

    # **CAMPOS QUE TIENE LA TABLA**
    # para definir lo que puede almacenar el modelo y dd
    # los campos se definen como atributos en el modelo
    # Nombre y Descripcion son los nombres de los rotulos que se muestran
    name = fields.Char(string="Nombre")
    description = fields.Text(string="Descripcion")

# class openacademy(models.Model):
#     _name = 'openacademy.openacademy'
#     _description = 'openacademy.openacademy'

#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100
