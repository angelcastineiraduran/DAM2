/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad_angelcastineira;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Arrays;
import static java.util.Arrays.asList;
import org.bson.types.ObjectId;

/**
 *
 * @author postgres
 */
public class Main {
    

    public static void main(String[] args) {
        
        
//        MongoDatabase database = mongoClient.getDatabase("test");
//        try {
//            // mando un ping para comprobar conexion
//            Bson command = new BsonDocument("ping", new BsonInt64(1));
//            Document commandResult = database.runCommand(command);
//            System.out.println("Has hecho un PING a Mongodb correctamente!");
//        } catch (MongoException me) {
//            System.err.print(me);
//        }
//        
//        // -- CONSULTAS --
//        // Obtener la colección "uvas"
//        MongoCollection<Document> uvasCollection = database.getCollection("uvas");
//
//        // Realizar una consulta (find) en la colección "uvas"
//        FindIterable<Document> uvasDocuments = uvasCollection.find();
//
//        // Iterar sobre los documentos resultantes
//        for (Document document : uvasDocuments) {
//            System.out.println(document.toJson());
//        }
//        
//        // limpiar recursos utilizados
//        mongoClient.close();

        Metodos m = new Metodos();
        m.connectDatabase("test");
        m.getAnalisis();
        m.closeClient();
    }
}
