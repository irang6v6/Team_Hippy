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
import net.skhu.model.Pagination;
import net.skhu.model.UserSignUp;
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.BoardRepository;
import net.skhu.repository.LocationArticleRepository;
import net.skhu.repository.MoodRepository;
import net.skhu.repository.PartyRepository;
import net.skhu.repository.StoreRepository;
import net.skhu.repository.TagRepository;
import net.skhu.service.ArticleService;
import net.skhu.service.BoardService;
import net.skhu.service.UserService;

@Controller
public class HomeController {

	@Autowired UserService userService;
	@Autowired StoreRepository storeRepository;
	@Autowired ArticleRepository articleRepository;
	@Autowired LocationArticleRepository locationArticleRepository;
	@Autowired TagRepository tagRepository;
	@Autowired MoodRepository moodRepository;
	@Autowired PartyRepository partyRepository;
	@Autowired BoardRepository boardRepository;
	@Autowired ArticleService articleService;
	@Autowired BoardService boardService;

	@RequestMapping({"/", "index"})
	public String index(Model model, Pagination pagination) {
		List<Store> stores = storeRepository.findByLocationIdAndTagId(pagination);
		model.addAttribute("stores", stores);
        model.addAttribute("articles", articleService.findAll2(pagination));
        model.addAttribute("afters", articleService.findAll3(pagination));
        model.addAttribute("locations", locationArticleRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
		return "store/index";
	}

	@GetMapping("header")
	public String header(Model model, int id,Pagination pagination) {
        model.addAttribute("user", userService.findById(id));
		return "include/header";
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

