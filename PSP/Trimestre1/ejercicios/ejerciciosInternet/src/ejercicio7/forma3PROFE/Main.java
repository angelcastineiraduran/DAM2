/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma3PROFE;

/**
 *
 * @author ubuntu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Obxecto que sincronizará os fíos lectores e escritores
        Buzon b = new Buzon();

        //Créanse 3 Lectores e 3 Escritores
        Escritor e1 = new Escritor(b, "hola");
        Lector l1 = new Lector(b);

        Escritor e2 = new Escritor(b, "hello");
        Lector l2 = new Lector(b);

        Escritor e3 = new Escritor(b, "ola");
        Lector l3 = new Lector(b);

        //Inicianse os Escritores
        e1.start();
        e3.start();
        e2.start();

        //Inicianse os Lectores
        l1.start();
        l2.start();
        l3.start();

    }
}
