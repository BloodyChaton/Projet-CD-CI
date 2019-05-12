package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.db;
@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        db.main("mongodb://root:n7rkmJqVJO@localhost:27017");
        return "Greetings from Spring Boot!";
    }
    
}
