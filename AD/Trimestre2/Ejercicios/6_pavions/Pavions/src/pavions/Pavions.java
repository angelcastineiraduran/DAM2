/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pavions;

import java.sql.SQLException;

/**
 *
 * @author ubuntu
 */
public class Pavions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Metodos m = new Metodos();
        String objectDbRoute = "/home/ubuntu/DAM2/AD/Trimestre2/Ejercicios/6_pavions/Pavions/src/pavions/resultado.odb";
        
        m.openConnection(objectDbRoute, "test");
        
        m.selectReservas();
        
        m.closeConnection();
    }
    
}
