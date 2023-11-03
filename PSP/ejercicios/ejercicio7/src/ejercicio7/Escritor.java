/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

/**
 * se ejecutará como un hilo independiente
 * 
 * @author ubuntu
 */
public class Escritor extends Thread{
    Buzon buzon;
    String mensaje;
    
    public Escritor(Buzon mail, String msg){
        buzon = mail;
        mensaje = msg;
    }
    
    /**
     * se ejecuta cuando se inician el hilo Escritor y escribe un mensaje
     */
    @Override
    public void run(){
        buzon.escritor(mensaje);
    }
    
}
