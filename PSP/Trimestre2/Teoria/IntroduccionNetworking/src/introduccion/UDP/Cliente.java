/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];
        
        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            
            // ¡lo creamos SIN PUERTO! por tanto te asigna un puerto propio
            // esto se hace pq realmente, no le vamos a enviar nada hasta que recibamos su datagrama
            // y como este datagrama es una instancia que contiene info sobre IP y PUERTO...
            DatagramSocket datagramSocket = new DatagramSocket();
            
            String msj = "Hola mundo desde el cliente";
            buffer = msj.getBytes();
            
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            datagramSocket.send(pregunta);
            
            // --RECIBO MSJ DEL SERVIDOR--
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(peticion);
            System.out.println("Recibo msj del servidor");
            String msjServidor = new String(peticion.getData());
            System.out.println("msjServidor = " + msjServidor);
            
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
