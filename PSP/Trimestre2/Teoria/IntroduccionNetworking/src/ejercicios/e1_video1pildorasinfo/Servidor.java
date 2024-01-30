/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.e1_video1pildorasinfo;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.net.ssl.SSLSocket;

/**
 * Curso Java. Sockets I. Vídeo 190
 * @author ubuntu
 */
public class Servidor {
    
    public static void main(String[] args) {
        MiMarcoServidor miMarcoServidor = new MiMarcoServidor();
        miMarcoServidor.iniciarInterfaz();
        
        
        
    }
    
}

class MiMarcoServidor extends JFrame implements Runnable{
    
    public void iniciarInterfaz() {
        
        JLabel txtLabel = new JLabel("Servidor");
        JTextArea txtArea = new JTextArea();
        txtArea.setEditable(false);
        JPanel panel = new JPanel();
        JFrame marco = new JFrame("Servidor");
        
        marco.setSize(500,300);
        
        panel.setLayout(new GridLayout(2, 1));
        
        panel.add(txtLabel);
        panel.add(txtArea);
        marco.add(panel);
        
        marco.setDefaultCloseOperation(3);
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
        
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        System.out.println("Estoy a la escucha");
    }
    
    
}
