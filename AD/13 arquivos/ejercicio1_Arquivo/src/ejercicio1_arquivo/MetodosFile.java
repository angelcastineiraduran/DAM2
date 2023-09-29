/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_arquivo;

import java.io.*;
import java.lang.System.Logger;
import java.lang.System.*;
import java.lang.System.Logger.Level;
import java.util.*;

/**
 *
 * @author postgres
 */
public class MetodosFile {

    String mensaje;
    //File file = new File("/home/postgres/Escritorio");
    File file;

    // EJERCICIO 1
    public String eDirectorio(String ruta) {
        file = new File(ruta);
        if (file.isDirectory() == true) {
            mensaje = "e un directorio";
        } else {
            mensaje = "non e un directorio";
        }
        return mensaje;
    }
    boolean existe;
    // EJERCICIO 2
    public boolean eFichero(String ruta) {
        file = new File(ruta);
        if (file.isFile() == true) {
            mensaje = "e un ficheiro";
            existe = true;
        } else {
            mensaje = "non e un ficheiro";
            existe = false;
        }
        System.out.println(mensaje);
        return existe;
    }

    // EJERCICIO 3
    public String crearDirectorio(String ruta) {
        file = new File(ruta);
        if (file.mkdir()) {
            mensaje = "se a podido crear el directorio " + ruta;
        } else {
            mensaje = "no se ha podido crear el directorio " + ruta;
        }
        return mensaje;

    }

    // EJERCICIO 4

    public boolean creaFicheiro(String dirName, String fileName) {
        String ruta = dirName + "/" + fileName;
        file = new File(ruta);
        try {
            if (file.createNewFile()) {
                mensaje = "se a podido crear el directorio " + ruta;
                existe = true;
            } else {
                mensaje = "no se ha podido crear el directorio " + ruta;
                existe = false;
            }
            System.out.println(mensaje);
        } catch (IOException ex) {
            //Logger.getLoggE_directorio.class.getName()).log(Level.SEVERE, null, ex);
            existe = false;
        }
        return existe;
    }

    // EJERCICIO 5
    public boolean modoAcceso(String dirName, String fileName) {
        String ruta = dirName + "/" + fileName;
        file = new File(ruta);
        if (file.canRead()) {
            mensaje = "tiene permiso a escribir";
            System.out.println(mensaje);
            return true;
        } else {
            mensaje = "no tiene permisos a escribir";
            System.out.println(mensaje);
            return false;
        }

    }

    // EJERCICIO 6
    public boolean calculaLonxitude(String dirName,String fileName) {
        String ruta = dirName + "/" + fileName;
        file = new File(ruta);
        long tamanio;
        if(eFichero(ruta)){
            tamanio = file.length();
            mensaje = "el tamanio del archivo es: " + tamanio;
            existe = true;
        } else {
            existe = false;
        }
        System.out.println(mensaje);
        return existe;
    }
    
    // EJERCICIO 7
    public void mLectura(String dirName,String fileName){
        String ruta = dirName + "/" + fileName;
        file = new File(ruta);
        boolean lejible;
        lejible = file.canRead();
        System.out.println("lejible = " + lejible);
        lejible = file.setReadable(true);
        System.out.println("lejible = " + lejible);
        lejible = file.canRead();
        System.out.println("lejible = " + lejible);
    }
    
    // EJERCICIO 8
    
    // EJERCICIO 9
    public void borraFicheiro(String dirName, String fileName){
        String ruta = dirName + "/" + fileName;
        file = new File(ruta);
        if(file.delete()){
            System.out.println("archivo eliminado");
        } else {
            System.out.println("no encontrado");
        }
    }
    
    // EJERCICIO 10
    
    // EJERCICIO 11
    public void mContenido(String dirName){
        file = new File(dirName);
        String array[] = file.list();
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        
        
    }
    
    
    


}
