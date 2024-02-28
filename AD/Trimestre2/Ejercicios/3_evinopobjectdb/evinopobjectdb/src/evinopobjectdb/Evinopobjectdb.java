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
     
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory(
                    "$objectdb/db/traballos.odb");
    
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for(int i = 0; i < 1000; i++) {
            
        }
    }
    
}
