# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

import os
import sys
sys.path.insert(0,os.path.abspath('..'))# Pongo dos puntos para que busque en el directorio padre(movimos los modulos conexionBD y main a la carpeta padre)


project = 'pruebaSphinx'
copyright = '2024, angel'
author = 'angel'

# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

extensions = ['sphinx.ext.autodoc', # Permite la generación de documentación a partir de los comentarios del código(funcionando)
              'sphinx.ext.intersphinx', # Permite enlazar a otros proyectos y/o modulos
              'sphinx.ext.viewcode', # Muestra el código fuente de los módulos(funcionando
              'sphinx.ext.autosummary', # Permite la generación de resumenes automaticos de los modulos
              ]

templates_path = ['_templates']
exclude_patterns = []

language = 'es'

# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

html_theme = 'alabaster'
html_static_path = ['_static']

