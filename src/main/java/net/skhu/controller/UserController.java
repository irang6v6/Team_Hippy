package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.Pagination;
import net.skhu.model.UserEdit;
import net.skhu.service.UserService;

@Controller
@RequestMapping("user")
@Secured("ROLE_ADMIN")
public class UserController {
    @Autowired UserService userService;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("users", userService.findAll(pagination));
        return "user/list";
    }

    @GetMapping("edit")
    public String edit(Model model, Pagination pagination, int id) {
        model.addAttribute("userEdit", userService.findById(id));
        return "user/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Pagination pagination,
            @Valid UserEdit userEdit, BindingResult bindingResult) {
        if (userService.hasErrors(userEdit, bindingResult) == false) {
            userService.save(userEdit);
            return "redirect:list?" + pagination.getQueryString();
        }
        return "user/edit";
    }

}

