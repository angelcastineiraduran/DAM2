/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionHilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Le damos orden de manera manual con el join()
 * 
 * @author ubuntu
 */
public class Sincronizacion1Manual {
    public static void main(String[] args) throws InterruptedException {
        
        HilosVarios hilo1 = new HilosVarios();
        hilo1.start();
        
        hilo1.join();
        
        HilosVarios hilo2 = new HilosVarios();
        hilo2.start();
        
        // si no lo pongo, se ejecutara el hilo 3
        hilo2.join();
        
        // hilo del main, hilo3
        System.out.println("Terminadas las tareas");
                
    }
    
}

class HilosVarios extends Thread {
   @Override
   public void run() {
       for(int i = 0; i < 3; i++) {
           
           // para sabel el nombre del hilo que se esta ejecutando
           System.out.println("Ejecutando hilo" + getName());
           
           try {
               // para que tarde un poco en cada iteraccion
               Thread.sleep(700);
           } catch (InterruptedException ex) {
               Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   } 
}
