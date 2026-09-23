package homework.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import homework.bookstore.domain.Book;
import homework.bookstore.domain.BookStoreRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class BookRestController {


    private BookStoreRepository _bookRepository;

    public BookRestController(BookStoreRepository bookRepository){
        _bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest(){
        return (List<Book>) _bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long bookId){
        return _bookRepository.findById(bookId);
    }
}
