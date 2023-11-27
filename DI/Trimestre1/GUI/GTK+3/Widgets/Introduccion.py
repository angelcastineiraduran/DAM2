import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Ventana Principal")
        miWidget = Gtk.AboutDialog("HOla")
        self.add(miWidget)



win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()