/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author dam2
 */
public class Cliente1 {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        
        DataInputStream lectura;
        DataOutputStream escritura;
        
        try {
            Socket socket = new Socket(HOST, PUERTO);
            
            System.out.println("Conectando " +  Cliente1.class.getName());
            lectura = new DataInputStream(socket.getInputStream());
            escritura = new DataOutputStream(socket.getOutputStream());
            
            escritura.writeUTF("Hola desde " +  Cliente1.class.getName());
            
            //String msj = lectura.readUTF();
            //System.out.println("msj = " + msj);
            socket.close();
            
        } catch(IOException ex) {
            System.out.println("Ha ocurrido un error con " + Cliente1.class.getName());
            ex.printStackTrace();
        }
    }
}
