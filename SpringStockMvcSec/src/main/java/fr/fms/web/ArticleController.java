package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.fms.entities.Article;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(Model model) {
        // Fetch articles from the database
        List<Article> articles = articleRepository.findAll();
        
        // Pass articles to the view
        model.addAttribute("articles", articles);
        
        // Return the name of the Thymeleaf template
        return "articles";
    }
}
