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
/**
 *
 * @author dam2
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        ServerSocket serverSocket = null;
        Socket socket1 = null;
        Socket socket2 = null;
        final int PUERTO = 5000;
        DataInputStream lectura;
        DataOutputStream escritura;
        
        try {
            serverSocket = new ServerSocket(PUERTO);
            while(true) {
                System.out.println("Servidor iniciado, a la escucha");
                socket1 = serverSocket.accept();
                System.out.println("Primer msj serv despues de que se aceptase peti cliente");
                lectura = new DataInputStream(socket1.getInputStream());
                
                String msj = lectura.readUTF();
                System.out.println("msj = " + msj);
                
                socket2 = serverSocket.accept();
                escritura = new DataOutputStream(socket2.getOutputStream());                
                escritura.writeUTF(msj);
                
                socket1.close();
                socket2.close();
                
            }
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
