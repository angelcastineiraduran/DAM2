/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinopobjectdb;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author postgres
 */
public class Evinopobjectdb {

    public static void main(String[] args) {
        
        Metodos m = new Metodos();
        m.openConnection("/home/ubuntu/DAM2/AD/Trimestre2/Ejercicios/3_evinopobjectdb/evinopobjectdb/src/evinopobjectdb/traballos.odb");
        m.getAnalisis();
        m.closeConnection();
                
    }
}
