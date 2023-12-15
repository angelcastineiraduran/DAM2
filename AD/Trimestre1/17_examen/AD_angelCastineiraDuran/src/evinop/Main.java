/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinop;

import evinop.Xerado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Delimitado delimitado = new Delimitado();
        Basic basic = new Basic();
        Consultas consultas = new Consultas();

        ArrayList<String[]> datosAnalisis = delimitado.leerAnalisis();
        basic.iterarArrayStringArreglo(datosAnalisis);

        ArrayList<Xerado> xerados = new ArrayList<>();

        // -- ANALISIS TXT --
        String codigoa = null;
        int acidez = -1;
        int grao;
        int taninos;
        String tipoDeUva = null;
        int cantidade = -1;
        String dni = null;

        // -- A) --
        Xerado xerado;
        // atributos Xerado
        String num = null;
        String nomeuva = null;
        String tratacidez = null;
        int total = -1;

        // -- TABOA UVAS --
        String nomeu = consultas.selectNomeu("c");
        int acidezmin = consultas.selectAcidezMin("c");
        int acidezmax = consultas.selectAcidezMax("c");

        System.out.println("");

        for (String[] ele : datosAnalisis) {

            for (int i = 0; i < ele.length; i++) {
                switch (i) {
                    case 0:
                        codigoa = ele[0];
                        System.out.println("codigoa = " + codigoa);
                        num = codigoa;
                        break;
                    case 1:
                        acidez = Integer.parseInt(ele[1]);
                        System.out.println("acidez = " + acidez);
                        break;
                    case 2:
                        grao = Integer.parseInt(ele[2]);
                        System.out.println("grao = " + grao);
                        break;
                    case 3:
                        taninos = Integer.parseInt(ele[3]);
                        System.out.println("taninos = " + taninos);
                        break;
                    case 4:
                        tipoDeUva = ele[4];
                        System.out.println("tipoDeUva = " + tipoDeUva);
                        break;
                    case 5:
                        cantidade = Integer.parseInt(ele[5]);
                        System.out.println("cantidade = " + cantidade);
                        total = cantidade * 15;
                        System.out.println("total = " + total);
                        break;
                    case 6:
                        dni = ele[6];
                        System.out.println("dni = " + dni);
                        break;
                }
            }
            
            acidezmin = consultas.selectAcidezMin(tipoDeUva);
            acidezmax = consultas.selectAcidezMax(tipoDeUva);
            
            if (acidez > acidezmax) {
                tratacidez = "baixar acidez";
                System.out.println("tratacidez = " + tratacidez);
            } else if (acidez < acidezmin) {
                tratacidez = "subir acidez";
                System.out.println("tratacidez = " + tratacidez);
            } else {
                tratacidez = "equilibrada";
                System.out.println("tratacidez = " + tratacidez);
            }
            
            nomeuva = consultas.selectNomeu(tipoDeUva);

            xerado = new Xerado(num, nomeuva, tratacidez, total);
            xerados.add(xerado);
            System.out.println("-----------------");
            
            // -- AUMENTO NUMERO ANALISIS --
            consultas.updateNumeroDeAnalisis(dni);

        }
        
        System.out.println("");
        System.out.println("");
        
        String directorioActual = System.getProperty("user.dir");
        String rutaFicheroLeer = directorioActual + "/../enun/serializado";
        
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(rutaFicheroLeer)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(rutaFicheroLeer)));
        
        System.out.println("** INSERTANDO SERIALIZADO **");
        for (Xerado ele : xerados) {
            //System.out.println(ele.toString());
            System.out.println("insertado +1");
            oos.writeObject(ele);
        }
        oos.writeObject(null);
        oos.close();
        
        
        System.out.println("** LEYENDO SERIALIZADO **");
        Xerado xeradoLeido;
        while ((xeradoLeido = (Xerado) ois.readObject()) != null) {
            System.out.println(xeradoLeido.toString());
        }

        ois.close();
    }

}
