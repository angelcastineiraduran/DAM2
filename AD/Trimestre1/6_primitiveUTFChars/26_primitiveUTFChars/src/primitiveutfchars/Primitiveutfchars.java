/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author dam2
 */
public class Primitiveutfchars {

    static int tamanioAcumulado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String ruta = "/home/ubuntu/DAM2/AD/26_primitiveUTFChars/texto.txt";
        String textoACopiar = "hola mundo";

        // ESCRITURA
        BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(ruta));
        DataOutputStream salidaData = new DataOutputStream(salida);

        int tamanio = textoACopiar.length();

        System.out.println("writeUTF escribindo: " + textoACopiar);
        salidaData.writeUTF(textoACopiar);
        System.out.println("bytes totais escritos: " + salidaData.size());

        System.out.println("writeChars escribindo: " + textoACopiar);
        salidaData.writeChars(textoACopiar);
        System.out.println("bytes totais escritos: " + salidaData.size());

        System.out.println("writeUTF escribindo: " + textoACopiar);
        salidaData.writeUTF(textoACopiar);
        System.out.println("bytes totais escritos: " + salidaData.size());

        salida.close();
        salidaData.close();

        // LECTURA
        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(ruta));
        DataInputStream entradaData = new DataInputStream(entrada);

        System.out.println("Bytes totais por ler = " + entradaData.available());

        System.out.print("lemos a 1 cadea mediante readUTF: ");
        int c = entradaData.available();
        while (entradaData.available() > (c - tamanio)) {
            System.out.println(entradaData.readUTF());
        }
        System.out.println("numero de bytes por ler: " + entradaData.available());

        System.out.print("lemos a segunda cadea con readChar() en bucle: ");
        c = entradaData.available();
        int i;
        while ((i = entradaData.available()) > (c - tamanio)) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print(entradaData.readChar());
            }
            System.out.println("\nnumero de bytes por ler: " + entradaData.available());
        }
        
        System.out.print("lemos a 2 cadea mediante readUTF: ");
        c = entradaData.available();
        while (entradaData.available() > (c - tamanio)) {
            System.out.println(entradaData.readUTF());
        }
        System.out.println("numero de bytes por ler: " + entradaData.available());
        
        entrada.close();
        entradaData.close();
        }

    }
