/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author dam2
 */
public class Hilo6 extends Thread{
        
    String terceraPalabra;
    String penultimaPalabra;

    public Hilo6(String terceraPalabra, String penultimaPalabra) {
        this.terceraPalabra = terceraPalabra;
        this.penultimaPalabra = penultimaPalabra;
    }
    

    public void run() {
        System.out.println("La tercera palabra es " + terceraPalabra
        + " y la penultima palabra es " +  penultimaPalabra);
    }



}
