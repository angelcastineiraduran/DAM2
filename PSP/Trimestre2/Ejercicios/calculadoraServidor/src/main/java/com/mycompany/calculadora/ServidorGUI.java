/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ServidorGUI {
    public static void main(String[] args) {
        OperacionesServidor os = new OperacionesServidor(8003, 8004);
        os.start();
        
        OperacionesServidor os2 = new OperacionesServidor(8005, 8006);
        os2.start();
        
        //OperacionesServidor os2 = new OperacionesServidor(8003, 8005);
        //os2.start();
    }
}

class OperacionesServidor extends Thread {

    int puertoServidor;
    int puertoCliente;

    public OperacionesServidor(int puertoServidor, int puertoCliente) {
        this.puertoCliente = puertoCliente;
        this.puertoServidor = puertoServidor;
    }

    public void run() {
        
        DataInputStream in;
        ServerSocket serverSocket;
        Socket socket = null;
        int operando1 = 0;
        int operando2 = 0;
        String tipoOperacion = null;

        try {
            serverSocket = new ServerSocket(puertoServidor);
            System.out.println("Aceptando peticiones...");

            for (int i = 0; i < 4; i++) {
                socket = serverSocket.accept();
                in = new DataInputStream(socket.getInputStream());
                String msj = in.readUTF();
                System.out.println("msj = " + msj);

                switch (i) {
                    case 0:
                        operando1 = Integer.parseInt(msj);
                        break;
                    case 1:
                        tipoOperacion = msj;
                        break;
                    case 2:
                        operando2 = Integer.parseInt(msj);
                        break;
                    case 3:
                        //in.close();
                        //socket.close();
                        Thread.sleep(2000);
                        System.out.println("Enviado resultado...");
                        int resultado = calcularResultado(tipoOperacion, operando1, operando2);
                        Socket miSocket = new Socket("10.0.9.19", puertoCliente);
                        DataOutputStream out = new DataOutputStream(miSocket.getOutputStream());
                        out.writeInt(resultado);
                        System.out.println("Resultado enviado...");
                        in.close();
                        socket.close();
                        out.close();
                        miSocket.close();
                        System.out.println("todos los socket cerrados");

                    default:
                }

            }

            //socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(OperacionesServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int calcularResultado(String tipoOperacion, int operando1, int operando2) {
        System.out.println("CALCULANDO RESULTADO...");
        int resultado = -1;

        if (tipoOperacion.equals("+")) {
            resultado = operando1 + operando2;
        } else if (tipoOperacion.equals("-")) {
            resultado = operando1 - operando2;
        } else if (tipoOperacion.equals("*")) {
            resultado = operando1 * operando2;
        } else if (tipoOperacion.equals("/")) {
            resultado = operando1 / operando2;
        } else {
            System.out.println("**ALGO HA SALIDO MAL en **");
        }

        System.out.println("resultado = " + resultado);

        return resultado;
    }
    
    

}
