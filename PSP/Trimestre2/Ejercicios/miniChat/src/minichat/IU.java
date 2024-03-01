/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dam2
 */
public class IU {
    public static void main(String[] args) {
        MiMarcoCliente miMarcoCliente = new MiMarcoCliente();
        //miMarcoCliente.iniciarComponentes();
    }
}

class MiMarcoCliente extends JFrame {
    
    //MiMarcoUsuario miMarcoUsuario;

    JFrame marco;
    JPanel panelChat;
    JPanel panelTxt;
    JPanel panelBotones;
    JPanel panelUsuario;
    JButton btnEnviar;
    JTextArea txtArea;
    JTextField txtCampo;
    JButton Enviar;
    JLabel lblEscribir;
    JScrollPane scrollPane;
    String txtSend;
    //JLabel lblUsuario;
    //JLabel lblNombreUsuario;
    

    public void iniciarComponentes() {

        iniciar();
        
        // --Panel usuario--
        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.X_AXIS));
        //panelUsuario.add(lblUsuario);
        //panelUsuario.add(lblNombreUsuario);
       
        // --Panel chat--
        panelChat.setLayout(new FlowLayout());
        panelChat.add(scrollPane);

        // --Operaciones--
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.add(txtCampo);
        panelBotones.add(btnEnviar);
        
        // --Marco principal--
        marco.setLayout(new FlowLayout());
        marco.add(panelUsuario);
        marco.add(panelChat);
        marco.add(panelBotones);

        // --actionListener--
        //?

        cerrar();
    }

    public void iniciar() {
        
        //marco = new JFrame("Cliente 1");
        marco = new JFrame("Cliente 1");
        panelChat = new JPanel();
        panelBotones = new JPanel();
        btnEnviar = new JButton("Enviar");
        
        txtArea = new JTextArea(6, 40);
        txtArea.setEditable(false);
        txtCampo = new JTextField();
        txtCampo.setColumns(20);
        lblEscribir = new JLabel("Introducir operacion:");
        
        //lblUsuario = new JLabel("Usuario");
        //lblNombreUsuario = new JLabel("");
        panelUsuario = new JPanel();

        // para que haya scroll
        scrollPane = new JScrollPane(txtArea);
        marco.setSize(500, 200);
    }
       public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
}
