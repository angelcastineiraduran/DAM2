/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pinvasoras;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author postgres
 */
public class Pinvasoras {

    public static void main(String[] args) throws SQLException {
        
        Metodos m = new Metodos();
        m.setConnectionObjectDB("/home/ubuntu/DAM2/AD/Trimestre2/Ejercicios/5_pinvasoras/pinvasoras/src/pinvasoras/encontradasezonas.odb");
        
        m.getEncontradas();
        
        m.closeConnectionObjectDB();
    }
    
}
