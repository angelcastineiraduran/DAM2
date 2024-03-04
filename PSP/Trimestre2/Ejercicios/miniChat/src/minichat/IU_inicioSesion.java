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

    public MiMarcoUsuario(MiMarcoCliente miMarcoCliente) {
        this.miMarcoCliente = miMarcoCliente;
    }
    
    JFrame marco;
    JLabel lblIntroducirUsuario;
    JTextField txtCampoNombreUsuario;
    JButton btnAceptar, btnCancelar;
    JPanel panelBotones, panelUsuario;
    JPanel panelPrincipal;

    public void iniciarComponentes() {

        iniciar();

        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.add(lblIntroducirUsuario);
        panelUsuario.add(txtCampoNombreUsuario);

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
                if(nombreUsuario != null) {
                    miMarcoCliente.iniciarComponentes();
                    miMarcoCliente.marco.setTitle(nombreUsuario);
                    //miMarcoCliente.txtArea.append("Usuario " + nombreUsuario + " conectado!");
                    marco.dispose();
                }
            }
        });

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(panelBotones);

        marco.setLayout(new FlowLayout());
        marco.add(panelPrincipal);

        cerrar();
    }

    public void iniciar() {
        marco = new JFrame("Iniciar sesion");

        lblIntroducirUsuario = new JLabel("Introduzca un nombre de usuario");
        txtCampoNombreUsuario = new JTextField();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelBotones = new JPanel();

        panelPrincipal = new JPanel();
        panelUsuario = new JPanel();

        marco.setSize(500, 130);
    }

    public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
    
}
