/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Edificio {

    public void subirPisos(int pisoInicial, int pisoFinal) throws InterruptedException {
        int i = pisoInicial;
        System.out.println("Subiendo pisos desde el piso " + pisoInicial + " hasta"
                + " el piso " + pisoFinal);

        for (i = pisoInicial; i != pisoFinal; i++) {
            System.out.println("Piso " + i);
            Thread.sleep(500);
        }
        
        System.out.println("Enhorabuena, has llegado a tu destino");

    }

    public void bajarPisos(int pisoInicial, int pisoFinal) throws InterruptedException {
        int i = pisoInicial;
        System.out.println("Bajando pisos desde el piso " + pisoInicial + " hasta"
                + " el piso " + pisoFinal);

        for (i = pisoInicial; i != pisoFinal; i--) {
            System.out.println("Piso " + i);
            Thread.sleep(200);
        }
        
        System.out.println("Enhorabuena, has llegado a tu destino");
    }

}
