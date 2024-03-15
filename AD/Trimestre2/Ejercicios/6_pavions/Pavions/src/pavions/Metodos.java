/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pavions;

import javax.persistence.*;
import java.util.*;
import java.sql.*;
import com.mongodb.client.*;
import org.bson.*;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 *
 * @author ubuntu
 */
public class Metodos {
    
    private int codr, idVooIda, idVooVolta, prezo, prezoIda, prezoVolta, prezoFinal;
    private String dni, voos, orixeIda, orixeVolta, orixe;

    //------------OPEN CONNECTIONS----------------
    // POSTGRES
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // MONGO
    private MongoClient mc = null;
    private MongoDatabase mdb = null;

    // OBJECTDB
    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public void openConnection(String objectDbRoute, String mongoDbName) {
        try {
            openPostgresConnection();
            openMongoConnection(mongoDbName);
            openObjectDBConnection(objectDbRoute);
        } catch (SQLException ex) {
            System.out.println("**ERROR en openConnection SQL**");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("**ERROR en openConnection**");
            ex.printStackTrace();
        }
        System.out.println("-----------conexion realizada-------------\n");
    }

    private void openPostgresConnection() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        conn = DriverManager.getConnection(url, usuario, password);
    }

    private void openMongoConnection(String mongoDbName) {
        mc = MongoClients.create();
        mdb = mc.getDatabase(mongoDbName);
    }

    private void openObjectDBConnection(String objectDbRoute) {
        emf = Persistence.createEntityManagerFactory(objectDbRoute);
        em = emf.createEntityManager();
    }
    
    //------------CLOSE CONNECTIONS----------------
    public void closeConnection() {
        try {
            closePostgresResources();
            closeMongoResources();
            closeObjectDBResources();
        } catch (Exception ex) {
            System.out.println("**ERROR con closeConnection**");
            ex.printStackTrace();
        }
        System.out.println("-----------conexion cerrada-------------");
    }

    private void closePostgresResources() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    private void closeMongoResources() {
        if (mc != null) {
            mc.close();
        }
    }

    private void closeObjectDBResources() {
        if (em != null) {
            em.clear();
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
    
    
    //------------CONSULTS----------------
    public void selectReservas() throws SQLException {
        stmt = conn.createStatement();
        // String query = SELECT * FROM reservas; // ERROR! hay que desglosarlo:
        String query = "SELECT codr, dni, (voos).idvooida, (voos).idvoovolta FROM reservas";
        rs = stmt.executeQuery(query);
        while(rs.next()) {
            codr = rs.getInt("codr");
            System.out.println("codr = " + codr);
            dni = rs.getString("dni");
            System.out.println("dni = " + dni);
            idVooIda = rs.getInt("idvooida");
            System.out.println("idvooida = " + idVooIda);
            idVooVolta = rs.getInt("idvoovolta");
            System.out.println("idvoovolta = " + idVooVolta);
            
            //incNreservasPasaxeiros(dni);
            setVoos(idVooIda); // orixe
            orixeIda = orixe;
            prezoIda = prezo;
            System.out.println("orixeIda = " + orixeIda + ", prezoIda = " + prezoIda);
            setVoos(idVooVolta); // orixe
            orixeVolta = orixe;
            prezoVolta = prezo;
            prezoFinal = prezoIda + prezoVolta;
            System.out.println("orixeVolta = " + orixeVolta + ", prezoVolta = " + prezoVolta + ", prezoFinal = " + prezoFinal);
            
            //insertConfirmada(codr, dni, orixeIda, orixeVolta, prezoFinal);
            
            System.out.println("");
            
        }

    }
    
    public void incNreservasPasaxeiros(String _id) {
        MongoCollection<Document> coll = mdb.getCollection("pasaxeiros");
        Bson query = eq("_id", _id);
        Bson change = Updates.combine(
                Updates.inc("nreservas", 1)
        );
        coll.updateOne(query, change);
        System.out.println("PASAXEIROS ACTUALIZADO nreservas");
    }
    
    public void setVoos(int _id) {
        MongoCollection<Document> coll = mdb.getCollection("voos");
        Bson query = eq("_id", _id);
        FindIterable<Document> preResult = coll.find(query);
        MongoCursor<Document> result = preResult.iterator();
        Document doc = result.next();
        orixe = doc.getString("orixe");
        prezo = doc.getInteger("prezo");
        
    }
    
    public void insertConfirmada(int codr, String dni, String orixeida, String orixevolta, double prezoreserva) {
        em.getTransaction().begin();
        Confirmada c = new Confirmada(codr, dni, orixeida, orixevolta, prezoreserva);
        em.persist(c);
        em.getTransaction().commit();
        System.out.println("INSERCION REALIZADA Confirmada");
        
    }
}
