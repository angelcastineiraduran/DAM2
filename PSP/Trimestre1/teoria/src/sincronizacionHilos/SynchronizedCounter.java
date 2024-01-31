/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionHilos;

/**
 * 
 * Solucion para evitar el solapamiento de metodos que acceden al mismo obj
 * desde hilos distintos. Hasta que un hilo no acaba de con el objeto el otro hilo
 * que accede al mismo obj estara suspendido.
 * 
 * 
 * @author ubuntu
 */
public class SynchronizedCounter {
    
    private int c = 0;
    
    public synchronized void increment() {
        c++;
    }
    
    public synchronized void decrement() {
        c--;
    }
    
    public synchronized int value() {
        return c;
    }
}

class Main {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        
    }
}
