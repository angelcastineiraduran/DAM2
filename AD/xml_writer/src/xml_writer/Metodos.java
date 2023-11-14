/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import serializacion_2.Product;

/**
 *
 * @author dam2
 */
public class Metodos {
    String ruta_serializacion = "/home/dam2/DAM2/AD/serializacion_2/serial.txt";
    String ruta_xml = "/home/dam2/DAM2/AD/xml_writer/products.xml";
    
    
    public void escribir_xml() throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException {
        // --LEEMOS EN SERIALIZADO--
        // abro flujo para leer el txt serializado
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta_serializacion)));
        // contendrá todos los obj de tipo Product leidos
        ArrayList<Product> productos = new ArrayList();
        // leo el txt serializado
        Product productLeidos;
        while ((productLeidos = (Product) ois.readObject()) != null) {
            //System.out.println(productLeidos.toString()); // compruebo que se leen los productos por consola
            productos.add(productLeidos); // aniado los obj al arreglo de Product
        }
        // cierro flujo serializado
        ois.close();
        
        // --ESCRIBIMOS EN XML--
        // abrimos flujo XML
        FileWriter fw = new FileWriter(new File(ruta_xml));
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlsw = xmlof.createXMLStreamWriter(fw);
        // empezamos escritura
        xmlsw.writeStartDocument("1.0");
        xmlsw.writeCharacters("\n");      
        xmlsw.writeStartElement("products");
        xmlsw.writeCharacters("\n");
        // escribimos obj en el xml
        int i = 0; // contador de productos
        for(Product elemento : productos){
            System.out.println("Escribiendo producto: " + i);
            xmlsw.writeStartElement("Product");
            xmlsw.writeStartElement("codigo");
            xmlsw.writeCharacters(elemento.getCodigo());
            xmlsw.writeEndElement();
            xmlsw.writeStartElement("descricion");
            xmlsw.writeCharacters(elemento.getDescripcion());
            xmlsw.writeEndElement();
            xmlsw.writeStartElement("precio");
            xmlsw.writeCharacters(elemento.getPrecio().toString());
            xmlsw.writeEndElement();
            xmlsw.writeEndElement();
            xmlsw.writeCharacters("\n");
            i++;
        }
        xmlsw.writeEndDocument();
        // cerramos flujo xml
        xmlsw.close();
        fw.close(); 
        
    }
    
}
