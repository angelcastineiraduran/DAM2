/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma1YO;

/**
 *
 * @author ubuntu
 */
public class Ejercicio7 {
    
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Acciones hilos = new Acciones();
            hilos.start();
            Thread.sleep((long) (3000*Math.random()));
        }
    }
    
}
    

