/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psecreto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Psecreto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        ArrayList<String> palabraSecreta= new ArrayList<>();

        // leemos tabla referencia
        Consultas consultas = new Consultas();
        //String letraC1 = consultas.getLetraRef(1, "c1");
        //System.out.println("letraC1 = " + letraC1);

        // leemos clavesuma delimitado
        System.out.println("--LEYENDO CLAVESUMA SERIALIZADA--");
        Delimitado deli = new Delimitado();
        ArrayList<String[]> elementosCS = deli.getElementosCS();
        elementosCS.forEach(elemento -> {
            for (int i = 0; i < elemento.length; i++) {
                System.out.print("[" + i + "]=" + elemento[i] + ",");
            }
            System.out.println("");
        });

        System.out.println("");

        // leemos serializado
        Serializado s = new Serializado();
        ArrayList<Clave1> claves1 = s.clavesSerializado();
        System.out.println("--LEYENDO CLAVE1 SERIALIZADA--");
        claves1.forEach(clave -> {
            System.out.println(clave);
        });

        System.out.println("\n\n\n");
        System.out.println("--LEYENDO RELACION CLAVE1/CLAVE2:REFERENCIA--\n");
        for (int p = 1; p < 11; p++) {
            int sumaClaves;
            System.out.println("-> REFERENCIA p=" + p + " de la columna='c1'");
            int numeroC1 = -1;
            String letraC1 = consultas.getLetraRef(p, "c1");
            System.out.print("(letraC1 = " + letraC1);
            for (Clave1 clave : claves1) {
                if (clave.getCla1().equals(letraC1)) {
                    numeroC1 = clave.getNum1();
                }
            }
            System.out.println(", numeroC1= " + numeroC1 + ")");

            System.out.println("-> REFERENCIA p=" + p + " de la columna='c2'");
            String letraC2 = consultas.getLetraRef(p, "c2");
            System.out.print("(letraC2 = " + letraC2);
            int numeroC2 = consultas.getIntClave2(letraC2, "num2");
            System.out.println(", numeroC2 = " + numeroC2 + ")");

            sumaClaves = numeroC1 + numeroC2;
            System.out.println("->SUMA CLAVES = " + sumaClaves);
            elementosCS.forEach(elemento -> {
                if(Integer.valueOf(elemento[0]) == sumaClaves) {
                    palabraSecreta.add(elemento[1]);
                }
            });

            System.out.println("---------------");

        }
        System.out.println("");
        System.out.print("------> PALABRA SECRETA: ");
        palabraSecreta.forEach(letra ->
                System.out.print(letra)
        );
        System.out.println("");
        

    }

}
