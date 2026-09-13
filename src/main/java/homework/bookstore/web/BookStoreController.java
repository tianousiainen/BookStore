package homework.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import homework.bookstore.domain.Book;
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

    @GetMapping("/booklist")
    public String getBookList(@ModelAttribute Book book , Model model){
        model.addAttribute("book", new Book());
        bookStoreRepository.save(book);
        model.addAttribute("books", bookStoreRepository.findAll());
        return ("booklist"); //booklist.html
    }
}
