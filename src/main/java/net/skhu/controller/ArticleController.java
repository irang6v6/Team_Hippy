package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.skhu.entity.Comment;
import net.skhu.model.ArticleEdit;
import net.skhu.model.Pagination;
<<<<<<< HEAD
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.CommentRepository;
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
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
<<<<<<< HEAD
    @Autowired ArticleRepository articleRepository;
    @Autowired CommentRepository commentRepository;
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("articles", articleService.findAll(pagination));
        model.addAttribute("locations", locationArticleRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
<<<<<<< HEAD
        model.addAttribute(articleService.getCurrentUserPermission());
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
        return "article/list";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id, Pagination pagination) {
    	model.addAttribute("comments", new Comment());
    	var permission = articleService.getCurrentUserPermission(id);
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("article", articleService.findById(id));
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("permission", permission);
        return "article/detail";
    }


    @PostMapping(value="detail", params="cmd=save")
    public String edit(Model model,int id, Comment comment, Pagination pagination) {
    	commentRepository.save(comment);
        return "redirect:detail?id=" +  id + "&" + pagination.getQueryString();
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
<<<<<<< HEAD
        model.addAttribute("permission", permission);
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
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
<<<<<<< HEAD
        model.addAttribute("permission", permission);
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
        return "article/create";
    }

    @GetMapping("edit")
    public String edit(Model model, int id, Pagination pagination) {
        var permission = articleService.getCurrentUserPermission(id);
        if (permission.isUpdateGranted() == false)
            throw new AccessDeniedException("수정 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
<<<<<<< HEAD
        model.addAttribute("articleEdit", articleService.findByIdToEdit(id));
        model.addAttribute("permission", permission);
=======
        model.addAttribute("articleEdit", articleService.findById2(id));
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
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
<<<<<<< HEAD
        model.addAttribute("permission", permission);
=======
>>>>>>> 967302cf820678e54230cee933756a9fadeb8ad2
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

