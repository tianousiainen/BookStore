package homework.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import homework.bookstore.domain.BookStoreRepository;

@Controller 
public class BookStoreController {
    private BookStoreRepository bookStoreRepository;

    public BookStoreController(BookStoreRepository bookStoreRepository){
        this.bookStoreRepository = bookStoreRepository;
    }

    @GetMapping("/index")
    public String getBookStore(){
        return("index"); //index.html
    }
}
