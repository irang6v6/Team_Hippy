package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.repository.ArticleRepository;
import net.skhu.dto.Pagination;
import net.skhu.entity.Article;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired ArticleRepository articleRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
    	List<Article> articles = articleRepository.findAll(pagination);
        model.addAttribute("articles", articles);
        return "article/list";
    }
    
}
