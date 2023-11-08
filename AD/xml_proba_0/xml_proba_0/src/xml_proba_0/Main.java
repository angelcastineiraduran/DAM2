/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xml_proba_0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XMLStreamException, IOException {
        // creo fich de donde se va a leer/escribir
        String ruta = "/home/dam2/DAM2/AD/xml_proba_0/prueba.xml";
        FileWriter fw = new FileWriter(new File(ruta));
        
        // creo un objeto XMLOutputFactory a partir del metodo newInstance() de la clase XMLOutputFactory
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        
        // creo un obj XMLStreamWriter a partir del metodo createXMLStreamWriter de la clase xmlof
        // el param corresponde a un fich que quiero leer/escribir
        XMLStreamWriter xmlsw = xmlof.createXMLStreamWriter(fw);
        
        // escribe a declaracion XML con a Version especificada
        xmlsw.writeStartDocument("1.0");
        xmlsw.writeCharacters("\n");
        
        // escribe o tag de inicio de un elemento
        xmlsw.writeStartElement("autores");
        xmlsw.writeCharacters("\n");
        
        xmlsw.writeStartElement("autor");
        xmlsw.writeAttribute("codigo", "a1");
        xmlsw.writeCharacters("\n");
        xmlsw.writeStartElement("nombre");
        xmlsw.writeCharacters("Alexandre Dumas");
        xmlsw.writeEndElement();
        
        xmlsw.writeCharacters("\n");
        xmlsw.writeStartElement("titulo");
        xmlsw.writeCharacters("El conde de montecristo");
        xmlsw.writeEndElement();
        
        xmlsw.writeCharacters("\n");
        xmlsw.writeStartElement("titulo");
        xmlsw.writeCharacters("Los miserables");
        xmlsw.writeEndElement();
        xmlsw.writeCharacters("\n");
        xmlsw.writeEndElement();
        xmlsw.writeCharacters("\n");
        
        xmlsw.writeEndElement();
        
        // crerramos
        xmlsw.close();
        fw.close();
        
        
    }
    
}
