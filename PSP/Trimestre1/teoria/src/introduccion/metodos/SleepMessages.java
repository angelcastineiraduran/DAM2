/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.metodos;

/**
 * Utilizo el metodo estatico `sleep` de la clase 
 * `Thread` para pausar la ejecución del hilo actual
 * 
 * @author ubuntu
 */
public class SleepMessages {
    
    public static void main(String[] args) throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kit will eat ivy too"
        };
        
        for(int i = 0; i < importantInfo.length; i++) {
            // pausa la ejecucion del hilo actual que 
            // en este caso es el hilo principal
            // del programa
            Thread.sleep(4000);
            System.out.println(importantInfo[i]);
        }
    }
    
}
