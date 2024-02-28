/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author postgres
 */
public class UpdateDelete {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                        "$objectdb/db/p2.odb");
        EntityManager em = emf.createEntityManager();
        
        System.out.println("-- REGISTROS ANTES MODIFICACION --");
        
        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query
                = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }
        
        // abro transaccion
        em.getTransaction().begin();
        for (Point p : results) {
            // si es mayor o igual a 100 se borra sino se modifica
            if (p.getX() >= 100) {
                em.remove(p); // delete entity
            } else {
                p.setX(p.getX() + 100); // update entity
            }
        }
        em.getTransaction().commit();

    }

}
