/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author dam2
 */
public class Cliente1_v2 {

    public static void main(String[] args) throws InterruptedException, IOException {

        final String HOST = "10.0.9.104";
        final int PUERTO = 5000;
        Socket socket = new Socket(HOST, PUERTO);
        Usuario usuario = new Usuario();
        Thread n0 = new Thread(usuario);
        n0.start();
        n0.join();
        Thread h1 = new Thread(new HiloEscribir(socket, usuario));
        Thread h2 = new Thread(new HiloLeer(socket, usuario));
        h1.start();
        h2.start();

    }
}

class HiloEscribir implements Runnable {

    Socket socket;
    Usuario usuario;

    public HiloEscribir(Socket socket, Usuario usuario) {
        this.socket = socket;
        this.usuario = usuario;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                DataOutputStream escritura = new DataOutputStream(socket.getOutputStream());
                System.out.print("Yo: ");
                String msjSend = scanner.nextLine();
                //System.out.println("Enviando msj del " + usuario.getUsuario() + ": " + msjSend);
                escritura.writeUTF(usuario.getUsuario() + ": " + msjSend);
                //socket.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

class HiloLeer implements Runnable {

    Socket socket;
    Usuario usuario;

    public HiloLeer(Socket socket, Usuario usuario) {
        this.socket = socket;
        this.usuario = usuario;
    }

    @Override
    public void run() {

        try {
            while (true) {
                DataInputStream lectura = new DataInputStream(socket.getInputStream());
                String msjRecieved = lectura.readUTF();
                System.out.println(msjRecieved);
            }
            //socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class Usuario implements Runnable {

    private String usuario;

    @Override
    public void run() {
        System.out.println("Introduce el nombre de usuario: ");
        Scanner sc = new Scanner(System.in);
        usuario = sc.nextLine();
        System.out.println("Usuario: " + usuario + " conectandose a chat");
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

}
