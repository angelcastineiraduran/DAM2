/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psecreto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Serializado {

    String directorioActual = System.getProperty("user.dir");
    //String ruta = directorioActual + "/../enun/clave1";
    String ruta = "/home/ubuntu/DAM2/AD/Trimestre1/psecreto/enun/clave1";

    public ArrayList<Clave1> clavesSerializado() {
        ArrayList<Clave1> claves = new ArrayList();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));
            Clave1 claveLeida;
            while ((claveLeida = (Clave1) ois.readObject()) != null) {
                claves.add(claveLeida);
            }
            ois.close();
            return claves;
        } catch (Exception ex) {
            System.out.println("**Problema leyendo fich serializado**");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }

    }

}
