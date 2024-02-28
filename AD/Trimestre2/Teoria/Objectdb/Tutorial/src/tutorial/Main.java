/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tutorial;

import javax.persistence.*;
import java.util.*;

/**
 *
 * El codigo de esta clase va a almacenar los objetos de Point
 * en la database y entonces recuperarlos de la database
 * 
 * Crea un archivo ObjectDB database que guarda 1000 objetos Point
 * en la database y luego corre unas cuantas querys que devuelven
 * todos los 1000 objetos de tipo Point. Finalmente cirra la db.
 * 
 * @author postgres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "$objectdb/db/p2.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        // getSingleResult() ejecuta la query y devuelve el resultado.
        // SOLO debe ser usada cd el resultado esperado es UNO
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
        
        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        // se usa cd hay MULTIPLES resultados
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
    
}
