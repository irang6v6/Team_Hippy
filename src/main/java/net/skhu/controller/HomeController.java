package net.skhu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.entity.Store;
import net.skhu.entity.Article;
import net.skhu.model.Pagination;
import net.skhu.model.UserSignUp;
import net.skhu.repository.StoreRepository;
import net.skhu.repository.ArticleRepository;
import net.skhu.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	@Autowired StoreRepository storeRepository;
	@Autowired ArticleRepository articleRepository;

	@RequestMapping({"/", "index"})
	public String index(Model model, Pagination pagination) {
		List<Store> stores = storeRepository.findAll();
		model.addAttribute("stores", stores);
		List<Article> articles = articleRepository.findAll();
		model.addAttribute("articles", articles);
		return "store/index";
	}


	@RequestMapping("login")
	public String login() {
		return "store/login";
	}

	@GetMapping("signUp")
	public String signup(Model model) {
		model.addAttribute(new UserSignUp());
		return "store/signUp";
	}

	@PostMapping("signUp")
	public String signup(Model model,
			@Valid UserSignUp userSignUp, BindingResult bindingResult)
	{
		if (userService.hasErrors(userSignUp, bindingResult)) {
			return "store/signUp";
		}
		userService.save(userSignUp);
		return "redirect:signUpComplete";
	}

	@RequestMapping("signUpComplete")
	public String signUpComplete(Model model) {
		return "store/signUpComplete";
	}




}

