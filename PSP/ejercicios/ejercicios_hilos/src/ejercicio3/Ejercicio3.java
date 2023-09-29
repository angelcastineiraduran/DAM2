/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author dam2
 */
public class Ejercicio3 extends Thread{
    public Ejercicio3(String str){
        super(str);
    }
    static int i;
    public void run(){
        Ejercicio3 hilo;
        for(i = 1; i < 5; i++){
            hilo = new Ejercicio3("hilo " + i);
        }
        
    }
    public static void main(String[] args) {
      
        Ejercicio3 hilo1 = new Ejercicio3("hilo " +  i);
    }
    
}
