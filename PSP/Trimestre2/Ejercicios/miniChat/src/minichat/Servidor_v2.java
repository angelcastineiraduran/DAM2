/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minichat;

import java.awt.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Servidor_v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        ServerSocket serverSocket = null;
        Socket socket1 = null;
        Socket socket2 = null;
        final int PUERTO = 5000;
        DataInputStream lectura1;
        DataOutputStream escritura1;
        DataInputStream lectura2;
        DataOutputStream escritura2;

        try {
            serverSocket = new ServerSocket(PUERTO);
            while (true) {
                System.out.println("Servidor iniciado, a la escucha");
                socket1 = serverSocket.accept();
                socket2 = serverSocket.accept();

                lectura1 = new DataInputStream(socket1.getInputStream());
                lectura2 = new DataInputStream(socket2.getInputStream());
                escritura1 = new DataOutputStream(socket1.getOutputStream());
                escritura2 = new DataOutputStream(socket2.getOutputStream());

                Thread h1 = new Thread(new Leer(lectura1, escritura2));
                Thread h2 = new Thread(new Escribir(escritura1, lectura2));
                h1.start();
                h2.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket1.close();
                socket2.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor_v2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

class Leer implements Runnable {
    DataInputStream lectura1;
    DataOutputStream escritura2;

    public Leer(DataInputStream lectura1, DataOutputStream escritura2) {
        this.lectura1 = lectura1;
        this.escritura2 = escritura2;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Servidor iniciado (lec), a la escucha");

                String msj = lectura1.readUTF();
                System.out.println("msj = " + msj);
                escritura2.writeUTF(msj);
            }

        } catch (IOException ex) {
            System.out.println("**Error en metodo leer**");
            ex.printStackTrace();
        }
    }
}

class Escribir implements Runnable {
    DataOutputStream escritura1;
    DataInputStream lectura2;

    public Escribir(DataOutputStream escritura1, DataInputStream lectura2) {
        this.escritura1 = escritura1;
        this.lectura2 = lectura2;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Servidor iniciado (esc), a la escucha");
                String msj2 = lectura2.readUTF();
                System.out.println("msj2 = " + msj2);
                escritura1.writeUTF(msj2);
            }

        } catch (IOException ex) {
            System.out.println("**Error en metodo escribir**");
            ex.printStackTrace();
        }
    }
}