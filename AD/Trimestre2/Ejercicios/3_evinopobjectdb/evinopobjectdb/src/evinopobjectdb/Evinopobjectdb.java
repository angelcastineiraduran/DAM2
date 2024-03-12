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

        String MSJ_CALCULANDO = "\n****CALCULANDO RESULTADO....*****";

        // creamos una nueva base si no existe
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                        // guardamos db en esta ubica
                        // (/home/ubuntu/DAM2/AD/Trimestre2/Drivers/objectdb-2.8.9/db/traballos.odb)
                        //"$objectdb/db/traballos.odb");
                        "/home/ubuntu/DAM2/AD/Trimestre2/Ejercicios/3_evinopobjectdb/evinopobjectdb/src/evinopobjectdb/traballos.odb");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // -- APARTADO A --
        System.out.println(msj_apartado("A"));

        // 1. coda - Analisis
        System.out.println(msj_num_apartados(1, "coda", "Analisis"));
        ArrayList<String> codas = new ArrayList<>();
        ArrayList<String> tipodeuvas = new ArrayList<>();
        ArrayList<Integer> acidezs = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<String> dnis = new ArrayList<>();

        // recopilo todos lo obj Uva que hay en la bd
        TypedQuery<Analisis> queryanalisis
                = em.createQuery("SELECT a FROM Analisis a", Analisis.class);
        List<Analisis> resultsanalisis = queryanalisis.getResultList();

        for (Analisis a : resultsanalisis) {
            System.out.println(a);
            codas.add(a.getCoda());
            tipodeuvas.add(a.getTipouva());
            acidezs.add(a.getAcidez());
            cantidades.add(a.getCantidade());
            dnis.add(a.getDni());
        }

        System.out.println("codas = " + codas);
        System.out.println("tipodeuvas = " + tipodeuvas);
        System.out.println("acidezs = " + acidezs);
        System.out.println("cantidades = " + cantidades);

        // 2. nomeu - Uvas
        System.out.println(msj_num_apartados(2, "nomeu", "Uvas"));

        ArrayList<String> nomeus = new ArrayList<>();
        ArrayList<Integer> acidezmins = new ArrayList<>();
        ArrayList<Integer> acidezmaxs = new ArrayList<>();

        TypedQuery<Uvas> queryuvas
                = em.createQuery("SELECT u FROM Uvas u", Uvas.class);
        List<Uvas> resultsuvas = queryuvas.getResultList();

        for (String tipodeuva : tipodeuvas) {
            for (Uvas u : resultsuvas) {
                System.out.println(u);
                String codeu = u.getCodu();
                if (tipodeuva.equals(codeu)) {
                    System.out.println(tipodeuva + "==" + codeu);
                    nomeus.add(u.getNomeu());
                    acidezmins.add(u.getAcidezmin());
                    acidezmaxs.add(u.getAcidezmax());
                }
            }
        }

        System.out.println("nomeus = " + nomeus);
        System.out.println("acidezmins = " + acidezmins);
        System.out.println("acidezmaxs = " + acidezmaxs);

        // 3. tratacidez
        System.out.println(msj_num_apartados(3, "tratacidez", "X"));

        ArrayList<String> tratacidezs = new ArrayList<>();

        for (int i = 0; i < acidezs.size(); i++) {
            if (acidezs.get(i) < acidezmins.get(i)) {
                tratacidezs.add("subir acidez");
            } else if (acidezs.get(i) > acidezmaxs.get(i)) {
                tratacidezs.add("baixar acidez");
            } else {
                tratacidezs.add("acidez correcta");
            }
        }

        System.out.println("tratacidezs = " + tratacidezs);

        // 4. total
        System.out.println(msj_num_apartados(4, "total", "X"));

        ArrayList<Integer> totals = new ArrayList<>();

        for (Integer cantidade : cantidades) {
            Integer total = cantidade * 15;
            totals.add(total);
        }

        System.out.println("totals = " + totals);

        // 5. Insercion de datos en la tabla
//        
//        System.out.println(MSJ_CALCULANDO);
//        int elementoInserir = codas.size();
//        for (int i = 0; i < elementoInserir; i++) {
//            Xerado x = new Xerado(codas.get(i), nomeus.get(i), tratacidezs.get(i), totals.get(i));
//            em.persist(x);
//        }
//        em.getTransaction().commit();

        // ---- APARTADO B ----
        System.out.println(msj_apartado("B"));

        ArrayList<Integer> numeroanalisiss = new ArrayList<>();

        TypedQuery<Clientes> queryclientes
                = em.createQuery("SELECT c FROM Clientes c", Clientes.class);
        List<Clientes> resultsclientes = queryclientes.getResultList();
        
        for (Clientes c : resultsclientes) {
            for(String dni: dnis) {
                if (c.getDni().equals(dni)) {
                    System.out.println("Se actualiza numerodeanalisis del cliente = " + c.getDni());
                    c.setNumerodeanalisis(c.getNumerodeanalisis() + 1);
                }
            }
        }
        em.getTransaction().commit();

    }

    public static String msj_num_apartados(int numero, String cod, String clase) {
        return "\n------------ " + numero + ") " + cod + " // " + clase + " ------------";
    }

    public static String msj_apartado(String apartado) {
        return "\n@@@@@@@@@@@@ APARTADO-" + apartado + " @@@@@@@@@@@@@@@";
    }

}
