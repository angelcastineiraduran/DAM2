/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Math.round;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dam2
 */
public class Cliente1_v2 {

    // espera x segundos para que me identifique
    static final double SEGUNDOS_ESPERA = 10; // 10s
    static final int RESPUESTA_INDEFINIDA = -1;

    public static void main(String[] args) throws InterruptedException, IOException {

        MiMarcoCliente miMarcoCliente = new MiMarcoCliente();
        MiMarcoUsuario miMarcoUsuario = new MiMarcoUsuario(miMarcoCliente);
        miMarcoUsuario.iniciarComponentes();

        long tiempoInicio = System.nanoTime();
//
//        Thread hIU = new Thread(new hiloInterfaz(miMarcoUsuario));
//        hIU.start();
//        hIU.join();

        boolean first_msj_send = true;
        boolean first_msj_received = true;
        //final String HOST = "10.0.9.104";
        String HOST = "localhost";
        //final int PUERTO = 5000;
        //Socket socket = new Socket(HOST, PUERTO);

        //int respuesta = JOptionPane.NO_OPTION;
        //System.out.println((System.nanoTime() - tiempoInicio) / 1e9);
        System.out.println("Iniciando app");
        int segundosAnteriores = -1; // Inicializar con un valor que no se pueda obtener naturalmente
        while (miMarcoUsuario.nombreUsuario == null) {
            // imprime segundos
            long tiempoTranscurridoNano = System.nanoTime() - tiempoInicio;
            int segundosTranscurridos = (int) (tiempoTranscurridoNano / 1_000_000_000); // Convertir nanosegundos a segundos

            if (segundosTranscurridos != segundosAnteriores) {
                System.out.println("Tiempo: " + segundosTranscurridos + " segundos");
                segundosAnteriores = segundosTranscurridos;
            }
        }
        // logica
        System.out.println("Usuario creado!");
        //Socket socket = new Socket(HOST, miMarcoUsuario.puerto);
        Usuario usuario = new Usuario(miMarcoUsuario);
        Socket socket = new Socket(usuario.getIP(), usuario.getPuerto());

        // espero 1 segundo para que se acaben de crear todos los componentes del this.miMarcoClient
        // ya que corren en otro hilo
        Thread.sleep(1000);

        Thread n0 = new Thread(usuario);
        n0.start();
        n0.join();
        System.out.println("Conectandome al chat...");
        Thread h1 = new Thread(new HiloEscribir(socket, usuario, miMarcoCliente, first_msj_send, miMarcoUsuario));
        Thread h2 = new Thread(new HiloLeer(socket, usuario, miMarcoCliente, first_msj_received));
        h1.start();
        h2.start();

    }
//        
//        if (SEGUNDOS_ESPERA < ((System.nanoTime() - tiempoInicio) / 1e9)) {
//            miMarcoUsuario.marco.dispose();
//            respuesta = JOptionPane.showConfirmDialog(null, "Has tardado mucho tiempo"
//                    + "en introducir el usuario ¿Quieres continuar?", "Pregunta", JOptionPane.YES_NO_OPTION);
//            if (respuesta == JOptionPane.YES_OPTION) {
//                // volvemos a inciiar en caso de que quiera introducir el usuario
//                tiempoInicio = System.nanoTime();
//                System.out.println("El usuario seleccionó Sí.");
//                miMarcoUsuario.iniciarComponentes();
//            } else {
//                System.out.println("El usuario seleccionó No.");
//                // cerramos todo
//                miMarcoUsuario.marco.dispose();
//            }
//        }

}

class HiloEscribir implements Runnable {

    Socket socket;
    Usuario usuario;
    MiMarcoCliente miMarcoCliente;
    boolean first_conn;
    MiMarcoUsuario miMarcoUsuario;

    public HiloEscribir(Socket socket, Usuario usuario, MiMarcoCliente miMarcoCliente, boolean first_conn, MiMarcoUsuario miMarcoUsuario) {
        this.socket = socket;
        this.usuario = usuario;
        this.miMarcoCliente = miMarcoCliente;
        this.first_conn = first_conn;
        this.miMarcoUsuario = miMarcoUsuario;
    }

    @Override
    public void run() {

        try {
            DataOutputStream escritura = new DataOutputStream(socket.getOutputStream());
            String txtConnected = "Usuario " + usuario.getUsuario() + " conectado";
            if (first_conn) {
                System.out.println("PRIMERA CONEXION: \n- usuario=" + usuario.getUsuario());
                //miMarcoCliente.txtSend = txtConnected;
                //miMarcoCliente.txtArea.append(miMarcoCliente.txtSend);
                escritura.writeUTF(txtConnected);
                first_conn = false;
            }

            miMarcoCliente.btnEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    miMarcoCliente.txtSend = miMarcoCliente.txtCampo.getText();
                    miMarcoCliente.txtArea.append("\n" + "Yo: " + miMarcoCliente.txtSend);
                    miMarcoCliente.txtCampo.setText("");
                    try {
                        if (miMarcoCliente.txtSend.equalsIgnoreCase("/q")) {
                            // Enviar mensaje de desconexión al servidor
                            // ej: alberto,/q
                            escritura.writeUTF(usuario.getUsuario() + "," + "/q" + "," + miMarcoCliente.cerrarVentanaInesperado);
                            // Cerrar el socket y finalizar la aplicación
                            socket.close();
                            //System.exit(0);
                            miMarcoCliente.marco.dispose();
                            JOptionPane.showMessageDialog(null, "Has salido del chat");
                            System.exit(0);


                        } else {
                            // Enviar mensaje normal al servidor
                            escritura.writeUTF(usuario.getUsuario() + ": " + miMarcoCliente.txtSend);
                        }
                    } catch (IOException ex) {
                        System.out.println("**Error escribiendo**");
                        ex.printStackTrace();
                    }

                }
            });
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
    boolean first_msj_received;

    public HiloLeer(Socket socket, Usuario usuario, MiMarcoCliente miMarcoCliente, boolean first_msj_received) {
        this.socket = socket;
        this.usuario = usuario;
        this.miMarcoCliente = miMarcoCliente;
        this.first_msj_received = first_msj_received;
    }

    @Override
    public void run() {

        try {
            while (true) {
                DataInputStream lectura = new DataInputStream(socket.getInputStream());
                String msjRecieved = lectura.readUTF();

                if (msjRecieved.equals("/q")) {
                    System.out.println("Algun usuario ha enviado el /q");

                } else if (first_msj_received) {
                    // en el caso de que sea el primer mensaje para que no 
                    // me mande de primeras \n que queda mal
                    miMarcoCliente.txtSend = msjRecieved;
                    miMarcoCliente.txtArea.append(miMarcoCliente.txtSend);
                    first_msj_received = false;

                    // en el caso de que el primer msj recibido de indicando que el chat esta ocupado
                    if (msjRecieved.equalsIgnoreCase("El chat está lleno. Por favor, inténtelo más tarde.")) {
                        // en el caso de que el msj sea de que el chat esta ocupado
                        System.out.println("Chat ocupado...");
                        miMarcoCliente.btnEnviar.setEnabled(false);
                    }

                    System.out.println("Mensaje bienvenida recibido");
                } else if (msjRecieved.equals("**El servidor se ha desconectado**")) {
                    miMarcoCliente.txtSend = msjRecieved;
                    miMarcoCliente.txtArea.append("\n" + miMarcoCliente.txtSend);
                    System.out.println("Servidor desconectado!");
                    miMarcoCliente.btnEnviar.setEnabled(false);
                } else {
                    // en el caso de que sea un msj normal y corriento lo muestro en el area
                    miMarcoCliente.txtSend = msjRecieved;
                    miMarcoCliente.txtArea.append("\n" + miMarcoCliente.txtSend);
                }
            }
            //socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class Usuario implements Runnable {

    private String usuario;
    private int puerto;
    private String IP;
    //MiMarcoCliente miMarcoCliente;

    public Usuario(MiMarcoUsuario miMarcoUsuario) {
        this.usuario = miMarcoUsuario.nombreUsuario;
        this.puerto = miMarcoUsuario.puerto;
        this.IP = miMarcoUsuario.IP;
    }

    @Override
    public void run() {
        this.usuario = usuario;
        this.puerto = puerto;
        this.IP = IP;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

}
