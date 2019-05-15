package com.wunderit.projetcd.mongodriver;

// MongoDB packages
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.util.List;
import java.util.ArrayList;

import com.mongodb.client.MongoCursor;


//BSON Document package
import org.bson.Document;

/**
 * Class for MongoDB driver
 */
public class Driver {

        //Environment variables to connect to mongodb database
        String admin = System.getenv().get("MONGODB_ADMIN_USER");
        String passwd = System.getenv().get("MONGODB_ADMIN_PWD");
        String url = System.getenv().get("MONGODB_URL");
        String port = System.getenv().get("MONGODB_PORT");
        
        //Create a connection
        MongoClient mongoClient = MongoClients.create("mongodb://"+admin+":"+passwd+"@"+url+":"+port);

        //Connect to database
        MongoDatabase database = mongoClient.getDatabase("stagaires");

    //method to create a document
    public void createdoc(Document doc) {
        //Use a collection
        MongoCollection<Document> collection = database.getCollection("descriptifs");
        collection.insertOne(doc);
    }

    //method to retrive all documents
    public List<String> getalldocs() {
        //Use a collection
        MongoCollection<Document> collection = database.getCollection("descriptifs");

        MongoCursor<Document> cursor = collection.find().iterator();

        List<String> alldocs = new ArrayList<String>();

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
                alldocs.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return alldocs;
    }

    //method to retrive a document by its id
    public  Document getdocbyid(int Id) {
        //Use a collection
        MongoCollection<Document> collection = database.getCollection("descriptifs");

        Document doc = collection.find(eq("i", Id)).first();
        return doc;
    }

    //disconnect from database
    public static void disconnect(MongoClient mongoClient) {
        mongoClient.close();
    }
}