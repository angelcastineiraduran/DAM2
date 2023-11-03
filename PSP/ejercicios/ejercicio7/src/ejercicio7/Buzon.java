/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

/**
 * Es el buzon de correo es un objeto que se utilizara para guardar un mensaje
 * Los metodos son sincronizados para que solo un hilo pueda ejecutar esos
 * metodos a la vez
 *
 * @author ubuntu
 */
public class Buzon {

    /**
     * representa el mensaje almacenado en el buzon
     */
    String mail = null;

    /**
     * permite a los hilos escritores escribir un mensaje en el buzon.
     *
     * @param mensaje
     */
    public synchronized void escritor(String mensaje) {
        //si el buzon esta vacio, los hilos escritores esperan
        while (mail != null) {
            try {
                System.out.println("**No se puede escribir sobre un mail lleno**");
                wait(); // detiene el metodo hasta que se llama al notify() de lector
            } catch (Exception ex) {
                ex.getMessage();
                ex.getStackTrace();
            }
        }
        // Una vez que el buzón está vacío, se escribe el mensaje en mail y se imprime
        this.mail = mensaje;
        System.out.println("Escrbiendo..." + mail);
        notify(); // se notifica a los hilos en espera para que puedan continuar
    }

    /**
     * permite a los hilos lectores leer el mensaje del buzon
     */
    public synchronized void lector() {
        // si el buzon esta vacio, los hilos lectores esperan hasta que haya un mensaje para leer
        while (mail == null) {
            try {
                System.out.println("**El mail tiene que estar lleno para poder leerlo**");
                wait(); // pone en espera el metodo hasta que el otro hilo llame al metodo notify()
            } catch (Exception ex) {
                ex.getMessage();
                ex.getStackTrace();
            }
        }
        // una vez hay mensaje, se imprime y se establece el mail a null para indicar que el buzon esta vacio
        System.out.println("Leyendo..." + mail);
        mail = null;
        notify(); // se notifica a cualquier hilo en espera para que pueda continuar
    }
}
