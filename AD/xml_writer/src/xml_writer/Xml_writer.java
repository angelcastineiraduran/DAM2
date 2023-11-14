/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package xml_writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import serializacion_2.Product;
import serializacion_2.Serializacion_2;

/**
 *
 * @author dam2
 */
public class Xml_writer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, XMLStreamException {
        
        Metodos metodos = new Metodos();
        metodos.escribir_xml();
    }
    
}
