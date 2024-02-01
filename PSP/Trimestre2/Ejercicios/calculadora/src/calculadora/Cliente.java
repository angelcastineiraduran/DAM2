/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author ubuntu
 */
public class Cliente {
    public static void main(String[] args) {
        
        final int PORT = 8000;
        final String IP = "192.168.1.192";
        DataOutputStream out;
        Socket socket;
        
        try {
            socket = new Socket(IP, PORT);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("HOLA");
            System.out.println("Mensaje enviado desde cliente");
            socket.close();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
