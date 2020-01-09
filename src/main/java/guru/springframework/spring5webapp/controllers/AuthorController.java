package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        //since authorRepository extend CrudRepository, we can get basic queries
        //The following line queries all books and put into attribute authors of the model
        model.addAttribute("authors", authorRepository.findAll());

        //Return a string authors, on the view, Thymeleaf will figure out data from this "authors" attribute
        return "authors";

    }
}
