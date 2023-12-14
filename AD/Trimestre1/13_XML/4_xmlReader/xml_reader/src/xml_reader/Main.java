/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author dam2
 */
public class Main {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        String ruta = "/home/dam2/DAM2/AD/xml_writer/products.xml";
        FileReader fr = new FileReader(new File(ruta));

        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(fr);

        int tipoEvento;

        while (xmlsr.hasNext()) {
            tipoEvento = xmlsr.next();

            if (tipoEvento == XMLStreamConstants.START_ELEMENT) {
                String nombreElemento = xmlsr.getLocalName();

                if (nombreElemento.equals("Product")) {
                    while (xmlsr.hasNext()) {
                        int eventType = xmlsr.next();

                        if (eventType == XMLStreamConstants.START_ELEMENT) {
                            String nombreElementoHijo = xmlsr.getLocalName();
                            String contenido = xmlsr.getElementText();

                            System.out.println(nombreElementoHijo + ": " + contenido);
                        } else if (eventType == XMLStreamConstants.END_ELEMENT && xmlsr.getLocalName().equals("Product")) {
                            break; // Sale del bucle al finalizar el elemento Product
                        }
                    }
                }

            }
        }
    }
}
