package mongodata;

// MongoDB packages
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

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
    MongoDatabase database = mongoClient.getDatabase("mydb");

    //Use a collection
    MongoCollection<Document> collection = database.getCollection("test");

    //method to create a document
    public void createdoc(Document doc) {
        collection.insertOne(doc);
    }

    //method to retrive a document by its id
    public  Document getdocbyid(int Id) {
        Document doc = collection.find(eq("i", Id)).first();
        return doc;
    }

    //disconnect from database
    public static void disconnect(MongoClient mongoClient) {
        mongoClient.close();
    }
}