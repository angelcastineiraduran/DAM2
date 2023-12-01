/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.ejercicio6;

/**
 *
 * @author ubuntu
 */
public class Main {

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Dineros obxD = new Dineros();
            ThreadIngreso obxI = null;
            ThreadExtraccion obxE = null;
            for (int i = 0; i < 5; i++) {
                obxI = new ThreadIngreso(obxD, 33);
                obxI.start();
                obxI.join();
                obxI = new ThreadIngreso(obxD, 23);
                obxI.start();
                obxI.join();
                obxE = new ThreadExtraccion(obxD, 16);
                obxE.start();
                obxE.join();
            }
            obxI.join();
            obxE.join();
            System.out.println("Dinero total: " + obxD.getDinero() + "€");
        } catch (InterruptedException ex) {
            System.out.println("**ERROR**");
        }
    }
}
