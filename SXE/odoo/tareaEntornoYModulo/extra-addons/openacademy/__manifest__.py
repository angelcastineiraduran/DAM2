# -*- coding: utf-8 -*-
{
    'name': "miPrimerModulo",

    'summary': """
        Este va a ser un modulo personalizado que hace un muchas cosas""",

    'description': """
        modulo personalizado
    """,

    'author': "angel",
    'website': "https://www.danielcastelao.org",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/16.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'security/ir.model.access.csv',
        'views/views.xml',
        'views/templates.xml',
        'data/datos.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],
}
