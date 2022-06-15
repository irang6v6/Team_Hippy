package net.skhu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.skhu.entity.Comment;
import net.skhu.model.ArticleEdit;
import net.skhu.model.Pagination;
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.CommentRepository;
import net.skhu.repository.LocationArticleRepository;
import net.skhu.repository.MoodRepository;
import net.skhu.repository.PartyRepository;
import net.skhu.repository.TagRepository;
import net.skhu.service.ArticleService;
import net.skhu.service.BoardService;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired BoardService boardService;
    @Autowired ArticleService articleService;
    @Autowired LocationArticleRepository locationArticleRepository;
    @Autowired TagRepository tagRepository;
    @Autowired MoodRepository moodRepository;
    @Autowired PartyRepository partyRepository;
    @Autowired ArticleRepository articleRepository;
    @Autowired CommentRepository commentRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articles", articleService.findAll(pagination));
        model.addAttribute("locations", locationArticleRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
        model.addAttribute(articleService.getCurrentUserPermission());
        return "article/list";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id, Pagination pagination) {
    	var permission = articleService.getCurrentUserPermission(id);
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("article", articleService.findById(id));
        List<Comment> comments = commentRepository.findByArticleId(id,pagination);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        model.addAttribute("locations", locationArticleRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
        model.addAttribute("permission", permission);
        return "article/detail";
    }


    @PostMapping(value="detail", params="cmd=save")
    public String edit(Model model,int id, Comment comment, Pagination pagination) {
    	commentRepository.save(comment);
        return "redirect:detail?id=" +  id + "&" + pagination.getQueryString();
    }

    @RequestMapping("delete2")
    public String delete(Model model, @RequestParam("id") int id, int k_id, Pagination pagination) {
    	commentRepository.deleteById(id);
    	return "redirect:detail?id=" +  k_id + "&" + pagination.getQueryString();
    }


    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
    	var permission = articleService.getCurrentUserPermission();
        if (permission.isCreateGranted() == false)
            throw new AccessDeniedException("등록 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articleEdit", new ArticleEdit());
        model.addAttribute("locations", locationArticleRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
        model.addAttribute("permission", permission);
        return "article/create";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid ArticleEdit articleEdit, BindingResult bindingResult ) {
        var permission = articleService.getCurrentUserPermission();
        if (permission.isCreateGranted() == false)
            throw new AccessDeniedException("등록 권한 없음");
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
        model.addAttribute("permission", permission);
        return "article/create";
    }

    @GetMapping("edit")
    public String edit(Model model, int id, Pagination pagination) {
        var permission = articleService.getCurrentUserPermission(id);
        if (permission.isUpdateGranted() == false)
            throw new AccessDeniedException("수정 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articleEdit", articleService.findByIdToEdit(id));
        model.addAttribute("permission", permission);
        return "article/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Pagination pagination,
            @Valid ArticleEdit articleEdit, BindingResult bindingResult) {
        int id = articleEdit.getId();
        var permission = articleService.getCurrentUserPermission(id);
        if (permission.isUpdateGranted() == false)
            throw new AccessDeniedException("수정 권한 없음");
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
        model.addAttribute("permission", permission);
        return "article/edit";
    }

    @GetMapping("delete")
    public String delete(RedirectAttributes attributes, int id, Pagination pagination) {
        var permission = articleService.getCurrentUserPermission(id);
        if (permission.isDeleteGranted() == false)
            throw new AccessDeniedException("삭제 권한 없음");
        articleService.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
 }

