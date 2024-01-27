/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking();
        parking.start();
        
        parking.timbrar(1);
        Thread.sleep(5000); // Simulación de tiempo entre llamadas

        parking.timbrar(2);
        Thread.sleep(5000); // Simulación de tiempo entre llamadas
        
        parking.timbrar(3);
        Thread.sleep(5000);
        
        parking.timbrar(4);
        Thread.sleep(5000);
        
        parking.timbrar(5);
        Thread.sleep(5000);

        parking.timbrarSalida(2);
        Thread.sleep(5000);

    }
}
