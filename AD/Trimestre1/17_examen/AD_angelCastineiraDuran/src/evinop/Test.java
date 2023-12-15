/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinop;

import java.sql.SQLException;

/**
 *
 * @author dam2
 */
public class Test {
    
    public static void main(String[] args) throws SQLException {
        Consultas consultas = new Consultas();
        
        String nomeu = consultas.selectNomeu("c");
        System.out.println("nomeu = " + nomeu);
        
        int acidezmin = consultas.selectAcidezMin("c");
        System.out.println("acidezmin = " + acidezmin);
        
        int acidezmax = consultas.selectAcidezMax("c");
        System.out.println("acidezmax = " + acidezmax);
    }
    
}
