/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdietaenfermidade;

import javax.persistence.*;
import java.util.*;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Examen {

    public static void main(String[] args) {

        // ------ EJERCICIO 1 ------
        System.out.println(newEjercicio(1));

        // 1. _id - Persoas
        System.out.println(txtNewSearch("_id", "Persoas", 1));

        ArrayList<String> _idsP = new ArrayList<>();
        ArrayList<String> enfermidades = new ArrayList<>();

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection<Document> collPersoas = database.getCollection("persoas");
        FindIterable<Document> preResultPersoas = collPersoas.find();

        for (Document document : preResultPersoas) {
            System.out.println(document.toJson());
            enfermidades.add(document.getString("enfermidade"));
            _idsP.add(document.getString("_id"));
        }

        System.out.println(_idsP);

        // 2. enfermidade - Persoas
        System.out.println(txtNewSearch("enfermidade", "Persoas", 2));
        System.out.println(enfermidades);

        // ------ EJERCICIO 2 -------
        System.out.println(newEjercicio(2));

        // 1. _id - Enfermidades
        System.out.println(txtNewSearch("_id", "Enfermidades", 1));

        ArrayList<String> _idsE = new ArrayList<>();
        // Selecciono los _ids que YO quiero de la tabla enfermidades (F=final)
        ArrayList<String> _idsEF = new ArrayList<>();
        ArrayList<Double> maxcolesterolsemanals = new ArrayList<>();
        ArrayList<Double> maxcolesterolsemanalsF = new ArrayList<>();

        MongoCollection<Document> collEnfermidades = database.getCollection("enfermidades");
        FindIterable<Document> preResultEnfermidades = collEnfermidades.find();

        for (Document document : preResultEnfermidades) {
            System.out.println(document.toJson());
            _idsE.add(document.getString("_id"));
            maxcolesterolsemanals.add(document.getDouble("maxcolesterolsemanal"));
        }

        System.out.println("_idsE = " + _idsE);

        for (String enfermidade : enfermidades) {
            for (int i = 0; i < _idsE.size(); i++) {
                if (enfermidade.equals(_idsE.get(i))) {
                    _idsEF.add(_idsE.get(i));
                    maxcolesterolsemanalsF.add(maxcolesterolsemanals.get(i));
                }
            }
        }

        System.out.println("_idsEF = " + _idsEF);

        // 2. maxcolesterolsemanal - Enfermidades
        System.out.println(txtNewSearch("maxcolesterolsmenal", "Enfermidades", 2));
        System.out.println("maxcolesterolsemanalsF = " + maxcolesterolsemanalsF);

        // ----- EJERCICIO 3 -----
        System.out.println(newEjercicio(3));

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                        "/media/sf_AD/Trimestre2/Examen/examen/src/pdietaenfermidade/concar.odb");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 1. gramos - Consumo
        System.out.println(txtNewSearch("gramos,tipocarne", "Consumo", 1));

        //ArrayList<Integer> gramoss = new ArrayList<>();
        ArrayList<ArrayList<Integer>> gramossF = new ArrayList<>();
        ArrayList<ArrayList<String>> tipocarnesF = new ArrayList<>();

        TypedQuery<Consumo> queryconsumo
                = em.createQuery("SELECT c FROM Consumo c", Consumo.class);
        List<Consumo> resultsconsumo = queryconsumo.getResultList();

        for (String _idP : _idsP) {
            ArrayList<Integer> gramoss = new ArrayList<>();
            ArrayList<String> tipocarnes = new ArrayList<>();
            System.out.println("Dni=" + _idP);
            for (Consumo c : resultsconsumo) {
                if (c.getDni().equals(_idP)) {
                    gramoss.add(c.getGramos());
                    tipocarnes.add(c.getTipocarne());
                    System.out.println(c);
                }
            }
            gramossF.add(gramoss);
            tipocarnesF.add(tipocarnes);
        }

        System.out.println(gramossF);
        System.out.println(tipocarnesF);

        // ------- EJERCICIO 4 ------
        System.out.println(newEjercicio(4));
        System.out.println(txtNewSearch("colesterol", "Carne", 1));

        ArrayList<ArrayList<Double>> colesterolsF = new ArrayList<>();

        TypedQuery<Carne> querycarne
                = em.createQuery("SELECT a FROM Carne a", Carne.class);
        List<Carne> resultscarne = querycarne.getResultList();

        
        for (ArrayList<String> tiposcarneF : tipocarnesF) {
            ArrayList<Double> colesterols = new ArrayList<>();
            for (String tipocarneF2 : tiposcarneF) {
                for (Carne a : resultscarne) {
                    if (tipocarneF2.equals(a.getNome())) {
                        System.out.print(a.getColesterol());
                        colesterols.add(a.getColesterol());
                    }
                }
                System.out.print(", ");
            }
            colesterolsF.add(colesterols);
            System.out.println("");
        }
        
        System.out.println("colesterolsF = " + colesterolsF);

        em.close();
        emf.close();
        
        
        // ----- EJERCICIO 5 ---
        System.out.println(newEjercicio(5));
        
        ArrayList<Float> totalParcialTipoCarne = new ArrayList<>();
        
        for(int i = 0; i < _idsP.size(); i++) {
            System.out.println(_idsP.get(i));
            System.out.println(enfermidades.get(i));
            System.out.println(maxcolesterolsemanalsF.get(i));
            System.out.println(_idsE.get(i));
            System.out.println("");
            
        }
       

    }

    public static String txtNewSearch(String cod, String bd, int num) {
        return "\n-------- " + num + ") " + cod + " // " + bd + " --------";
    }

    public static String newEjercicio(int numEjercicio) {
        return "\n@@@@@@@@@@@@@@ EJERCICIO " + numEjercicio + " @@@@@@@@@@";
    }

    public static String resultadoString(ArrayList<String> array) {
        return "\n--> RESULTADO: " + array;
    }

    public static String resultadoInt(ArrayList<Integer> array) {
        return "\n--> RESULTADO: " + array;
    }

}
