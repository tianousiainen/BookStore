package homework.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BookStoreController {
    @GetMapping("/index")
    public String getBookStore(){
        return("index"); //index.html
    }
}
