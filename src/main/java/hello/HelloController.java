package hello;

// springboot packages
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

// ModelMap package
import org.springframework.ui.ModelMap;

// BSON Document package
import org.bson.Document;

// mongodb connector package
import mongodata.*;

@RestController
public class HelloController {

    // Create a new instance of MongoDB
    Driver instance = new mongodata.Driver();

    // return a document that is requested by its Id
    @RequestMapping("/getDocument")
    public Document getDocument(@RequestParam(value = "id", defaultValue = "1") int id) {

        Document doc = instance.getdocbyid(id);
        return doc;
    }

    //Create a document
    @RequestMapping(value="/createDocument", method = RequestMethod.POST)
    public String createDocument(ModelMap model, @RequestBody Document doc) {
                
        // return message
        String message;

        try{
            // Create the document in the database
            instance.createdoc(doc);
            message = "Valid";
        } catch (Exception e) {
            message = "Not valid";
        }
        
        // return final message
        return message;
    }
}