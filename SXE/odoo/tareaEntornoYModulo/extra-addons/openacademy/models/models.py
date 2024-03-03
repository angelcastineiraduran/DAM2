# -*- coding: utf-8 -*-

from odoo import fields, models

class TestModel(models.Model):
    # con solo esto ya bastaria
    # define el nombre para el modelo en el sist de odoo
    _name = "test.model"
    _description = "Modelo de prueba"

    # --Campos--
    # para definir lo que puede almacenar el modelo y dd
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
