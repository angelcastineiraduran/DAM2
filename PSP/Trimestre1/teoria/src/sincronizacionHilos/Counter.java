/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionHilos;

/**
 * 
 * Clase para poner a prueba la interferencia entre hilos llamando al 
 * objeto Counter desde distintos threads.
 * 
 * @author ubuntu
 */
public class Counter {
    
    private int c = 0;
    
    public void increment() {
        c++;
    }
    
    public void decrement() {
        c--;
    }
    
    public int value() {
        return c;
    }
}
