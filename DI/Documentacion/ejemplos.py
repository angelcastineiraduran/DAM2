

def promedio(a, b):
    'Calcula el promedio de dos números.'
    return (a + b) / 2


# CADENA MULTILINEAS
def formula_cuadratica(a, b, c):
    """Resuelve una ecuación cuadrática.

    Devuelve en una tupla las dos raíces que resuelven la
    ecuación cuadrática:

        ax^2 + bx + c = 0.

    Utiliza la fórmula general (también conocida
    coloquialmente como el "chicharronero").

    Parámetros:
    a -- coeficiente cuadrático (debe ser distinto de 0)
    b -- coeficiente lineal
    c -- término independiente

    Excepciones:
    ValueError -- Si (a == 0)

    """
    if a == 0:
        raise ValueError(
            'Coeficiente cuadrático no debe ser 0.')
    from cmath import sqrt
    discriminante = b ** 2 - 4 * a * c
    x1 = (-b + sqrt(discriminante)) / (2 * a)
    x2 = (-b - sqrt(discriminante)) / (2 * a)
    return (x1, x2)

print(promedio.__doc__) # > Calcula el promedio de dos números.
promedio.__doc__ = "cambio el comentario de esta func"
print(promedio.__doc__)
help(promedio)
# > promedio(a, b)
# >     cambio el comentario de esta func


def probandoSphinx(a, b):
    """Esto es una prueba.

    **bold** and *italics**

    Listas:
    * primera linea
    * segunda linea

    or
    1. Item1
    2. Item2
    3. Item3

    H1 -- Top of Page Header
    ************************
    There should only be one of these per page and this will also -- when
    converting to pdf -- be used for the chapters.

    H2 -- Page Sections
    ===================

    H3 -- Subsection
    ----------------

    H4 -- Subsubsection
    +++++++++++++++++++

    A Subpoint
    ----------
    This is my idea.

    A subsubpoint
    +++++++++++++
    This is a smaller idea.

    COMPLEX TABLE:

    +------------+------------+-----------+
    | Header 1   | Header 2   | Header 3  |
    +============+============+===========+
    | body row 1 | column 2   | column 3  |
    +------------+------------+-----------+
    | body row 2 | Cells may span columns.|
    +------------+------------+-----------+
    | body row 3 | Cells may  | - Cells   |
    +------------+ span rows. | - contain |
    | body row 4 |            | - blocks. |
    +------------+------------+-----------+

    SIMPLE TABLE:

    =====  =====  ======
    Inputs     Output
    ------------  ------
    A      B    A or B
    =====  =====  ======
    False  False  False
    True   False  True
    False  True   True
    True   True   True
    =====  =====  ======


    `Docs for this project <http://packages.python.org/an_example_pypi_project/>`_

    .. figure::  images/sweat.jpg
    :align:   center

    Proof that getting rich is mostly luck.

    :download:`An Example Pypi Project<docs/examplepypi.pdf>`

    .. |doctest| replace:: :mod:`doctest`

    I really like |doctest|.

    **PARAGRAFOS**

    This is a statement.

    .. warning::

       Never, ever, use this code!

    .. versionadded:: 0.0.1

    It's okay to use this code.

    """
    pass
