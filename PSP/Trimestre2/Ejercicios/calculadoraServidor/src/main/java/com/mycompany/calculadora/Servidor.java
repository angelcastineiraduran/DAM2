/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
/**
 *
 * @author angel
 */
public class Servidor {
    
    public static void main(String[] args) {
        
        final int PORT = 8000;
        DataInputStream in;
        Socket socket;
        
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Aceptando peticiones...");
            socket = serverSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            String msj = in.readUTF();
            System.out.println("msj = " + msj);
            socket.close();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
