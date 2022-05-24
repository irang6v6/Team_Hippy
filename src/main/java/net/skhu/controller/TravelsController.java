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
        model.addAttribute(travelsService.getCurrentUserPermission());
        return "travels/list";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id, Pagination pagination) {
        var permission = travelsService.getCurrentUserPermission(id);
        if (permission.isReadGranted() == false)
            throw new AccessDeniedException("읽기 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travels", travelsService.findById(id));
        model.addAttribute(travelsService.getCurrentUserPermission());
        model.addAttribute("permission", permission);
        return "travels/detail";
    }


    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        var permission = travelsService.getCurrentUserPermission();
        if (permission.isCreateGranted() == false)
            throw new AccessDeniedException("등록 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travelsEdit", new TravelsEdit());
        model.addAttribute("permission", permission);
        return "travels/create";
    }


    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid TravelsEdit travelsEdit, BindingResult bindingResult ) {
    	var permission = travelsService.getCurrentUserPermission();
        if (permission.isCreateGranted() == false)
            throw new AccessDeniedException("등록 권한 없음");

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
        model.addAttribute("permission", permission);
        return "travels/create";
    }

    @GetMapping("edit")
    public String edit(Model model, int id, Pagination pagination) {
        var permission = travelsService.getCurrentUserPermission(id);
        if (permission.isUpdateGranted() == false)
            throw new AccessDeniedException("수정 권한 없음");
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("travelsEdit", travelsService.findByIdToEdit(id));
        model.addAttribute("permission", permission);
        return "travels/edit";
    }


    @PostMapping("edit")
    public String edit(Model model, Pagination pagination,
            @Valid TravelsEdit travelsEdit, BindingResult bindingResult) {
        int id = travelsEdit.getId();
        var permission = travelsService.getCurrentUserPermission(id);
        if (permission.isUpdateGranted() == false)
            throw new AccessDeniedException("수정 권한 없음");

        try {
            if (bindingResult.hasErrors() == false) {
                travelsService.update(travelsEdit);
                return "redirect:detail?id=" + travelsEdit.getId() + "&" + pagination.getQueryString();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            bindingResult.reject(null, "저장할 수 없습니다.");
        }
        model.addAttribute("board", boardService.findById(pagination.getBd()));
        model.addAttribute("permission", permission);
        return "travels/edit";
    }

    @GetMapping("delete")
    public String delete(RedirectAttributes attributes, int id, Pagination pagination) {
        var permission = travelsService.getCurrentUserPermission(id);
        if (permission.isDeleteGranted() == false)
            throw new AccessDeniedException("삭제 권한 없음");
        travelsService.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }

 }
