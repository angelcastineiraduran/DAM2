/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg29_aleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String ruta = "/home/dam2/DAM2/AD/29_aleatorio/texto.txt";
        // TODO code application logic here
        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};
        
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(ruta), "rw");

        for (int i = 0; i < codes.length; i++) {
            randomAccessFile.writeChars(String.format("%" + 3 + "s", codes[i]));
            randomAccessFile.writeChars(String.format("%" + 10 + "s", descricion[i]));
            randomAccessFile.writeInt(prices[i]);
        }
        int numero = 2; // posicion
        int posicion = (numero - 1) * 30;
        randomAccessFile.seek(posicion);

        // PRIMER REGISTRO
        String cadena = "";
        for (int i = posicion; i < (posicion + 3); i++) {
            cadena += randomAccessFile.readChar();
        }
        posicion += 3;
        System.out.println(cadena.trim());
        
        // SEGUNDO REGISTRO
        cadena = "";
        for (int i = posicion; i < (posicion + 10); i++) {
            cadena += randomAccessFile.readChar();
        }
        posicion += 10;
        System.out.println(cadena.trim());

        // TERCER REGISTRO
        System.out.println(randomAccessFile.readInt());
    }

}
