/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package introduccion.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Servidor {

    public static void main(String[] args) {
        
        ServerSocket serverSocket = null;
        // esta clase implementa sockets de clientes, llamados "sockets" a secas
        Socket socket = null;
        final int PUERTO = 5000;
        
        // para trazas caminos entre cliente-servidor
        // para leer, por tanto camino del cliente -> servidor
        // (cliente manda un msj y yo lo leo)
        DataInputStream dis;
        // "" servidor -> cliente
        DataOutputStream dos;
        
        try {
            // creo un server socket asociado a ese puerto
            // si PUERTO=0, se asigna automaticamente (algun puerto de los "efimeros")
            // instancia asociada a un max de 50 peticiones, si intenta entra alguna nueva
            // cd ya hay 50 en cola: se rechazara la conex entreante temporalmente
            serverSocket = new ServerSocket(PUERTO);
            
            // recupero el puerto asociado a ese server socket
            int puertoRecuperado = serverSocket.getLocalPort();
            System.out.println("puertoRecuperado = " + puertoRecuperado);
            
            while(true) {
                // se pone a la escucha y acepta peticiones a este socket
                // este metodo devuelve el socket del cliente
                System.out.println("Servidor inciado, a la escucha");
                socket = serverSocket.accept();
                
                // ¡¡NADA de esto se ejecutara hasta que acepte una peticion!!
                System.out.println("Primer msj despues de que haya aceptaco peticion de cliente");
                
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                
                String msj = dis.readUTF();
                System.out.println("msj = " + msj);
                
                dos.writeUTF("Hola mundo desde el servidor");
                
                // cierro el cliente, NO cierro el servidor
                socket.close();
                System.out.println("Cliente desconectado");
                
                // cd llega a este pto, vuelve al mismo estado de antes, es decir,
                // a la escucha de otra peticion
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
