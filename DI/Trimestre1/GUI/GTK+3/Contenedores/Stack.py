import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MiVentana(Gtk.Window):
    def __init__(self):
        super().__init__(title="Ventana Principal")
        self.set_border_width(10)

        miBox = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=6)
        self.add(miBox)

        # contenedor que solo muestra un elemento a la vez
        miStack = Gtk.Stack()
        miStack.set_transition_type(Gtk.StackTransitionType.SLIDE_LEFT_RIGHT)
        miStack.set_transition_duration(5000)

        miBotonCheck = Gtk.CheckButton(label="Clicame!")
        miStack.add_titled(miBotonCheck, "check", "Un boton de check")

        miEtiqueta = Gtk.Label()
        miEtiqueta.set_markup("<i>Un titulo</i>")
        miStack.add_titled(miEtiqueta,"label", "Una etiqueta")

        miInterruptorStack = Gtk.StackSwitcher()
        miInterruptorStack.set_stack(miStack)

        # si comento la siguiente linea solo se mostraria uno de los hijos
        # y no habria ningun titulo precediendolo. Es decir, si se muestra miBotonCheck
        # no pondria encima "Un boton de check" ya que no hay opciones disponibles
        # ya que como comentabamos, solo se muestra UN HIJO.
        # Si esta descomentado entonces SI me apareceria el titulo indicando el widget que se
        # esta mostrando.
        miBox.pack_start(miInterruptorStack, True, True, 0)
        miBox.pack_start(miStack, True, True, 0)





win = MiVentana()
win.connect("destroy", Gtk.main_quit)
win.show_all()
Gtk.main()