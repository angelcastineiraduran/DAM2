/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xml_proba_0_leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        
        String ruta = "/home/dam2/DAM2/AD/xml_proba_0/prueba.xml";
        FileReader fr = new FileReader(new File(ruta));
        
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(fr);
        
        int tipoEvento;
        
        while(xmlsr.hasNext()){
            
            tipoEvento = xmlsr.next();
            String nombreElemento;
            String nombreAtributo;
            String nombreContenido;
            
            if(tipoEvento == XMLStreamConstants.START_ELEMENT) {
                nombreElemento = xmlsr.getLocalName();
                
                if(nombreElemento.equals("autor")) {
                    System.out.println(nombreElemento + "\t");
                    
                    nombreAtributo = xmlsr.getAttributeValue(0);
                    System.out.println("\t" + nombreAtributo);
                    
                } else if(nombreElemento.equals("nombre")) {
                    System.out.println("\t" + nombreElemento);
                    
                    nombreContenido = xmlsr.getElementText();
                    System.out.println("\t\t" + nombreContenido);
                } else if(nombreElemento.equals("titulo")) {
                    System.out.println("\t" +nombreElemento);
                    
                    nombreContenido = xmlsr.getElementText();
                    System.out.println("\t\t" +nombreContenido);
                    
                }
            }
        }
        
        
    }
    
}
