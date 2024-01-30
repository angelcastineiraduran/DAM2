
package ejercicios.e1_video1pildorasinfo;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Curso Java. Sockets I. Vídeo 190
 * @author ubuntu
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        MiMarcoCliente miMarcoCliente = new MiMarcoCliente();
        miMarcoCliente.iniciarComponentes();
        
    }
    
    
}

class MiMarcoCliente extends JFrame {
    
    JFrame marco;
    JPanel panelChat;
    JPanel panelTxt;
    JButton btnEnviar;
    JTextArea txtArea;
    JTextField txtCampo;
    JLabel lblEscribir;
    JScrollPane scrollPane;
    
    public void iniciarComponentes() {
        iniciar();
        
        // --Panel chat--
        panelChat.setLayout(new FlowLayout());
        panelChat.add(scrollPane);
        
        // --Panel txt--
        //panelTxt.setLayout(new BoxLayout(panelTxt, BoxLayout.X_AXIS));
        panelTxt.setLayout(new GridLayout(1, 2));
        panelTxt.add(txtCampo);
        panelTxt.add(btnEnviar);
        
        // --Marco principal--
        marco.setLayout(new GridLayout(3,1));
        marco.add(panelChat);
        marco.add(lblEscribir);
        marco.add(panelTxt);
        
        // --actionListener--
        // Forma 1: actionListener con clase anonima
        configurarLister();
        
        // Forma 2: actionListener con clase interna
        //EnviarTexto enviarTexto = new EnviarTexto();
        // ponemos boton a la escucha
        //btnEnviar.addActionListener(enviarTexto);
        
        cerrar();
    }
    
    public void iniciar() {
        marco = new JFrame("Cliente");
        panelChat = new JPanel();
        panelTxt = new JPanel();
        btnEnviar = new JButton("Enviar");
        txtArea = new JTextArea(6,40);
        txtArea.setEditable(false);
        txtCampo = new JTextField();
        lblEscribir = new JLabel("Introducir mensaje:");
        // para que haya scroll
        scrollPane = new JScrollPane(txtArea);
        marco.setSize(500,300);
    }
    
    public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
    
    // creo que clase anonima
    public void configurarLister() {
        
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    // para que veamos lo que se va mandando al servidor
                    String txtEnviar = txtCampo.getText();
                    String aux = txtArea.getText();
                    txtArea.setText(aux + '\n' +txtEnviar);
                    
                    // CREACION DEL SOCKET = PUENTE
                    Socket miSocket = new Socket("localhost", 8000);
                    DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                    flujoSalida.writeUTF(lblEscribir.getText());
                    flujoSalida.close();
                    
                    txtCampo.setText("");
                    
                    
                } catch (IOException ex) {
                    // para que no diga cual ha sido el error: ip mal, puerto ocupado...
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
                
            }
            
        });
        
    }
    
    // clase interna
//    private class EnviarTexto implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            System.out.println("Holaa");
//        }
//        
//    }
    
    
}
