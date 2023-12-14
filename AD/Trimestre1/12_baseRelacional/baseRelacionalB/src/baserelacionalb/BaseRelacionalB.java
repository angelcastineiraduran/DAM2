/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionalb;

import java.sql.SQLException;

/**
 *
 * @author dam2
 */
public class BaseRelacionalB {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Consultas consultas = new Consultas();
        
        // LISTAR
        consultas.listaProdutos();
        // INSERIR
        //consultas.inserir("afs", "carne", 3, "2/3/3");
        
        
        
    }
    
}
