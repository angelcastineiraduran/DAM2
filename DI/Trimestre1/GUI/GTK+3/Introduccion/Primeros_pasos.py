import gi
# para asegurarnos de que se instale esa version y no otras.
gi.require_version("Gtk", "3.0")
# importamos el modulo Gtk para poder acceder a sus clases y sus funciones.
from gi.repository import Gtk

# creo ventana vacia.
win = Gtk.Window()

# cuando un widget se cierra emite una señal "destroy"
# es buena practica conectar la señal "destroy" de la ventana principal a una
# funcion que se llamara cd se destruya esa ventana.
# en este caso la funcion llamada detiene el bucle principal GTK+,
# la app finaliza y se cierra de manera ordenada.
# por tanto "main_quit" no destruye ventana si no que detienen el bucle principal de la app,
# es decir, cancelamos el Gtk.main()...
win.connect("destroy", Gtk.main_quit)
# desplegamos toda la ventana
win.show_all()
# iniciamos el bucle principal de GTK+ y dicho bucle permanece en
# ejecucion hasta que se llama a Gtk.main_quit()
Gtk.main()
