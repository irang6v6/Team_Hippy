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
@RequestMapping("include")
@Secured("ROLE_ADMIN")
public class IncludeController {
    @Autowired UserService userService;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("users", userService.findAll(pagination));
        return "user/list";
    }

    @GetMapping("header")
    public String edit(Model model, Pagination pagination, int id) {
        model.addAttribute("user", userService.findById(1));
        return "include/header";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid UserEdit userEdit, BindingResult bindingResult) {
        try {
            if (userService.hasErrors(userEdit, bindingResult) == false) {
                userService.save(userEdit);
                return "redirect:list?" + pagination.getQueryString();
            }
        }
        catch (Exception exception) {
            bindingResult.reject(null, "저장할 수 없습니다.");
        }
        return "user/edit";
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, Pagination pagination,
            @Valid UserEdit userEdit, BindingResult bindingResult) {
        try {
            userService.deleteById(userEdit.getId());
            return "redirect:list?" + pagination.getQueryString();
        }
        catch (Exception exception) {
            bindingResult.reject(null, "삭제할 수 없습니다.");
        }
        return "user/edit";
    }

}
