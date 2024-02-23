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
import java.util.Scanner;

/**
 *
 * @author dam2
 */
public class Cliente1 {
    public static void main(String[] args) {
        final String HOST = "10.0.9.104";
        final int PUERTO = 5000;
        
        DataInputStream lectura;
        DataOutputStream escritura;
        
        Scanner scanner = new Scanner(System.in);

        
        try {
            Socket socket = new Socket(HOST, PUERTO);
            
            System.out.println("Conectando " +  Cliente1.class.getName());
            lectura = new DataInputStream(socket.getInputStream());
            escritura = new DataOutputStream(socket.getOutputStream());
            System.out.print("Por favor, ingrese un mensaje: ");
            String msjSend = scanner.nextLine();
            
            // Cliente 1 envia el primer mensja al Cliente2
            System.out.println("Enviando msj del " + Cliente1.class.getName() + ": " + msjSend);
            escritura.writeUTF(msjSend);
            
            System.out.println("Recibiendo msj de " + Cliente1.class.getName());
            String msjRecieved = lectura.readUTF();
            System.out.println("msj = " + msjRecieved);
            socket.close();
            
        } catch(IOException ex) {
            System.out.println("Ha ocurrido un error con " + Cliente1.class.getName());
            ex.printStackTrace();
        }
    }
}
