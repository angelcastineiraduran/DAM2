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

    public MiMarcoUsuario(MiMarcoCliente miMarcoCliente) {
        this.miMarcoCliente = miMarcoCliente;
    }
    
    JFrame marco;
    JLabel lblIntroducirUsuario;
    JTextField txtCampoNombreUsuario;
    JButton btnAceptar, btnCancelar;
    JPanel panelBotones, panelUsuario, panelPuerto;
    JPanel panelPrincipal;
    JLabel lblIntroducirPuerto;
    JTextField txtCampoPuerto;

    public void iniciarComponentes() {

        iniciar();

        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.add(lblIntroducirUsuario);
        panelUsuario.add(txtCampoNombreUsuario);
        
        panelPuerto.setLayout(new BoxLayout(panelPuerto, BoxLayout.Y_AXIS));
        panelPuerto.add(lblIntroducirPuerto);
        panelPuerto.add(txtCampoPuerto);

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
                
                if(nombreUsuario != null && puerto != -1) {
                    miMarcoCliente.iniciarComponentes();
                    miMarcoCliente.marco.setTitle(nombreUsuario);
                    //miMarcoCliente.txtArea.append("Usuario " + nombreUsuario + " conectado!");
                    marco.dispose();
                }
            }
        });
        
        // Utiliza JSplitPane para separar los paneles
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelUsuario, panelPuerto);
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelPuerto, panelBotones);
        splitPane.setDividerLocation(50); // Ajusta la posición del divisor según tus necesidades
        splitPane2.setDividerLocation(100); // Ajusta la posición del divisor según tus necesidades

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(splitPane, BorderLayout.CENTER);
        panelPrincipal.add(panelPuerto);
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
        lblIntroducirPuerto = new JLabel("Introduzca el puerto desde el que desea conectarse");
        txtCampoPuerto = new JTextField();
        
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelBotones = new JPanel();
        panelPuerto = new JPanel();

        panelPrincipal = new JPanel();
        panelUsuario = new JPanel();

        marco.setSize(500, 180);
    }

    public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
    
}
