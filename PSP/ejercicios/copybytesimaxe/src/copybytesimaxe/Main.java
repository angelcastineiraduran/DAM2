/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copybytesimaxe;

/**
 *
 * @author dam2
 */
public class Main {
    public static void main(String[] args) {
        
        String rutaCopiar = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto.jpg";
        String rutaPegar = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto_copia.jpg";
        
        Copybytesimaxe_1 copybytesimaxe_1 = new Copybytesimaxe_1();
        /*
        if(copybytesimaxe_1.leer(rutaCopiar)){
            if(copybytesimaxe_1.escribir(rutaPegar)){
                System.out.println("**TODO CORRECTO**");
            }
        }
        */
        
        copybytesimaxe_1.leer_v2(rutaCopiar);
        copybytesimaxe_1.escribir_v2(rutaPegar);
    }
}
