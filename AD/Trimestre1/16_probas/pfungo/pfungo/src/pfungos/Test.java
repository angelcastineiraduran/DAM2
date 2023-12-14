/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfungos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Test {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Basicos basic = new Basicos();
        Serializado serializado = new Serializado();
        Consultas consultas = new Consultas();
        Delimitado delimitado = new Delimitado();

        ArrayList<Detectados> datosSerializado = serializado.getDetectados();
        basic.iterarArrayDetectados(datosSerializado);

        // consultas.updateNumeroFungos(1);
        int numerofungos = consultas.selectNumeroFungo(1);
        System.out.println("numerofungos = " + numerofungos);
        
        // humedades
        int hummedia = consultas.selectHumMedia(1);
        System.out.println("hummedia = " + hummedia);
        int humlimite = consultas.selectHumLimite(1);
        System.out.println("humlimite = " + humlimite);
        
        // escribiendo fichero final
        //delimitado.setFfinal(1, "algo", "hola", 200, 2.3);
        
        
    }

}
