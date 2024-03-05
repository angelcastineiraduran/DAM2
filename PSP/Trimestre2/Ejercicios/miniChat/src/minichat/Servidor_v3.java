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
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author dam2
 */
public class Servidor_v3 {

    // Utiliza una lista para almacenar los sockets de los usuarios conectados
    private static final List<Socket> sockets = new ArrayList<>();
    // limitar numero de clientes
    private static final int MAX_CLIENTES = 2;
    private static final long TIEMPO_ESPERA = 30000; // 30 segundos

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        ServerSocket serverSocket = null;
        final int PUERTO = 5000;

        try {
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado, a la escucha");
            
            // Inicia el hilo para manejar los mensajes del servidor desde la consola
            Thread hiloServidor = new Thread(new MensajesAlServidor(false, sockets));
            hiloServidor.start();

            while (true) {
                Socket nuevoSocket = serverSocket.accept();
                sockets.add(nuevoSocket);

                if (sockets.size() <= MAX_CLIENTES) {
                    DataInputStream lectura = new DataInputStream(nuevoSocket.getInputStream());
                    DataOutputStream escritura = new DataOutputStream(nuevoSocket.getOutputStream());
                    // Envia mensaje de bienvenida al nuevo cliente
                    escritura.writeUTF("Bienvenido al chat!");
                    // Crea un nuevo hilo para manejar la comunicación con el cliente
                    Thread hiloCliente = new Thread(new ManejarCliente(nuevoSocket, sockets));
                    hiloCliente.start();

                } else {
                    // Si hay más de 10 clientes, informa al nuevo cliente y cierra la conexión
                    DataOutputStream escritura = new DataOutputStream(nuevoSocket.getOutputStream());
                    escritura.writeUTF("El chat está lleno. Por favor, inténtelo más tarde.");
                    nuevoSocket.close();
                    sockets.remove(nuevoSocket);
                }
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

                // cd se desconecta, el cliente manada: "nombreUsuario,/q"
                if (buscarCaracter(',', mensaje)) {
                    String[] nombres = mensaje.split(",");
                    // Verificar si el cliente se desconectó

                    if (nombres[1].equalsIgnoreCase("/q")) {
                        System.out.println("--El tamanio del array es: " + sockets.size() + "--");
                        sockets.remove(socket);
                        // Enviar mensaje de desconexión a los demás clientes
                        enviarMensajeDesconexion(nombres[0]);
                        System.out.println("Cliente desconectado.");
                        System.out.println("--El tamanio del array es: " + sockets.size() + "--");
                        break;
                    } else {
                        System.out.println("Ha mandado un mensaje con coma, pero no se quiere desconectar!");
                    }
                } else { // si no se quiere desconectar, se manda un msj a todos los sockets
                    for (Socket clienteSocket : sockets) {
                        if (clienteSocket != socket) {
                            DataOutputStream escritura = new DataOutputStream(clienteSocket.getOutputStream());
                            escritura.writeUTF(mensaje);
                        }
                    }
                }

            }

        } catch (IOException ex) {
            // Manejar la desconexión del cliente
            sockets.remove(socket);
            System.out.println("Cliente desconectado.");
        }
    }

    public boolean buscarCaracter(char caracterBuscado, String txt) {
        // Buscar la posición del carácter en la cadena
        int posicion = txt.indexOf(caracterBuscado);

        // Verificar si se encontró el carácter
        if (posicion != -1) {
            return true;
        } else {
            return false;
        }

    }
}


class MensajesAlServidor implements Runnable {

    boolean desconexionServidor;
    private static final String MSJ_DESCONEXION = "/exit";
    private final List<Socket> sockets;

    public MensajesAlServidor(boolean desconexionServidor, List<Socket> sockets) {
        this.desconexionServidor = desconexionServidor;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        System.out.println("Ya puedes escribir comandos al servidor");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String comando = sc.nextLine();
            System.out.println("Comando solicitado: " + comando);
            comprobarDesconexionServidor(comando);
            if (desconexionServidor) {
                try {
                    // Enviar mensaje de desconexión a todos los clientes y cerrar las conexiones
                    enviarMensajeDesconexionServidor();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void comprobarDesconexionServidor(String msj) {
        if (msj.equals(MSJ_DESCONEXION)) {
            desconexionServidor = true;
            System.out.println("Desconexion: " + desconexionServidor);
        }
    }

    private void enviarMensajeDesconexionServidor() throws IOException {
        String mensajeDesconexion = "**El servidor se ha desconectado**";
        for (Socket clienteSocket : sockets) {
            DataOutputStream escritura = new DataOutputStream(clienteSocket.getOutputStream());
            escritura.writeUTF(mensajeDesconexion);
            clienteSocket.close(); // Cierra la conexión con cada cliente
        }
        sockets.clear(); // Limpia la lista de sockets
    }
}

