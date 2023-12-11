/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exa15brevepxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import exa15brevep.*;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException, XMLStreamException {
        Comunes comunes = new Comunes();
        DatosSerializados ds = new DatosSerializados();
        ArrayList<String> datosSerializados_p1 = ds.leerPorCodigo("p1");
        ArrayList<String> datosSerializados_p2 = ds.leerPorCodigo("p2");
        String codp_p1 = datosSerializados_p1.get(0);
        String descripcion_p1 = datosSerializados_p1.get(1);
        String codp_p2 = datosSerializados_p2.get(0);
        String descripcion_p2 = datosSerializados_p2.get(1);

        Consultas consultas = new Consultas();

        // --BUSCO PESOS (codp)--
        // p1
        ArrayList<String> pesos_p1 = consultas.buscarRegistrosPorCodigo("peso", "codp", codp_p1, "composicion");
        //comunes.iterarArray(pesos_p1);
        Double peso1_codp1 = Double.parseDouble(pesos_p1.get(0));
        Double peso2_codp1 = Double.parseDouble(pesos_p1.get(1));
        Double totalPesos_codp1 = peso1_codp1 + peso2_codp1;
        // p2
        ArrayList<String> pesos_p2 = consultas.buscarRegistrosPorCodigo("peso", "codp", codp_p2, "composicion");
        //comunes.iterarArray(pesos_p2);
        Double peso1_codp2 = Double.parseDouble(pesos_p2.get(0));
        Double peso2_codp2 = Double.parseDouble(pesos_p2.get(1));
        Double peso3_codp2 = Double.parseDouble(pesos_p2.get(2));
        Double totalPesos_codp2 = peso1_codp2 + peso2_codp2 + peso3_codp2;

        // --BUSCO CODC--
        // p1
        ArrayList<String> conjunto_codc_p1 = consultas.buscarRegistrosPorCodigo("codc", "codp", codp_p1, "composicion");
        //comunes.iterarArray(conjunto_codc_p1);
        String codc1_p1 = conjunto_codc_p1.get(0);
        String codc2_p1 = conjunto_codc_p1.get(1);
        // p2
        ArrayList<String> conjunto_codc_p2 = consultas.buscarRegistrosPorCodigo("codc", "codp", codp_p2, "composicion");
        //comunes.iterarArray(conjunto_codc_p2);
        String codc1_p2 = conjunto_codc_p2.get(0);
        String codc2_p2 = conjunto_codc_p2.get(1);
        String codc3_p2 = conjunto_codc_p2.get(2);

        // --BUSCO GRAXA--
        // busco graxa por codigo en la tabla componentes
        // p1
        ArrayList<String> graxas_codc1_p1 = consultas.buscarRegistrosPorCodigo("graxa", "codc", codc1_p1, "componentes");
        Double graxa_codc1_p1 = Double.parseDouble(graxas_codc1_p1.get(0));
        Double graxa_parcial_codc1_p1 = comunes.calcularGraxaParcial(peso1_codp1, graxa_codc1_p1);
        ArrayList<String> graxas_codc2_p1 = consultas.buscarRegistrosPorCodigo("graxa", "codc", codc2_p1, "componentes");
        Double graxa_codc2_p1 = Double.parseDouble(graxas_codc2_p1.get(0));
        Double graxa_parcial_codc2_p1 = comunes.calcularGraxaParcial(peso2_codp1, graxa_codc2_p1);

        // p2
        ArrayList<String> graxas_codc1_p2 = consultas.buscarRegistrosPorCodigo("graxa", "codc", codc1_p2, "componentes");
        Double graxa_codc1_p2 = Double.parseDouble(graxas_codc1_p2.get(0));
        Double graxa_parcial_codc1_p2 = comunes.calcularGraxaParcial(peso1_codp2, graxa_codc1_p2);
        ArrayList<String> graxas_codc2_p2 = consultas.buscarRegistrosPorCodigo("graxa", "codc", codc2_p2, "componentes");
        Double graxa_codc2_p2 = Double.parseDouble(graxas_codc2_p2.get(0));
        Double graxa_parcial_codc2_p2 = comunes.calcularGraxaParcial(peso2_codp2, graxa_codc2_p2);
        ArrayList<String> graxas_codc3_p2 = consultas.buscarRegistrosPorCodigo("graxa", "codc", codc3_p2, "componentes");
        Double graxa_codc3_p2 = Double.parseDouble(graxas_codc3_p2.get(0));
        Double graxa_parcial_codc3_p2 = comunes.calcularGraxaParcial(peso3_codp2, graxa_codc3_p2);
        
        // --CONCLUSION--
        System.out.println("***CONCLUSION***");
        System.out.println(codp_p1);
        System.out.println(descripcion_p1);
        Double graxaTotal_p1 = graxa_parcial_codc1_p1 + graxa_parcial_codc2_p1;
        System.out.println("graxaTotal = " + graxaTotal_p1);

        System.out.println("");

        System.out.println(codp_p2);
        System.out.println(descripcion_p2);
        Double graxaTotal_p2 = graxa_parcial_codc1_p2 + graxa_parcial_codc2_p2 + graxa_parcial_codc3_p2;
        System.out.println("graxaTotal = " + graxaTotal_p2);
        
        System.out.println("--EJERCICIO 2 (XML)--");
        
        // ruta del de clase:
        //String ruta_xml = "/home/dam2/DAM2/AD/ejercicios_examen/exa15brevepXML/platos.xml"; 
        // ruta casa
        String ruta_xml = "/home/ubuntu/DAM2/AD/ejercicios_examen/exa15brevepXML/platos.xml";
        
        /*
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
        */
        
        // datos que quiero guardar en un arreglo para escribirlos:
        // codp, descripcion, graxa parcial, graxa total
        
        ArrayList <String> producto1 = new ArrayList();
        producto1.add(codp_p1);
        producto1.add(descripcion_p1);
        producto1.add(graxaTotal_p1.toString());
        
        ArrayList <String> producto2 = new ArrayList();
        producto2.add(codp_p2);
        producto2.add(descripcion_p2);
        producto2.add(graxaTotal_p2.toString());
        
        ArrayList<ArrayList> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        

        // --ESCRIBIMOS EN XML--
        // abrimos flujo XML
        FileWriter fw = new FileWriter(new File(ruta_xml));
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlsw = xmlof.createXMLStreamWriter(fw);
        // empezamos escritura
        xmlsw.writeStartDocument("1.0");
        xmlsw.writeCharacters("\n");
        xmlsw.writeStartElement("Platos");
        xmlsw.writeCharacters("\n");
        // escribimos obj en el xml
        
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Escribiendo producto: " + i);
            ArrayList pro = productos.get(i);
            for(int j = 0; j < 3; j++) {
                System.out.println("Producto " + j + ": " + pro.get(j));
            }
            
            xmlsw.writeStartElement("Plato");
            xmlsw.writeAttribute("Codigop", (String) productos.get(i).get(0));
            
            xmlsw.writeStartElement("nomep");
            xmlsw.writeCharacters((String) productos.get(i).get(1));
            xmlsw.writeEndElement();
            
            xmlsw.writeStartElement("graxatotal");
            xmlsw.writeCharacters((String) productos.get(i).get(2));
            xmlsw.writeEndElement();
            
            xmlsw.writeEndElement();
            xmlsw.writeCharacters("\n");
      
        }
        
        xmlsw.writeEndDocument();
        // cerramos flujo xml
        xmlsw.close();
        fw.close();
        

    }

}
