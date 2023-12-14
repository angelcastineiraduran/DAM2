/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exa15brevep;

import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Comunes {
    
    public void iterarArray(ArrayList array){
        for(Object e : array){
            System.out.println("e = " + e);
        }
    }
    
    public Double calcularGraxaParcial(Double peso, Double graxa){
        return  peso/100*graxa;
    }
    
}
