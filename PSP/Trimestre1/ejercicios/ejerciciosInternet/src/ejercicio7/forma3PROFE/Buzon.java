/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma3PROFE;

/**
 *
 * @author ubuntu
 */
public class Buzon {

    private String mail = null;

    /**
     * Métodos sincronizados
     */
    //Soamente se pode leer a mensaxe se non é NULL
    public synchronized void lector() {

        while (mail == null) {
            try {
                System.out.println("    *  Buzón vacío. Imposible leer.");
                wait();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Lendo: " + mail);

        mail = null;
        notify();

    }

    //Soamente se pode escribir si a mensaxe é NULL
    public synchronized void escritor(String mai) {

        while (mail != null) {

            try {
                System.out.println("    *   Non se pode escribir. Buzón cheo.");
                wait();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        this.mail = mai;

        System.out.println("Escribindo: " + mail);

        notify();
    }

}
