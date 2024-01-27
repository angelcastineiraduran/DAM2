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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Servidor {
    
    public static void main(String[] args) {
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];
        
        try {
            System.out.println("Iniciando el servidor");
            
            // clase para enviar y recibir paquetes de datagrama
            // pto de envio o recibo de un servicio de paquetes de datagrama
            // cada paquete enviado/recibido es individualmente direccionado y enrutado
            // varios paquetes enviados desde la misma maquina pueden ser enrutados de != forma
            // y pueden llegar en != orden
            // el contructor crea un datagrama socket y lo "bindea"(enlaza) a CUALQUIER puerto
            // disponible en la maquina HOST
            DatagramSocket datagramSocket = new DatagramSocket(PUERTO);
            
            // le digo que voy a crear un paquete con ese tamaño
            // el paquete contiene info sobre IP y el Puerto de mandatario.
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            
            // cuando se ejecuta (creo) la peticion hace que el buffer se llene del msj enviado
            // este metodo (creo) que bloquea el codigo hasta que el paquete es enviado.
            // si msj enviando >buffer.lenght => msj se trunca
            datagramSocket.receive(peticion);
            System.out.println("Recibo info cliente");
            
            // esto hace que a partir del buffer recibido me lo convierta a una String
            String msj = new String(peticion.getData());
            System.out.println("msj = " + msj);
            
            // la info del cliente, esta contenida (como mencione arriba) en 
            // la instancia tipo DatagramaPacket por tanto queremos extraer
            // la IP y el puerto del cliente para poder enviarle un msj tambien
            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();
            
            // --RESPUESTA--
            String msjServidor = "Hola mundo desde el servidor";
            buffer = msjServidor.getBytes();
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
            datagramSocket.send(respuesta);
            System.out.println("Envio info cliente");
            
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
