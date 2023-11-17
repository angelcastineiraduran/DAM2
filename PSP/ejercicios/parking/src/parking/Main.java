/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking;

/**
 *
 * @author dam2
 */
public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();
        parking.start();
        parking.timbrar(2);
        try {
            Thread.sleep(3000); // Simulación de tiempo entre llamadas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.timbrar(3);
         try {
            Thread.sleep(3000); // Simulación de tiempo entre llamadas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.timbrar(4);
         try {
            Thread.sleep(3000); // Simulación de tiempo entre llamadas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.timbrar(5);
    }
}
