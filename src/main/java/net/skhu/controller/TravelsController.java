package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.Pagination;
import net.skhu.model.TravelsEdit;
import net.skhu.service.BoardService;
import net.skhu.service.TravelsService;

@Controller
@RequestMapping("travels")
public class TravelsController {

    @Autowired BoardService boardService;
    @Autowired TravelsService travelsService;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travels", travelsService.findAll(pagination));
        return "travels/list";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travels", travelsService.findById(id));
        return "travels/detail";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travelsEdit", new TravelsEdit());
        return "travels/create";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid TravelsEdit travelsEdit, BindingResult bindingResult ) {
        try {
            if (bindingResult.hasErrors() == false) {
                int id = travelsService.insert(pagination.getBd(), travelsEdit);
                return "redirect:detail?id=" + id + "&" + pagination.getQueryString();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bindingResult.reject(null, "저장할 수 없습니다.");
        }
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        return "travels/create";
    }
 }
