/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg29_textodelimitado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos","tachas"};
        int[] prezo ={3,4,5};
        
        String ruta = "/home/dam2/DAM2/AD/29_textoDelimitado/texto1.txt";
        
        // ESCRIBIMOS
        PrintWriter printWriter = new PrintWriter(new File(ruta));
        
        String registros[] = new String[3];
        
        for(String elemento : cod){
            registros[0] += (elemento + '\t');
        } 
        for(String elemento : desc){
            registros[1] += (elemento + '\t');
        }
        for(int elemento : prezo){
            registros[2] += (elemento + '\t');
        }
        
        for(String regristo : registros){
            printWriter.println(regristo);
        }
        printWriter.close();
        
        
    }
    
}
