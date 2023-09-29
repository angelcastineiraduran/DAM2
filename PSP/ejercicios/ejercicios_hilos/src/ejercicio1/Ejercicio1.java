/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Ejercicio1 extends Thread{
    public Ejercicio1(String str){
        super(str);
    }
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i + " " + getName());
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
            System.out.println("fin " + getName());
        }
            
    }
    public static void main(String[] args) {
       Ejercicio1 hilo1, hilo2;
       hilo1 = new Ejercicio1("Juan");
       hilo2 = new Ejercicio1("Pepe");
       
       hilo1.start();
       hilo2.start();
       
       System.out.println("fin del main"); // se ejecuta primero pq? *1
    }
    
}
