/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma3PROFE;

/**
 *
 * @author ubuntu
 */
public class Escritor extends Thread {

    private Buzon bz;
    private String txt;

    //Constructor
    public Escritor(Buzon mail, String texto) {
        bz = mail;
        txt = texto;
    }

    //Lánzase o método escritos sincronizado do obxecto buzón enviandolle a mensaxe
    @Override
    public void run() {
        bz.escritor(txt);
    }
}
