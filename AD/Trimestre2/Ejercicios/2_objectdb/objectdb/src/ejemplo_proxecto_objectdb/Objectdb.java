/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_proxecto_objectdb;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author postgres
 */
public class Objectdb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "$objectdb/db/ejemplo1.odb");
        EntityManager em = emf.createEntityManager();

        // 1) ALMACENAR 10 PTOS NA BASE
        em.getTransaction().begin();
        for (int i = 0; i < 10; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
        
        // 2) LISTAR TODOS LOS PTOS
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        // se usa cd hay MULTIPLES resultados
        java.util.List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }
        
        // 3) AMOSAR OS ATRIBUTOS DO PTO CON ID=10
        Long idToRetrieve = 10L;
        Point pointToRetrieve = em.find(Point.class, idToRetrieve);
        
        if(pointToRetrieve != null){
            System.out.println("\nAtributos del punto con id=10");
            System.out.println("X: " + pointToRetrieve.getX());
            System.out.println("X: " + pointToRetrieve.getY());
        } else {
            System.out.println("\nNo se encontró ningun pto con id=10");
        }
        
        // 4) ACTUALIZAR EL Y=+2 EN ID=10
        em.getTransaction().begin();
        if(pointToRetrieve != null) {
            System.out.println("\nY del id=10 actualizado");
            System.out.println("Antes: " + pointToRetrieve.getY());
            pointToRetrieve.setY(pointToRetrieve.getY() + 2);
            System.out.println("Despues: " + pointToRetrieve.getY());
        } else {
            System.out.println("\nNo se encontró ningun pto con id=10");
        }
        em.getTransaction().commit();
        
        // 5) ELIMIMAR PTO=5
        Long idToDelete = 5L;
        Point pointToDelete = em.find(Point.class, idToDelete);
        
        em.getTransaction().begin();
        if(pointToDelete != null) {
            System.out.println("\nEl id=5 eliminado");
            em.remove(pointToDelete);
        } else {
            System.out.println("\nNo se encontró ningun pto con id=5");
        }
        em.getTransaction().commit();
        
        // 6) ACTUALIZACION MASIVA SELECTIVA
        // Primer listo resultados
        List<Point> results2 = query.getResultList();
        em.getTransaction().begin();
        for (Point p : results2) {
            // si es mayor o igual a 100 se borra sino se modifica
            if (p.getY() < 6) {
                p.setY(1000);
            }
        }
        em.getTransaction().commit();
        
        // 7) BORRADO MASIVO
        List<Point> results3 = query.getResultList();
        em.getTransaction().begin();
        for (Point p : results3) {
            // si es mayor o igual a 100 se borra sino se modifica
            if (p.getY() < 10) {
                em.remove(p);
            }
        }
        em.getTransaction().commit();
        
                
        // Close the database connection:
        em.close();
        emf.close();
        
        
    }
    
}
