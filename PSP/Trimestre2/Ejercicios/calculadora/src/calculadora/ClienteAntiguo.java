/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteAntiguo {
    
    public static void main(String[] args) {
        
        final int PORT = 8000;
        final String IP = "192.168.1.192";
        OutputStream out;
        
        try {
            System.out.println("Abriendo socket del cliente");
            Socket socket = new Socket(IP, PORT);
            out = socket.getOutputStream();
            String msj = "Hola mundo";
            byte msjB[] = msj.getBytes();
            out.write(msjB);
            System.out.println("Mensaje enviado desde cliente");
            socket.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
}
