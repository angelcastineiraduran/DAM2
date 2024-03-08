/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minichat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dam2
 */
public class IU_inicioSesion {

    public static void main(String[] args) {
        MiMarcoUsuario miMarcoUsuario = new MiMarcoUsuario(new MiMarcoCliente());
        miMarcoUsuario.iniciarComponentes();
    }
}

class MiMarcoUsuario extends JFrame {
    
    MiMarcoCliente miMarcoCliente;
    String nombreUsuario;
    int puerto = -1; // si imrpime -1 es que no se ha cogido el puerto
    String IP = null; // si imrpime null es que no se ha cogido el IP

    public MiMarcoUsuario(MiMarcoCliente miMarcoCliente) {
        this.miMarcoCliente = miMarcoCliente;
    }
    
    JFrame marco;
    JLabel lblIntroducirUsuario;
    JTextField txtCampoNombreUsuario;
    JButton btnAceptar, btnCancelar;
    JPanel panelBotones, panelUsuario, panelConexionRed;
    JPanel panelPrincipal;
    JLabel lblIntroducirPuerto;
    JTextField txtCampoPuerto;
    JLabel lblIntroducirIp;
    JTextField txtCampoIp;
    JPanel panelPuerto;
    JPanel panelIP;

    public void iniciarComponentes() {

        iniciar();

        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.add(lblIntroducirUsuario);
        panelUsuario.add(txtCampoNombreUsuario);
        
        panelIP.setLayout(new BoxLayout(panelIP, BoxLayout.Y_AXIS));
        panelIP.add(lblIntroducirIp);
        panelIP.add(txtCampoIp);
        panelPuerto.setLayout(new BoxLayout(panelPuerto, BoxLayout.Y_AXIS));
        panelPuerto.add(lblIntroducirPuerto);
        panelPuerto.add(txtCampoPuerto);
        panelConexionRed.setLayout(new FlowLayout());
        panelConexionRed.add(panelIP);
        panelConexionRed.add(panelPuerto);

        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(btnCancelar);
        panelBotones.add(btnAceptar);
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                marco.dispose();
            }
        });
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nombreUsuario = txtCampoNombreUsuario.getText();
                puerto = Integer.parseInt(txtCampoPuerto.getText());
                IP = txtCampoIp.getText(); 
                
                if(nombreUsuario != null && puerto != -1 && IP != null) {
                    miMarcoCliente.iniciarComponentes();
                    miMarcoCliente.marco.setTitle(nombreUsuario);
                    //miMarcoCliente.txtArea.append("Usuario " + nombreUsuario + " conectado!");
                    marco.dispose();
                }
            }
        });
        
        // Utiliza JSplitPane para separar los paneles
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelUsuario, panelConexionRed);
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelConexionRed, panelBotones);
        splitPane.setDividerLocation(50); // Ajusta la posición del divisor según tus necesidades
        splitPane2.setDividerLocation(100); // Ajusta la posición del divisor según tus necesidades

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(splitPane, BorderLayout.CENTER);
        panelPrincipal.add(panelConexionRed);
        panelPrincipal.add(splitPane2, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones);

        marco.setLayout(new FlowLayout());
        marco.add(panelPrincipal);

        cerrar();
    }

    public void iniciar() {
        marco = new JFrame("Iniciar sesion");

        lblIntroducirUsuario = new JLabel("Introduzca un nombre de usuario");
        txtCampoNombreUsuario = new JTextField();
        lblIntroducirPuerto = new JLabel("PUERTO");
        txtCampoPuerto = new JTextField();
        lblIntroducirIp = new JLabel("Direccion IP");
        txtCampoIp = new JTextField();
        panelPuerto = new JPanel();
        panelIP = new JPanel();
        panelConexionRed = new JPanel();
        
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelBotones = new JPanel();
        

        panelPrincipal = new JPanel();
        panelUsuario = new JPanel();

        marco.setSize(300, 180);
    }

    public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
    
}
