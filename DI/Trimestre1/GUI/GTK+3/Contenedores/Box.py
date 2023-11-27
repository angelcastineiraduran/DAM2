import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Ventana Principal")

        # disposicion horizontal
        # espaciado entre botones
        miContenedor = Gtk.Box(spacing=100)

        miBoton1 = Gtk.Button(label="Boton 1")
        miBoton2 = Gtk.Button(label="Boton 2")

        # widgets se colocan de izq a derecha
        # Primer True para expand: widget se expandira horizontalmente hasta llenar espacio disponible
        # Segundo True para fill: se expandira en la direccion en la que estan siendo empaquetados,
        # en este caso es horizontal (pack_start) por tanto ocupan todo el ancho disponible.
        # 0 se refiere al padding
        miContenedor.pack_start(miBoton1, True, True, 0)
        miContenedor.pack_start(miBoton2, True, True, 0)

        # widgets se colocan de derecha a izq
        #miContenedor.pack_end(miBoton1, True, True, 0)
        #miContenedor.pack_end(miBoton2, True, True, 0)

        self.add(miContenedor)


win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()
