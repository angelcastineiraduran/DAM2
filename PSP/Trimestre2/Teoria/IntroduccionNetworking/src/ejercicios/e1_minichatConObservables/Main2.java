/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.e1_minichatConObservables;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ubuntu
 */
public class Main2 implements Observer{
    
    public Main2() {
        Servidor servidor = new Servidor(5000);
        // MUY IMPORTANTE ya que si no NO FUNCIONA
        // le digo que tiene que ENVIAR la info a ESTE `Observer`
        servidor.addObserver(this);
        // ....???¿
        Thread hilo = new Thread(servidor);
        // lanzariamos el `Servidor` 
        hilo.start();
    }
    
    public static void main(String[] args) {
        
    }
    
    // metodo al que le va a llegar la info del metodo `notifyObserver()` de `Servidor`
    // `arg` es el mensaje enviado y en este caso `Observable = Servidor`
    @Override
    public void update(Observable o, Object arg) {
        
        
        
    }
    
}
