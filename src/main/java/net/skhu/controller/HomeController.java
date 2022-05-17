package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.UserSignUp;
import net.skhu.service.UserService;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping({"/", "index"})
    public String index() {
        return "home/index";
    }

    @RequestMapping("login")
    public String login() {
        return "home/login";
    }

    @GetMapping("signUp")
    public String signup(Model model) {
        model.addAttribute(new UserSignUp());
        return "home/signUp";
    }

    @PostMapping("signUp")
    public String signup(Model model,
            @Valid UserSignUp userSignUp, BindingResult bindingResult)
    {
        if (userService.hasErrors(userSignUp, bindingResult)) {
            return "home/signUp";
        }
        userService.save(userSignUp);
        return "redirect:signUpComplete";
    }

    @RequestMapping("signUpComplete")
    public String signUpComplete(Model model) {
        return "home/signUpComplete";
    }
}
