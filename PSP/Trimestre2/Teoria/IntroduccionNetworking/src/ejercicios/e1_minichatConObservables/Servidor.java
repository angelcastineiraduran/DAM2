/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.e1_minichatConObservables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * En este caso no es que haya un servidor y cliente como tal, lo que pasara
 * es que tanto el servidor como el clienta van a comportarse como cliente y servidor
 * 
 * RECORDAR: hay lineas de codigo que esta comentadas pq copie y peque el codigo
 * de Introduccion a TCP para que me de cuenta de cuales son los cambios que
 * voy haciendo
 * 
 * @author ubuntu
 */
public class Servidor extends Observable implements Runnable {
    
    private int puerto;
    public Servidor (int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        
        ServerSocket serverSocket = null;
        Socket socket = null;
        //final int PUERTO = 5000;
        DataInputStream dis;
        //DataOutputStream dos;
        
        try {
            
            serverSocket = new ServerSocket(puerto);
            
            while(true) {
                System.out.println("Servidor inciando, a la escucha");
                socket = serverSocket.accept();
                
                dis = new DataInputStream(socket.getInputStream());
                //dos = new DataOutputStream(socket.getOutputStream());
                
                String msj = dis.readUTF();
                System.out.println("msj = " + msj);
                
                // en vez de enviar un mensaje, voy a querer NOTIFICAR
                //dos.writeUTF("Hola mundo desde el servidor");
                
                // al heredar de Observable, hereda los siguiente metodos:
                // CONSEJO: siempre que heredemos de Observable, escribir esos 3
                // metodo al momento y en ese orden.
                // el setChanged() es para avisar de que va a cambiar algo
                this.setChanged();
                this.notifyObservers(msj);
                // luego hay que limpiar lo de setChanged()
                this.clearChanged();
                
                socket.close();
                System.out.println("Cliente desconectado");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
