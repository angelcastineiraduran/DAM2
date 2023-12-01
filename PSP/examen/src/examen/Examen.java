/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

/**
 *
 * @author dam2
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Cadenas cadenas = new Cadenas();
        TratamientoDatos td = new TratamientoDatos();
        
        // seteo la frase y la devuelvo
        cadenas.setFrase();
        String frase = cadenas.getFrase();
        // compruebo la frase devuelta
        System.out.println("frase = " + frase);
        
        // seto el array de palabras y lo devuelvo
        cadenas.setPalabras(frase);
        String[] palabras = cadenas.getPalabras();
        // compruebo que array devuelta
        td.imprimirArrayString(palabras);
        
        // seto el array de letras y lo devuelvo
        cadenas.setLetras(frase);
        char[] letras = cadenas.getLetras();
        td.imprimirArrayCaracteres(letras);
        
        // EMPIEZO LOS HILOS
        
        // A. Busco palabra 3 posicion
        Hilo1 h1 = new Hilo1(palabras);
        h1.start();
        // los join() utilizados los necesito poner en los metodos que setean datos
        // para que se ejecuten SIEMPRE antes de los Threads que me muestran 
        // el resultado. Esto se hace con el fin de que me muestre los resultados
        // encontrados, y no me muestre resultados "null" o algun error.
        h1.join();
        
        // B. Contar numero de caracteres
        Hilo2 h2 = new Hilo2(letras);
        // Los start() llaman al metodo run() de la clase
        h2.start();
        h2.join();
        
        // C. Contar el numero de palabras
        Hilo3 h3 = new Hilo3(palabras);
        h3.start();
        h3.join();
        
        // D. Busco palabra penultima posicion
        Hilo4 h4 = new Hilo4(palabras);
        h4.start();
        h4.join();
        
        // E. Imprimir numero total de palabras y de letras
        Hilo5 h5 = new Hilo5(h2.getContadorLetras(), h3.getContadorPalabras());
        h5.start();
        
        // F. Imprimir posicon 3 palabra y penultima
        Hilo6 h6 = new Hilo6(h1.getPalabraEncontrada(), h4.getPalabraEncontrada());
        h6.start();
        
    }
    
}
