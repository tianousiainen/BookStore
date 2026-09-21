package homework.bookstore.web;

import homework.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import homework.bookstore.domain.Book;
import homework.bookstore.domain.Category;


@Controller 
public class CategoryController {
    private final CategoryRepository categoryRepository;

    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String getCategoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());

        return ("categorylist"); //categorylist.html
    }

    @GetMapping (value = "/addcategory")
    public String getNewBook(Model model){
        model.addAttribute("category", new Category());
        return ("addcategory"); //addcategory.html
    }

      @PostMapping("/savecategory")
    public String saveBook(@ModelAttribute Category category, Model model){
        categoryRepository.save(category); //SQL inster tai edit komento
        return "redirect:/categorylist";
    }

    
}
