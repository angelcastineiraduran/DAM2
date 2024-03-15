/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdietaenfermidadeopm;

import javax.persistence.*;
import java.util.*;
import java.sql.*;
import com.mongodb.client.*;
import org.bson.*;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;

public class Metodos {

    private String idp, enfermidade, tipoCarne, evoluci;
    private Double maxColesterolSemanal, colesterol, cantidadeParcial, totalColesterolConsumido, novo;
    private int gramos, dia;

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

    public void selectPersoas() throws SQLException {
        TypedQuery<Persoas> query = em.createQuery("SELECT p FROM Persoas p", Persoas.class);
        List<Persoas> results = query.getResultList();

        for (Persoas r : results) {
            idp = r.getIdp();
            enfermidade = r.getEnfermidade();
            System.out.println("idp = " + idp + ", enfermidade = " + enfermidade);
            
            setEnfermidades(enfermidade);
            System.out.println("maxColesterolSemanal = " + maxColesterolSemanal);
            
            setConsumo(idp);
            System.out.println("evoluci = " + evoluci);
            
            insertEvolucion(idp, maxColesterolSemanal, totalColesterolConsumido, evoluci);

            System.out.println("");
        }
    }

    public void setEnfermidades(String ide) {
        TypedQuery<Enfermidades> query = em.createQuery("SELECT e FROM Enfermidades e WHERE e.ide = :ide", Enfermidades.class);
        query.setParameter("ide", ide);
        Enfermidades e = query.getSingleResult();

        maxColesterolSemanal = e.getMaxcolesterolsemanal();
    }

    public void setConsumo(String dni) throws SQLException {
        stmt = conn.createStatement();
        String query = "SELECT gramos,tipocarne,dia FROM Consumo WHERE dni = '" + dni + "'";
        ResultSet rs = stmt.executeQuery(query);
        
        totalColesterolConsumido = 0.0;
        
        while (rs.next()) {
            gramos = rs.getInt("gramos");
            tipoCarne = rs.getString("tipocarne");
            dia = rs.getInt("dia");
            System.out.println("dia = " + dia + ", gramos = " + gramos + ", tipoCarne = " + tipoCarne);
            
            setCarne(tipoCarne);
            System.out.println("colesterol = " + colesterol);
            
            cantidadeParcial = gramos * colesterol / 100;
            System.out.println("cantidadeParcial = " + cantidadeParcial);
            
            totalColesterolConsumido = totalColesterolConsumido + cantidadeParcial;
        }
        
        System.out.println("totalColesterolConsumido = " + totalColesterolConsumido);
        
        if(totalColesterolConsumido > maxColesterolSemanal) {
            evoluci = "negativa"; 
        } else {
            evoluci = "positiva";
        }
    }

    public void setCarne(String nome) throws SQLException {
        stmt = conn.createStatement();
        String query = "";
        ResultSet rs = stmt.executeQuery("SELECT colesterol FROM Carne WHERE nome = '" + nome + "'");
        while (rs.next()) {
            colesterol = rs.getDouble("colesterol");
        }
    }
    
    
    public void insertEvolucion(String _id, double maxcolesterol, double novo, String evoluci) {
        MongoCollection<Document> coll = mdb.getCollection("evolucion");
        Bson query = eq("_id", _id);
        Bson change = Updates.combine(
                Updates.set("maxcolesterol", maxcolesterol),
                Updates.set("novo", novo),
                Updates.set("evoluci", evoluci)
        );
        // condicion y cambios
        coll.updateOne(query, change);
        System.out.println("INSERT EXECUTED");
    }
}
