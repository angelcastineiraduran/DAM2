> porque no tengo que agregarle ningun parametro al 
> metodo: el_boton_fue_alternado? y porque tampoco le tengo 
> que poner 
> parentesis para indicar que es un metodo?

 En PyQt6, cuando conectas un método a un evento como lo
 haces con miBoton.clicked.connect(self.el_boton_fue_alternado), 
 PyQt6 automáticamente maneja la llamada al método y proporciona
 los argumentos necesarios. Esto significa que no necesitas 
 agregar parámetros ni
 especificar paréntesis al conectar el método a un evento. 
 
Tampoco es necesario poner paréntesis al conectar el método
a un evento en PyQt6. Los paréntesis se utilizan para llamar
a un método y pasar argumentos cuando se realiza una llamada
al método. Cuando conectas un método a un evento en PyQt6, 
no estás llamando al método en ese momento, 
sino que estás diciéndole al framework qué método debe 
+llamar cuando ocurra el evento. El método se llama 
automáticamente cuando el evento se desencadena, y PyQt6 se 
encarga
de proporcionar los argumentos necesarios en ese momento.