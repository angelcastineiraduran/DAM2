
import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Ventana Principal")

        # forma 1
        miBoton = Gtk.Button(label="Clica aqui", halign=Gtk.Align.END)
        # forma 2
        miBoton.set_label(label="Holaa")
        # forma 3 - a traves de propiedades
        miBoton.props.label = "Adios"
        print(miBoton.get_property("label")) # >Adios
        miBoton.set_property("label", "Chaito")

        # ver propiedades disponibles para un widget:
        print(dir(miBoton.props)) # >['action_name', 'action_target', 'always_show_image', ...]

        self.add(miBoton)


win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()