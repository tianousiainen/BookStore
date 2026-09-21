package homework.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String getBookList(Model model){
        model.addAttribute("books", bookStoreRepository.findAll());
        return ("booklist"); //booklist.html
    }

    @GetMapping (value = "/addbook")
    public String getNewBook(Model model){
        model.addAttribute("book", new Book());
        return ("addbook"); //addbook.html
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book, Model model){
        bookStoreRepository.save(book); //SQL inster tai edit komento
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String deleteBook(@PathVariable ("id") Long id, Model model){
            bookStoreRepository.deleteById(id);
            return "redirect:/booklist";
    }

    @RequestMapping (value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable ("id") Long id, Model model){
        Book book = bookStoreRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return ("editbook"); //editbook.html

    }

}
