/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_arquivo;




/**
 *
 * @author postgres
 */
public class Test {

    public static void main(String[] args) {
        MetodosFile e_directorio = new MetodosFile();
        String ruta;
        String mensaje;
        
        // EJERCICIO 1
        ruta = "/home/postgres/Escritorio";
        mensaje = e_directorio.eDirectorio(ruta);
        System.out.println(mensaje);
        
        //EJERCICIO 2
        ruta = "/home/postgres/Escritorio";
        //mensaje = e_directorio.eFichero(ruta);
        System.out.println(mensaje);
        
        // EJERCICIO 3
        ruta = "/home/postgres/Escritorio/directorio_v1";
        mensaje = e_directorio.crearDirectorio(ruta);
        System.out.println(mensaje);
        
        // EJERCICIO 4
        boolean existe;
        String nombreFichero = "fichero_v1w";
        existe = e_directorio.creaFicheiro(ruta, nombreFichero);
        
        // EJERCICIO 5
        existe = e_directorio.modoAcceso(ruta,nombreFichero);
        
        // EJERCICIO 6
        existe = e_directorio.calculaLonxitude(ruta, nombreFichero);
        
        // EJERCICIO 7
        e_directorio.mLectura(ruta, nombreFichero);
        
        // EJERCICIO 8 - igual que 7
        
        // EJERCICIO 9
        e_directorio.borraFicheiro(ruta, nombreFichero);
        
        // EJERCICIO 10 - igual que 8
        
        // EJERCICIO 11
        ruta = "/home/postgres/Escritorio/directorio_v1";
        e_directorio.mContenido(ruta);
        
        
        
        
        
        
    }

}
