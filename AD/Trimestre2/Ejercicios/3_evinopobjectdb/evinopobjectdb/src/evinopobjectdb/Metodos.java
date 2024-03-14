/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinopobjectdb;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author ubuntu
 */
public class Metodos {
    
    String coda, nomeu, trataAcidez, tipoUva, dni;
    int acidezMax, acidezMin, total, acidez, cantidade, numeroDeAnalisis;
    
    private EntityManager em;
    // "/home/ubuntu/DAM2/AD/Trimestre2/Ejercicios/3_evinopobjectdb/evinopobjectdb/src/evinopobjectdb/traballos.odb"
    
    public EntityManager openConnection(String ubicacionDB) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory(ubicacionDB);
        em = emf.createEntityManager();
        if(em!=null) {
            System.out.println("--- Conexion con db exitosa ---");
        } else {
            System.out.println("**ERROR conecion db**");
        }
        return em;
    }
    
    public void closeConnection() {
        em.clear();
        em.clear();
        System.out.println("--- Cerrando conexion ---");
    }
    
    public void getAnalisis() {
        TypedQuery<Analisis> query = em.createQuery("SELECT a FROM Analisis a", Analisis.class);
        List<Analisis> results = query.getResultList();
        
        for(Analisis a: results) {
            coda = a.getCoda();
            acidez = a.getAcidez();
            tipoUva = a.getTipouva();
            cantidade = a.getCantidade();
            dni = a.getDni();
            getUvas(tipoUva);
            if(acidez < acidezMin) {
                trataAcidez = "subir acidez";
            } else if(acidez > acidezMax) {
                trataAcidez = "baixar acidez";
            } else {
                trataAcidez = "equilibrada";
            }
            total = cantidade * 15;
            
            //insertXerado();
            //updateClientes(dni);
            
            System.out.println(coda + ", " + nomeu + ", " + trataAcidez + ", " + total);
            System.out.println("");
        }

    }

    public void getUvas(String codu) {
        // "SELECT c FROM Clientes c WHERE dni=dni"
        TypedQuery<Uvas> query = em.createQuery("SELECT u FROM Uvas u WHERE u.codu = :codu", Uvas.class);
        // (nombreparam, valorparam)
        query.setParameter("codu", codu);
        // SOLO voy a recoger un objeto, aquel que tenga codu=tipouva
        Uvas u = query.getSingleResult();
        nomeu = u.getNomeu();
        acidezMin = u.getAcidezmin();
        acidezMax = u.getAcidezmax();
    }
    
    public void updateClientes(String dni) {
        // "SELECT c FROM Clientes c WHERE dni=dni"
        TypedQuery<Clientes> query = em.createQuery("SELECT c FROM Clientes c WHERE c.dni = :dni", Clientes.class);
        // (nombreparam, valorparam)
        query.setParameter("dni", dni);
        Clientes c = query.getSingleResult();
        
        em.getTransaction().begin();
        numeroDeAnalisis = c.getNumerodeanalisis();
        c.setNumerodeanalisis(numeroDeAnalisis + 1);
        em.getTransaction().commit();
        
        System.out.println("CLIENTE ACTUALIZADO");
    }
    
    public void insertXerado() {
        em.getTransaction().begin();
        Xerado x = new Xerado(coda, nomeu, trataAcidez, total);
        em.persist(x);
        em.getTransaction().commit();
        
        System.out.println("INSERCION REALIZADA");
    }
    
}
