/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcidades2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Consultas consultas = new Consultas();
        Delimitado delimitado = new Delimitado();
        Basicos basic = new Basicos();

        // --PREZO PISO--
        // prezoPiso = pisos.m2 * prezoPorM2 * calculoRestaAnos
        ArrayList<String[]> zonas = delimitado.leerZonas();

        for (int i = 0; i < zonas.size(); i++) {
            String[] zona = zonas.get(i);
            String codz = zona[0];
            System.out.print("codz: " + codz + ", ");
            String nombreZona = zona[1];
            System.out.print("nomz: " + nombreZona + ", ");

            // prezoPorM2
            int prezoPorM2 = Integer.parseInt(zona[2]);
            System.out.print("prezom2: " + prezoPorM2);
            ArrayList<String> codps = consultas.pisosPorZona(codz);

            System.out.println("");

            // obtengo los pisos
            int numeroPisos = 0;
            float prezosPisos = 0;
            for (int j = 0; j < codps.size(); j++) {

                System.out.println("codp: " + codps.get(j));
                // m2
                int m2 = consultas.m2sPorPiso(codps.get(j));
                System.out.print("m2: " + m2 + ", ");
                int ano = consultas.anosPorPiso(codps.get(j));
                int anos = basic.calcularAnos(ano);

                // claculoRestaAnos
                float calculoRestaAnos = basic.filtroAnos(anos);
                float prezoPiso = (m2 * prezoPorM2) - calculoRestaAnos;
                System.out.println("prezoPiso = " + prezoPiso);

                numeroPisos += 1;
                prezosPisos += prezoPiso;
            }

            // totales
            System.out.println("numero pisos zona " + nombreZona + ": " + numeroPisos + ", total: " + prezosPisos);
            System.out.println("\n");

        }
    }

}
