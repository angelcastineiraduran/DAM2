/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdietaenfermidadeopm;

import java.sql.SQLException;

/**
 *
 * @author postgres
 */
public class Pdietaenfermidadeopm {

    public static void main(String[] args) throws SQLException {
        
        Metodos m = new Metodos();
        String proyectRoute = System.getProperty("user.dir");
        String completeRoute = proyectRoute + "/src/pdietaenfermidadeopm/perenfer.odb";
        
        m.openConnection(completeRoute, "test");
        
        m.selectPersoas();
        
        m.closeConnection();

    }
    
}
