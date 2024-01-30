/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.definirHilo;

import javax.swing.text.Highlighter;

/**
 *
 * @author ubuntu
 */
public class Main {
    
    public static void main(String[] args) {
        // MEJOR PRACTICA:
        // es mejor practica pq separo lo que hace el hilo,
        // es decir, lo que va dentro del run(), del propio
        // hilo, es decir, de la clase Thread; ya que ahora
        // podria crear otra instancia de hilo de la 
        // clase Thread introduciendo en el constructor
        // un obj Runnable distinto
        Thread hiloF1 = new Thread(new Forma1());
        hiloF1.start();
        
        Forma2 hiloF2 = new Forma2();
        hiloF2.start();
    }
    
}

class Forma1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Hilo Forma 1: implementando"
                + "Runnable");
    }
    
}

class Forma2 extends Thread {
    // hay que sobreescribir el run() ya que 
    // la clase Thread implementa Runnable
    // como arriba, al ser Runnable una interfaz, en la clase
    // Thread hay que implementar los metodo abs de Runnable.
    // esto ya se hace en la clase Thread pero deja el cuerpo
    // del metodo vacio y por eso nosotros tenemos que sobreescirbir
    // ese metodo, para adjudicarle un comportamiento a eso hilo
    public void run() {
        System.out.println("Hilo Forma 2: exteniendo de Thread");
    }
}
