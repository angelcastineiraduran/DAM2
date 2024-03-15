/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pinvasoras;

import javax.persistence.*;
import java.util.*;
import java.sql.*;
import com.mongodb.client.*;
import org.bson.*;
import static com.mongodb.client.model.Filters.*;
import org.bson.conversions.Bson;

/**
 *
 * @author ubuntu
 */
public class Metodos {

    int codZona, codEspecie, numeroInvasoras, tempMedia, tempBarrera, rowsResumo,
            codZ;
    double extension, porcentaxeDanos, extensionDanana, superficie;
    String nomeZ, nomeI, danos;
    

    EntityManager em;
    EntityManagerFactory emf;

    public void setConnectionObjectDB(String ubicacionBD) {
        emf = Persistence.createEntityManagerFactory(ubicacionBD);
        em = emf.createEntityManager();
        if (em != null) {
            System.out.println("Conexion con bd de objectdb exitosa!");
        } else {
            System.out.println("**ERROR seteando conexion**");
        }
    }

    public void closeConnectionObjectDB() {
        em.clear();
        em.close();
        emf.close();
        System.out.println("Conecion con bd de objectdb cerrada!");
    }

    public void getEncontradas() throws SQLException {
        connectDatabaseMongo("test");
        getConnectionPostgres();

        TypedQuery<Encontradas> query = em.createQuery("SELECT e FROM Encontradas e", Encontradas.class);
        List<Encontradas> result = query.getResultList();

        for (Encontradas e : result) {
            codZona = e.getCodzona();
            codEspecie = e.getCodespecie();

            //incrementNIZonas(codZona);
            setEspeciesInvasorasMongo(codEspecie); // tempbarrera 
            setZonas(codZona); // tempmdia, superficie, nomez
            
            extension = e.getExtension();
            extensionDanana = extension;
            porcentaxeDanos = (extensionDanana * 100) / superficie;
            if (tempMedia > tempBarrera) {
                System.out.println("new row resumo");
                insertResumo(codZona, nomeZ, nomeI, extensionDanana, porcentaxeDanos);
                rowsResumo++;
            }

            System.out.println("codzona=" + codZona + ", codespecie=" + codEspecie + ", tempBarrera" + tempBarrera + ", tempMedia=" + tempMedia + '\n');
        }

        System.out.println("rows resumo ====> " + rowsResumo);
        
        selectResumo();
        
        closeConnectionPostgres();
        closeClientMongo();
    }

    public void incrementNIZonas(int codz) {
        TypedQuery<Zonas> query = em.createQuery("SELECT z FROM Zonas z WHERE z.codz = :codz", Zonas.class);
        query.setParameter("codz", codz);
        Zonas z = query.getSingleResult();

        em.getTransaction().begin();
        numeroInvasoras = z.getNumeroinvasoras();
        z.setNumeroinvasoras(numeroInvasoras + 1);
        em.getTransaction().commit();

        System.out.println("NUMEROINVASORAS ACTUALIZADO");
    }

    public void setZonas(int codz) {
        TypedQuery<Zonas> query = em.createQuery("SELECT z FROM Zonas z WHERE z.codz = :codz", Zonas.class);
        query.setParameter("codz", codz);
        Zonas z = query.getSingleResult();
        tempMedia = z.getTempmedia();
        superficie = z.getSuperficie();
        nomeZ = z.getNomz();
    }

    // Para comunicarnos con Mongo utilizamos el cliente de Mongo
    private MongoClient mongoClient;
    private MongoDatabase database;

    public void connectDatabaseMongo(String db) {
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase(db);
    }

    public void closeClientMongo() {
        mongoClient.close();
    }

    public void setEspeciesInvasorasMongo(int codEspecie) {
        MongoCollection<Document> coll = database.getCollection("especiesinvasoras");
        // CREO que se podria simplificar ya que me va a devolver resultados uno por uno.
        Bson query = eq("_id", codEspecie);
        FindIterable<Document> preResult = coll.find(query);
        MongoCursor<Document> result = preResult.iterator();
        Document doc = result.next();
        tempBarrera = doc.getInteger("tempbarrera");
        nomeI = doc.getString("nomei");
        //System.out.println("tempBarrera = " + tempBarrera);
    }

    // -----------------POSTGRES--------------------------
    private Connection conn;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;

    public void getConnectionPostgres() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        conn = DriverManager.getConnection(url, usuario, password);
        if (conn != null) {
            System.out.println("Conexion exitosa a bd postgres!");
        } else {
            System.out.println("**ERROR abriendo conexion a bd postgres**");
        }
    }

    public void closeConnectionPostgres() throws SQLException {
        rs.close();
        if(stm != null) {
            stm.close();
        }
        if(pstm != null) {
            pstm.close();
        }
        conn.close();
        System.out.println("Conexion cerrada a bd postgres!");
    }
    
    public void selectResumo() throws SQLException {
        getConnectionPostgres();
        
        stm = conn.createStatement();
        String query = "SELECT * FROM resumo";
        rs = stm.executeQuery(query);
        while (rs.next()) {
            codZ = rs.getInt("codz");
            nomeZ = rs.getString("nomez");
            nomeI = rs.getString("nomei");
            danos = rs.getString("danos");
            
            System.out.println("codZ=" + codZ + ", nomeZ=" + nomeZ + ", nomeI=" + nomeI + ", danos=" + danos);
        }
        
        closeConnectionPostgres();
        
    }
    
    public void insertResumo(int codZ, String nomeZ, String nomeI, double extensionDanana, double porcentaxeDanos) throws SQLException {
        
        //String query = "INSERT INTO resumo (codz, nomez, nomei, danos) VALUES (?, ?, ?, ?)";
        
        // ME DA ERROR, PERO DEBERIA IR:
       // String query = "INSERT INTO resumo (codz, nomez, nomei, danos.extensiondanana, danos.porcentaxedanos) VALUES (?, ?, ?, ROW(?, ?))";
        String query = "INSERT INTO resumo (codz, nomez, nomei, danos) VALUES (?, ?, ?, ROW(?, ?))";
        pstm = conn.prepareStatement(query);   
        pstm.setInt(1, codZ);
        pstm.setString(2, nomeZ);
        pstm.setString(3, nomeI);
        pstm.setDouble(4, extensionDanana);
        pstm.setDouble(5, porcentaxeDanos);  
        int rowsAffected = pstm.executeUpdate();


        System.out.println("INSERT EXECUTED");
        System.out.println("rowsAffected = " + rowsAffected);
        
    }

}
