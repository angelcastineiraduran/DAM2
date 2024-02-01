/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ServidorAntiguo {

    public static void main(String[] args) {

        final int PORT = 8000;
        Socket socket = null;

        InputStream in;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Aceptando petis desde Servidor");
            // devolvemos el socket del cliente
            socket = serverSocket.accept();
            in = socket.getInputStream();
            byte msj[] = new byte[25];
            // almacena el mensaje recibido en un array de bytes
            in.read(msj);
            System.out.println("msj = " + new String(msj));
            socket.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }
}
