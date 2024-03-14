/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_angelcastineira;

/**
 *
 * @author postgres
 */

import com.mongodb.ConnectionString;
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

public class Metodos {
    
    // campos que vamos a recoger
    int acidezMin, acidezMax, acidez, cantidadUvaAnalisis;
    String nomeUva, idAnalisis, tipoUva, idClientes;
    
    // Para comunicarnos con Mongo utilizamos el cliente de Mongo
    private MongoClient mongoClient;
    private MongoDatabase database;

    public void connectDatabase(String db) {
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase(db);
    }
    
    public void closeClient() {
        mongoClient.close();
    }
    
    public void getAnalisis() {
        // 1. Coleccion a extraer y campos de los documentos
        MongoCollection<Document> coll = database.getCollection("analisis");
        // incluimos/excluimos campos
        Bson fields = Projections.fields(
                Projections.include(
                        "acidez",
                        "tipodeuva",
                        "cantidade",
                        "dni"
                )
        );
        
        // 2. Tipo de consulta
        FindIterable<Document> preResult = coll
                .find()
                .projection(fields)
                .sort(Sorts.ascending("_id"));
        
        // Si quieres coger el primer resultado
        //System.out.println(preResult.first());
        
        // 3. Iterar resultados
        MongoCursor<Document> result = preResult.iterator();
        Document doc;
        while(result.hasNext()) {
            // coges la fila
            doc = result.next();
            idAnalisis = doc.getString("_id");
            acidez = doc.getInteger("acidez");
            tipoUva = doc.getString("tipodeuva");
            cantidadUvaAnalisis = doc.getInteger("cantidade");
            idClientes = doc.getString("dni");
            System.out.println(idAnalisis + "," + acidez + "," + tipoUva + "," + cantidadUvaAnalisis + "," + idClientes);
            
            // aumento numerodeanalisis
            aumentarNACliente();
            // recogemos nomeu, acidezmin, acidezmax
            getUvas();
            // con los valores recogidos de antes, calculamos Xerado
            crearXerado();
            System.out.println("");
        }
        
    }
    
    public void aumentarNACliente() {
        MongoCollection<Document> coll = database.getCollection("clientes");
        Bson query = eq("_id", idClientes);
        Bson change = Updates.combine(
                Updates.inc("numerodeanalisis", 1)
        );
        // condicion y cambios
        coll.updateOne(query, change);
        System.out.println("CLIENTE aumentado");
    }
    
    
    public void getUvas() {
        MongoCollection<Document> coll = database.getCollection("uvas");
        Bson query = eq("_id", tipoUva);
        FindIterable<Document> preResult = coll.find(query);
        MongoCursor<Document> result = preResult.iterator();
        Document doc = result.next();
        // no hay bucle pq solo queremos un registro, el que sea igual al _id=tipoUVa
        nomeUva = doc.getString("nomeu");
        acidezMin = doc.getInteger("acidezmin");
        acidezMax = doc.getInteger("acidezmax");
    }
    
    public void crearXerado() {
        MongoCollection<Document> coll = database.getCollection("Xerado");
        String tratacidez;
        if(acidez > acidezMax) {
            tratacidez = "baixar acidez";
        } else if(acidez < acidezMin) {
            tratacidez = "acidez correcta";
        } else {
            tratacidez = "acidez correcta";
        }
        int total = 15 * cantidadUvaAnalisis;
        Document doc_ins = new Document("_id", idAnalisis)
                .append("nomeuva", nomeUva)
                .append("tratacidez", tratacidez)
                .append("total", total)
        ;
        
        coll.insertOne(doc_ins);
        System.out.println("XERADO CREADO");
    }
            
    
    
    
}
