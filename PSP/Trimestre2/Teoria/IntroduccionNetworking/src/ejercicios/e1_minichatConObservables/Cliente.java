/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.e1_minichatConObservables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * Empezar a leer el paquete por la parte de Servidor!!
 *
 * RECORDAR: hay lineas de codigo que esta comentadas pq copie y pegue el codigo
 * de Introduccion a TCP (Cliente) para que me de cuenta de cuales son los
 * cambios que voy haciendo
 *
 * @author ubuntu
 */
public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {

        final String HOST = "127.0.0.1";
        //final int PUERTO = 5000;

        //DataInputStream dis;
        DataOutputStream dos;

        try {
            Socket socket = new Socket(HOST, puerto);
            //dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            //dos.writeUTF("Hola mundo desde el cliente");
            dos.writeUTF(mensaje);
            

            //String msj = dis.readUTF();
            //System.out.println("msj = " + msj);

            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
