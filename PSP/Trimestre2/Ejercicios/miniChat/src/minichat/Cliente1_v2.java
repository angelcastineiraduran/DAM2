/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Cliente1_v2 {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        MiMarcoCliente miMarcoCliente = new MiMarcoCliente();
        MiMarcoUsuario miMarcoUsuario = new MiMarcoUsuario(miMarcoCliente);
        miMarcoUsuario.iniciarComponentes();
        //miMarcoCliente.iniciarComponentes();
        
        final String HOST = "10.0.9.104";
        final int PUERTO = 5000;
        Socket socket = new Socket(HOST, PUERTO);
        //Usuario usuario = new Usuario(miMarcoCliente);
        
        while(miMarcoUsuario.nombreUsuario == null) {
            System.out.println("Introuce usu");
        }
        Usuario usuario = new Usuario(miMarcoUsuario);
        Thread n0 = new Thread(usuario);
        n0.start();
        n0.join();
        Thread h1 = new Thread(new HiloEscribir(socket, usuario, miMarcoCliente));
        Thread h2 = new Thread(new HiloLeer(socket, usuario, miMarcoCliente));
        h1.start();
        h2.start();
        

    }
}

class HiloEscribir implements Runnable {

    Socket socket;
    Usuario usuario;
    MiMarcoCliente miMarcoCliente;

    public HiloEscribir(Socket socket, Usuario usuario, MiMarcoCliente miMarcoCliente) {
        this.socket = socket;
        this.usuario = usuario;
        this.miMarcoCliente = miMarcoCliente;
    }

    @Override
    public void run() {

        try {
            //while (true) {
            //Scanner scanner = new Scanner(System.in);
            DataOutputStream escritura = new DataOutputStream(socket.getOutputStream());
            System.out.print("Yo: ");
            //String msjSend = scanner.nextLine();
            //escritura.writeUTF(usuario.getUsuario() + ": " + msjSend);
            miMarcoCliente.btnEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    miMarcoCliente.txtSend = miMarcoCliente.txtCampo.getText();
                    miMarcoCliente.txtArea.append("\n" + "Yo: " + miMarcoCliente.txtSend);
                    miMarcoCliente.txtCampo.setText("");
                    try {
                        escritura.writeUTF(usuario.getUsuario() + ": " + miMarcoCliente.txtSend);
                    } catch (IOException ex) {
                        System.out.println("**Error escribiendo**");
                        ex.printStackTrace();
                    }

                }
            });

            //escritura.close();
            //}
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

class HiloLeer implements Runnable {

    Socket socket;
    Usuario usuario;
    MiMarcoCliente miMarcoCliente;
    MiMarcoUsuario miMarcoUsuario;

    public HiloLeer(Socket socket, Usuario usuario, MiMarcoCliente miMarcoCliente) {
        this.socket = socket;
        this.usuario = usuario;
        this.miMarcoCliente = miMarcoCliente;
    }

    @Override
    public void run() {

        try {
            while (true) {
                DataInputStream lectura = new DataInputStream(socket.getInputStream());
                String msjRecieved = lectura.readUTF();
                //System.out.println(msjRecieved);
                miMarcoCliente.txtSend = msjRecieved;
                miMarcoCliente.txtArea.append("\n" + miMarcoCliente.txtSend);
            }
            //socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class Usuario implements Runnable {

    private String usuario;
    //MiMarcoCliente miMarcoCliente;
    String msjBienvenida = "Bienvenido al chat " + usuario + ", estas listo para chatear!";

    public Usuario(MiMarcoUsuario miMarcoUsuario) {
        //this.miMarcoCliente = miMarcoCliente;
        this.usuario = miMarcoUsuario.nombreUsuario;
    }

    @Override
    public void run() {
        System.out.println("Introduce el nombre de usuario: ");

        //Scanner sc = new Scanner(System.in);
        //usuario = sc.nextLine();
        this.usuario = usuario;
        System.out.println(msjBienvenida);
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

}
