/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg26_productsstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ubuntu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Product product = new Product("cod1", "parafusos", 3.0);
        Product product2 = new Product("cod2", "cravos", 4.0);
        Product product3 = new Product("cod3", "tachas", 6.0);
        Product product4 = new Product("cod4", "grapas", 2.0);
        Product po3 = new Product();

        String ruta = "/home/ubuntu/DAM2/AD/26_productsStream/produtos.txt";

        // ESCRITURA
        BufferedOutputStream bufferEscritura = new BufferedOutputStream(new FileOutputStream(ruta));
        DataOutputStream escritura = new DataOutputStream(bufferEscritura);

        // LECTURA
        BufferedInputStream bufferLectura = new BufferedInputStream(new FileInputStream(ruta));
        DataInputStream lectura = new DataInputStream(bufferLectura);

        System.out.println("**Escribindo con writeUFT y writeDouble**");
        // obj 1
        escritura.writeUTF(product.getCodigo());
        escritura.writeUTF(product.getDescripcion());
        escritura.writeDouble(product.getPrecio());
        // obj 2
        escritura.writeUTF(product2.getCodigo());
        escritura.writeUTF(product2.getDescripcion());
        escritura.writeDouble(product2.getPrecio());
        // obj 3
        escritura.writeUTF(product3.getCodigo());
        escritura.writeUTF(product3.getDescripcion());
        escritura.writeDouble(product3.getPrecio());
        // obj 4
        escritura.writeUTF(product4.getCodigo());
        escritura.writeUTF(product4.getDescripcion());
        escritura.writeDouble(product4.getPrecio());

        escritura.close();

        System.out.println("**Finalizado escritura**");

        // GRABADO EN PO3
        System.out.println("lista de produtos guardados no ficheiro produtos.txt");
        // obj 1
        while (lectura.available() != 0) {
            po3.setCodigo(lectura.readUTF());
            po3.setDescripcion(lectura.readUTF());
            po3.setPrecio(lectura.readDouble());
            System.out.println(po3.toString());
        }

    }

}
