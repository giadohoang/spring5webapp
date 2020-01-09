package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        //since bookrepository extend CrudRepository, we can get basic queries
        //The following line queries all books and put into attribute books of the model
        model.addAttribute("books",bookRepository.findAll());

        //Return a string books, on the view, Thymeleaf will figure out data from this "books" attribute
        return "books";
    }
}
