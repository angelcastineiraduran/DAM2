/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class Pfungo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Basicos basic = new Basicos();
        Serializado serializado = new Serializado();
        Consultas consultas = new Consultas();
        Delimitado delimitado = new Delimitado();

        ArrayList<Detectados> datosSerializado = serializado.getDetectados();
        basic.iterarArrayDetectados(datosSerializado);

        for (int i = 0; i < datosSerializado.size(); i++) {
            Detectados detectado = datosSerializado.get(i);

            int codarea = detectado.getCodarea();
            int codfungo = detectado.getCodfungo();
            double superficie = detectado.getSuperficie();

            int id = codfungo;
            int coda = codarea;
            
            System.out.println("coda ====== " + coda);
            consultas.updateNumeroFungos(coda);
            
            // --hum--
            int humlimite = consultas.selectHumLimite(id);
            System.out.println("humlimite = " + humlimite);
            int hummedia = consultas.selectHumMedia(coda);
            System.out.println("hummedia = " + hummedia);

            double superficiedanana = superficie;
            float superficieA = consultas.selectSuperficie(coda);
            double porcetaxedanos = (superficiedanana * 100) / superficieA;

            if (hummedia > humlimite) {
                // --final--
                String noma = consultas.selectNoma(coda);
                String nomf = consultas.selectNomef(id);
                delimitado.setFfinal(coda, noma, nomf, superficiedanana, porcetaxedanos);
            }
        }

    }

}
