/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivewriteutf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author dam2
 */
public class Primitivewriteutf {

    static int tamanioAcumulado;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String rutaOrigen = "/home/dam2/DAM2/AD/20 primitivewriteutf/texto.txt";
        String rutaFinal = "/home/dam2/DAM2/AD/20 primitivewriteutf/texto_copia.txt";

        String textoACopiar = "o tempo está xélido";

        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(rutaOrigen));
        BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(rutaOrigen, true));

        DataInputStream entradaData = new DataInputStream(entrada);
        DataOutputStream salidaData = new DataOutputStream(salida);

        String palabraLeida = "error";

        salidaData.writeUTF(textoACopiar);

        int tamanio = salidaData.size();
        salida.close();
        salidaData.close();
        int c;
        while ((c = entradaData.available()) != 0) {
            System.out.println("texto: " + entradaData.readUTF());
            tamanioAcumulado += tamanio;
            System.out.println("tamanio: " + tamanioAcumulado);
        }

        entrada.close();
        entradaData.close();

    }

}
