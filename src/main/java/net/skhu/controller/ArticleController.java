package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.skhu.model.ArticleEdit;
import net.skhu.model.Pagination;
import net.skhu.repository.LocationRepository;
import net.skhu.service.ArticleService;
import net.skhu.service.BoardService;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired BoardService boardService;
    @Autowired ArticleService articleService;
    @Autowired LocationRepository locationRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articles", articleService.findAll(pagination));
        model.addAttribute("locations", locationRepository.findAll());
        return "article/list";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("article", articleService.findById(id));
        return "article/detail";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articleEdit", new ArticleEdit());
        model.addAttribute("locations", locationRepository.findAll());
        return "article/create";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid ArticleEdit articleEdit, BindingResult bindingResult ) {
        try {
            if (bindingResult.hasErrors() == false) {
                int id = articleService.insert(pagination.getBd(), articleEdit);
                return "redirect:detail?id=" + id + "&" + pagination.getQueryString();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bindingResult.reject(null, "저장할 수 없습니다.");
        }
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("locations", locationRepository.findAll());
        return "article/create";
    }

    @GetMapping("edit")
    public String edit(Model model, int id, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articleEdit", articleService.findById2(id));
        model.addAttribute("locations", locationRepository.findAll());
        return "article/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Pagination pagination,
            @Valid ArticleEdit articleEdit, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors() == false) {
                articleService.update(articleEdit);
                return "redirect:detail?id=" + articleEdit.getId() + "&" + pagination.getQueryString();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bindingResult.reject(null, "저장할 수 없습니다.");
        }
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("locations", locationRepository.findAll());
        return "article/edit";
    }

    @GetMapping("delete")
    public String delete(RedirectAttributes attributes, int id, Pagination pagination) {
        try {
            articleService.deleteById(id);
            return "redirect:list?" + pagination.getQueryString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            attributes.addFlashAttribute("error", "삭제할 수 없습니다.");
            return "redirect:detail?id=" + id + "&" + pagination.getQueryString();
        }
    }
 }

