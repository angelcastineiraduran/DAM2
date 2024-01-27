/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

/**
 * se ejecutara como un hilo independiente
 * 
 * @author ubuntu
 */
public class Lector extends Thread{
    Buzon buzon;
    
    public Lector(Buzon mail){
        buzon = mail;
    }
    
    /**
     * se ejecuta cuando se inicia al hilo Lector y lee un msg
     */
    @Override
    public void run(){
        buzon.lector();
    }
    
}
