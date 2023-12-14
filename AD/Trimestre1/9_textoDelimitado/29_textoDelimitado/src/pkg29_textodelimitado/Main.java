/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg29_textodelimitado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos","tachas"};
        int[] prezo ={3,4,5};
        
        String ruta = "/home/dam2/DAM2/AD/29_textoDelimitado/texto1.txt";
        
        // ESCRIBIMOS
        PrintWriter printWriter = new PrintWriter(new File(ruta));
        
        String registros[][] = new String[3][3];

        for(int i = 0; i < registros.length; i++){
            for(int j = 0; j < registros[i].length; j++){
                switch(i){
                    case 0:
                        registros[i][j] = cod[j];
                        printWriter.print(registros[i][j] + '\t');
                        break;
                    case 1:
                        registros[i][j] = desc[j];
                        printWriter.print(registros[i][j] + '\t');
                        break;
                    case 2:
                        registros[i][j] = String.valueOf(prezo[j]);
                        printWriter.print(registros[i][j] + '\t');
                        break;
                }
            }
            printWriter.println();
            
        }
        
        printWriter.close();
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ruta)));
        String linea;
        String[] campo1 = bufferedReader.readLine().split(String.valueOf('\t'));
        String[] campo2 = bufferedReader.readLine().split(String.valueOf('\t'));
        String[] campo3 = bufferedReader.readLine().split(String.valueOf('\t'));
        
        for(int i = 0; i < campo1.length; i++){
            System.out.println("Codigo:        " +  campo1[i]);
            System.out.println("Descricion:    " +  campo2[i]);
            System.out.println("Prezo:         " +  Double.parseDouble(campo3[i]) + "€");
        }
    }
    
    
}