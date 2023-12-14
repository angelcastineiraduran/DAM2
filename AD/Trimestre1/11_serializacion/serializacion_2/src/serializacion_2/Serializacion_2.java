/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion_2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dam2
 */
public class Serializacion_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String ruta = "/home/dam2/DAM2/AD/serializacion_2/serial.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        int[] prezo = {3, 4, 5};

        Product product1 = new Product(cod[0], desc[0], Double.valueOf(prezo[0]));
        Product product2 = new Product(cod[1], desc[1], Double.valueOf(prezo[1]));
        Product product3 = new Product(cod[2], desc[2], Double.valueOf(prezo[2]));

        oos.writeObject(product1);
        oos.writeObject(product2);
        oos.writeObject(product3);
        oos.writeObject(null);
        oos.close();

        Product productLeidos;

        while ((productLeidos = (Product) ois.readObject()) != null) {
            System.out.println(productLeidos.toString());
        }

        ois.close();

    }

}
