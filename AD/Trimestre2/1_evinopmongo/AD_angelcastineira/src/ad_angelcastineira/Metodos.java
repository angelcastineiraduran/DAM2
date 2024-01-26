/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_angelcastineira;

/**
 *
 * @author postgres
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Metodos {
    MongoClient mongoClient;
    MongoDatabase db;

    public void connectDatabase() {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("uvas");
    }
    
    
    
}
