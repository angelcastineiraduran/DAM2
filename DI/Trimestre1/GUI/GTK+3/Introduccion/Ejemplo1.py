
import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

# creamos subclase Gtk.Window
class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Hola Mundo")

        self.miBoton = Gtk.Button(label="Clica aqui")
        # detailed_signal es el nombre del evento al que se esta conectando, la señal especifica que se esta contectando.
        # en la mayoria de los casos de GTK, el nombre de la señal es estandar y
        # corresponde al nombre de la interaccion que se espera con el widget en cuestion.
        # entonces, "clicked" se dispara cuando el boton es presionado.
        self.miBoton.connect("clicked", self.miBoton_clicado)
        self.add(self.miBoton)

    def miBoton_clicado(self, widget):
        print("clicado!!")


win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()
