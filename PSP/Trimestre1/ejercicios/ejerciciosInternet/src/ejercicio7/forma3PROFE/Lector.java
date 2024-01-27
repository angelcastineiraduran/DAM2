/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma3PROFE;

/**
 *
 * @author ubuntu
 */
public class Lector extends Thread {

    private Buzon bz;

    //Constructor
    public Lector(Buzon mail) {
        bz = mail;
    }

    //Lánzase o método lector sincronizado do obxecto buzón
    @Override
    public void run() {
        bz.lector();
    }
}
