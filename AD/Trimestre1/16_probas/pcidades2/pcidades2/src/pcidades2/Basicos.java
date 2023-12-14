/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcidades2;

import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Basicos {
    
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
    
    public int calcularAnos(int ano) {
        return 2023-ano;
    }
    
    public float filtroAnos(int anos) {
        int cantidadSeResta = -1;
        if(anos > 30) {
            return 20000;
        } else if (anos > 20) {
            return 10000;
        } else if (anos > 10) {
            return 5000;
        } else {
            return 0;
        }
        
    }
    
}
