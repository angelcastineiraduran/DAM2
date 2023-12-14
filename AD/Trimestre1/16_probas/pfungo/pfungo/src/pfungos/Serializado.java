/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfungos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 *
 * @author ubuntu
 */
public class Serializado {
    String rutaDirectorioActual = System.getProperty("user.dir");
    String rutaSerializado = rutaDirectorioActual + "/../enun/detectados";
    
    public ArrayList<Detectados> getDetectados() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Detectados> detectadosLeidos = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(rutaSerializado)));
        Detectados detectadoLeido;
        while((detectadoLeido = (Detectados) ois.readObject()) != null) {
           detectadosLeidos.add(detectadoLeido);
        }
        ois.close();
        return detectadosLeidos;
    }
}
