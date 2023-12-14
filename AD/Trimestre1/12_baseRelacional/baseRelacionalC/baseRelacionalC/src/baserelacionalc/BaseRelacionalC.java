/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionalc;

import java.sql.SQLException;

/**
 *
 * @author dam2
 */
public class BaseRelacionalC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        Conexiones conexiones = new Conexiones();
        conexiones.listar();
        //conexiones.inserir();
        //conexiones.listar();
        //conexiones.actualizar();
        conexiones.listar();
    }

}
