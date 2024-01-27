/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma1YO;

/**
 *
 * @author ubuntu
 */
public class Acciones extends Thread{
    
    static Buzon buzon = new Buzon();
    static boolean nuevosMensajes = false;
    
    public void leer() {
        System.out.println("Leyendo...");
        String msjLeido = buzon.getMensaje();
        System.out.println("Mensaje leido: " + msjLeido);
        nuevosMensajes = false;
    }
    
    public void escribir() {
        System.out.println("Escribiendo...");
        buzon.setMensaje("Hola mundo");
        System.out.println("Estoy escribiendo: Hola mundo");
        nuevosMensajes = true;
    }
    
    public void run() {
        if(nuevosMensajes == true) {
            leer();
        } else {
            escribir();
        }
    }
    
}

