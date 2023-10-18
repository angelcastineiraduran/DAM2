/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Serializacion_1 {

    /*
    Marcar una variable como transient en Java tiene el propósito de indicar 
    que esa variable no debe ser serializada cuando se almacena un objeto de la 
    clase en un flujo de objetos, como al escribirlo en un archivo o al enviarlo 
    a través de la red. 
    Esto se utiliza para evitar que ciertos datos sensibles o datos que no sean 
    necesarios para la restauración del objeto sean almacenados.
    */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        String ruta = "/home/dam2/DAM2/AD/serializacion_1/serial.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(ruta)));
        
        // **PRIMERA PARTE**
        // escribimos el primer objeto inicializando los valores en el fichero
        MClase mClase = new MClase("ola", -7, 2.7E10);
        objectOutputStream.writeObject(mClase);
//        objectOutputStream.close(); // se comenta cd quiero ejecutar las 2 partes 
        
        // comprobamos que los valores se guardan en el obj 1
        System.out.println(mClase.toString());
        
        // **SEGUNDA PARTE**
        // leemos el primer obj y lo almacenamos en un nuevo objeto
        MClase mClase_antigua = (MClase)objectInputStream.readObject();
        objectInputStream.close();
        
        // creamos el segundo objeto y posteriormente inicializamos los atributos
        // accediendo a los atributos del obj que hemos creado cuando leimos el primer
        // objeto
        MClase mClase1 = new MClase();
        mClase1.nome = mClase_antigua.nome;
        mClase1.numero1 = mClase_antigua.numero1;
        mClase1.numero2 = mClase_antigua.numero2;
        
        // escribimos el nuevo objeto en el fichero
        objectOutputStream.writeObject(mClase1);
        objectOutputStream.close();
        
        // comprobamos que los valores se guardan en el obj 2
        System.out.println(mClase1.toString());
    }
    
}
