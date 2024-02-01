/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author angel
 */
public class ServidorGUI {

    public static void main(String[] args) {

        final int PORT = 8003;
        DataInputStream in;
        ServerSocket serverSocket;
        Socket socket = null;
        int operando1 = 0;
        int operando2 = 0;
        String tipoOperacion = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Aceptando peticiones...");
            
            for (int i = 0; i < 3; i++) {
                socket = serverSocket.accept();
                in = new DataInputStream(socket.getInputStream());
                String msj = in.readUTF();
                System.out.println("msj = " + msj);
                
                switch(i) {
                    case 0:
                        operando1 = Integer.parseInt(msj);
                        break;
                    case 1:
                        tipoOperacion = msj;
                        break;
                    case 2:
                        operando2 = Integer.parseInt(msj);
                        break;
                    default:
                }
                
                if(i == 2) {
                    
                    int resultado = calcularResultado(tipoOperacion, operando1, operando2);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeInt(resultado);
            
            
                    socket.close();
                }

            }
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int calcularResultado(String tipoOperacion, int operando1, int operando2) {
        System.out.println("CALCULANDO RESULTADO...");
            int resultado = -1;
            
            if(tipoOperacion.equals("+")){
                resultado = operando1 + operando2;
            } else if (tipoOperacion.equals("-")) {
                resultado = operando1 - operando2;
            } else if(tipoOperacion.equals("*")) {
                resultado = operando1 * operando2;
            } else if (tipoOperacion.equals("/")){
                resultado = operando1 / operando2;
            } else {
                System.out.println("**ALGO HA SALIDO MAL**");
            }
            
            System.out.println("resultado = " + resultado);
            
            return resultado;
    }
    
}
