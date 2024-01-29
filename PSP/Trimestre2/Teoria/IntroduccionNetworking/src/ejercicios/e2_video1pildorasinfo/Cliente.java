
package ejercicios.e2_video1pildorasinfo;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Cliente {
    
    public static void main(String[] args) {
        
        MiMarco miMarco = new MiMarco();
        miMarco.iniciarComponentes();
        
    }
    
    
}

class MiMarco extends JFrame {
    
    JFrame marco;
    JPanel panelChat;
    JPanel panelTxt;
    JButton btnEnviar;
    JTextArea txtArea;
    JTextField txtCampo;
    
    public void iniciarComponentes() {
        iniciar();
        
        // --Panel chat--
        panelChat.setLayout(new FlowLayout());
        panelChat.add(txtArea);
        
        // Panel txt--
        //panelTxt.setLayout(new BoxLayout(panelTxt, BoxLayout.X_AXIS));
        panelTxt.setLayout(new GridLayout(1, 2));
        panelTxt.add(txtCampo);
        panelTxt.add(btnEnviar);
        
        // --Marco principal--
        marco.setLayout(new GridLayout(2,1));
        marco.add(panelChat);
        marco.add(panelTxt);
        
        cerrar();
    }
    
    public void iniciar() {
        marco = new JFrame("Cliente");
        panelChat = new JPanel();
        panelTxt = new JPanel();
        btnEnviar = new JButton("Enviar");
        txtArea = new JTextArea();
        txtCampo = new JTextField();
        marco.setSize(500,300);
    }
    
    public void cerrar() {
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centra ventana
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);
    }
    
}
