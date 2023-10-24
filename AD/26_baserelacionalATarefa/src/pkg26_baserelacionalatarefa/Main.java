/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg26_baserelacionalatarefa;

/**
 *
 * @author dam2
 */
import java.sql.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Metodos metodos = new Metodos();
        boolean exito = false;
        
//        // INSERTAR
//        exito = metodos.insireProduto("112", "carne", 10.0, "13/05/23");
//        System.out.println("exito = " + exito);
        
        
//        // LISTAR
//        exito = metodos.listaProdutos();
        
        // LISTAR POR CODIGO
        exito = metodos.listaPorCodigo("112");
        
        // ACTUALIZAR REGISTRO
        exito = metodos.actualizaPre("112", 4.0);
        System.out.println("exito = " + exito);
        
        // ELIMANA PRODUTO
        exito = metodos.eliminaProduto("111");
        System.out.println("exito = " + exito);
    }
    
    

}
