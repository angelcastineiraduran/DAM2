/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Cliente {
    
    public static void main(String[] args) {
        // IP a la que me voy a conectar
        final String HOST = "127.0.0.1"; // ref a mi maquina
        // puerto al que me voy a conectar
        final int PUERTO = 5000;
        
        // para no liarla, lo recomendable es usar un DataInput tanto en el 
        // cliente como en el servidor, me refiero a no poner en uno DataInput
        // y en el otro un Buffer...
        DataInputStream dis;
        DataOutputStream dos;
        
        try {
            Socket socket = new Socket(HOST, PUERTO);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            
            // RECORDAR: ahora empezamos escribiendo en vez de empezar leyendo
            // ya que el servidor esta esperando un msj
            dos.writeUTF("Hola mundo desde el cliente");
            
            // RECORDAR: despues de que el servidor lea el anterior msj, va a mandar uno
            String msj = dis.readUTF();
            System.out.println("msj = " + msj);
            
            socket.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
