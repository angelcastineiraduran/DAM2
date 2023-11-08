# XML PROBA O
SAX (simple API for XML: usado para convertir datos a XML e viceversa)

Recordar:
* Todo xml compuesto de elementos
* todo elemento comienza con una etiqueta
* el contenido de un elemento es lo que va situado entre las etiquetas
* El primer elemento de un XML tiene la declaracion que indica la version del
 XML que va a ser usada por el docu??
* un elemento puede contener varioa atributos: variable=valor 


Para escribir y leer documentos vamos a utilizar SAX:
Antes de escribir en un XML tenemos que crear un obj que implemente la *inter
faz* XMLStreamWriter.

Texto a grabar:
```xml
<?xm version="1.0"?>
<autores>
    <autor codigo ="a1">
    <nome>Alexandre Dumas </nome>
    <titulo> El conde de montecristo</titulo>
    <titulo> Los miserables </titulo>
    </autor>
    <autor codigo ="a2">
    <nome>Fiodor Dostoyevski</nome>
    <titulo> El idiota</titulo>
    <titulo> Noches blancas </>
    </autor>
<autores>
```