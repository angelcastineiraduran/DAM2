
import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

# creamos subclase Gtk.Window
class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Hola Mundo")

        self.miBoton = Gtk.Button(label="Clica aqui")

        self.miId = self.miBoton.connect("clicked", self.miBoton_clicado)
        # Desactivamos la señal, por tanto si clicamos, no se produce nada.
        #self.miBoton.disconnect(self.miId)
        # hace lo mismo pero llamadno a la funcion
        #self.miBoton.disconnect_by_func(self.miBoton_clicado)

        self.add(self.miBoton)

    def miBoton_clicado(self, widget):
        print("clicado!!")
        print(self.miId)


win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()
