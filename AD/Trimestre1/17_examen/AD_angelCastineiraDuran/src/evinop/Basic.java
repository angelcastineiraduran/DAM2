/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinop;

import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Basic {
    
    public void iterarArrayStringArreglo(ArrayList<String[]> datos) {
        datos.forEach(dato -> {
            for(int i = 0; i < dato.length; i++) {
                System.out.print("["+ i +"]=" + dato[i] + ", ");
            }
            System.out.println("");
        });
    }
    
    public void iterarArrayString(ArrayList datos) {
        System.out.print("datos = ");
        for(Object dato: datos) {
            System.out.print(dato + ", ");
        }
        System.out.println("");
    }
    
}
