/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minichat;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author dam2
 */
public class Servidor_v3 {
    
    // Utiliza una lista para almacenar los sockets de los usuarios conectados
    private static final List<Socket> sockets = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        ServerSocket serverSocket = null;
        final int PUERTO = 5000;

        try {
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado, a la escucha");
            
            while (true) {
                Socket nuevoSocket = serverSocket.accept();
                sockets.add(nuevoSocket);
                
                DataInputStream lectura = new DataInputStream(nuevoSocket.getInputStream());
                DataOutputStream escritura = new DataOutputStream(nuevoSocket.getOutputStream());
                
                // Envia mensaje de bienvenida al nuevo cliente
                escritura.writeUTF("Bienvenido al chat!");

                // Crea un nuevo hilo para manejar la comunicación con el cliente
                Thread hiloCliente = new Thread(new ManejarCliente(nuevoSocket, sockets));
                hiloCliente.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}


class ManejarCliente implements Runnable {

    private final Socket socket;
    private final List<Socket> sockets;

    public ManejarCliente(Socket socket, List<Socket> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }
    
    // Nuevo método para enviar mensaje a todos los clientes
    private void enviarMensajeDesconexion(String usuarioDesconectado) throws IOException {
        String mensajeDesconexion = usuarioDesconectado + " se ha desconectado.";
        for (Socket clienteSocket : sockets) {
            if (clienteSocket != socket) {
                DataOutputStream escritura = new DataOutputStream(clienteSocket.getOutputStream());
                escritura.writeUTF(mensajeDesconexion);
            }
        }
    }

    @Override
    public void run() {
        try {
            DataInputStream lectura = new DataInputStream(socket.getInputStream());

            while (true) {
                String mensaje = lectura.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);

                // Reenviar el mensaje a todos los clientes conectados
                for (Socket clienteSocket : sockets) {
                    if (clienteSocket != socket) {
                        DataOutputStream escritura = new DataOutputStream(clienteSocket.getOutputStream());
                        escritura.writeUTF(mensaje);
                    }
                }
                
                // Verificar si el cliente se desconectó
                if (mensaje.equalsIgnoreCase("/q")) {
                    sockets.remove(socket);
                    // Enviar mensaje de desconexión a los demás clientes
                    enviarMensajeDesconexion("Usuario_" + socket.getPort());
                    System.out.println("Cliente desconectado.");
                    break;
                }
                
//                                String[] nombres = mensaje.split(",");
//                
//                // Verificar si el cliente se desconectó
//                if (nombres[1].equalsIgnoreCase("/q")) {
//                    sockets.remove(socket);
//                    // Enviar mensaje de desconexión a los demás clientes
//                    enviarMensajeDesconexion(nombres[1]);
//                    System.out.println("Cliente desconectado.");
//                    break;
//                }
                
            }
            
        } catch (IOException ex) {
            // Manejar la desconexión del cliente
            sockets.remove(socket);
            System.out.println("Cliente desconectado.");
        }
    }
}