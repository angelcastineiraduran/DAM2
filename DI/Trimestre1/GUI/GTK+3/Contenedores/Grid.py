import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Ventana Principal")

        miDiseño = Gtk.Grid()

        miBoton1 = Gtk.Button(label="b1")
        miBoton2 = Gtk.Button(label="b2")
        miBoton3 = Gtk.Button(label="b3")
        miBoton4 = Gtk.Button(label="b4")
        miBoton5 = Gtk.Button(label="b5")
        miBoton6 = Gtk.Button(label="b6")

        miDiseño.add(miBoton1)
        # miBoton1 esta en la posicion (0, 0) y miBoton2 en (1, 0)
        miDiseño.attach(miBoton2, 1, 0, 2, 1)
        # para añadirlos al lado, en este caso: boton3 con respecto a boton1
        # child=miBoton3, boton a agregar
        # sibbling=miBoton1, el child se colocara junto a sibling (puede ser None)
        miDiseño.attach_next_to(miBoton3, miBoton1, Gtk.PositionType.BOTTOM, 1, 2)
        miDiseño.attach_next_to(miBoton4, miBoton3, Gtk.PositionType.RIGHT, 2, 1)
        # al colocar el siguiente boton, el b3 puede ocupar su espacio ahcia abajo (height:2)
        miDiseño.attach(miBoton5,1, 2, 1, 1)
        # añadiendo el siguiente el b2 y b4 pueden ocupar su ancho
        miDiseño.attach_next_to(miBoton6, miBoton5, Gtk.PositionType.RIGHT, 1, 1)

        self.add(miDiseño)

win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()