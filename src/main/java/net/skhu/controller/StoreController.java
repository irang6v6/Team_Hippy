package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Store;
import net.skhu.model.Pagination;
import net.skhu.repository.LocationRepository;
import net.skhu.repository.MoodRepository;
import net.skhu.repository.PartyRepository;
import net.skhu.repository.StoreRepository;
import net.skhu.repository.StoreRepository2;
import net.skhu.repository.TagRepository;

@Controller
@RequestMapping("store")
public class StoreController {

    @Autowired StoreRepository storeRepository;
    @Autowired StoreRepository2 storeRepository2;
    @Autowired LocationRepository locationRepository;
    @Autowired TagRepository tagRepository;
    @Autowired MoodRepository moodRepository;
    @Autowired PartyRepository partyRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Store> stores = storeRepository.findByLocationIdAndTagId(pagination);
        model.addAttribute("stores", stores);
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("moods", moodRepository.findAll());
        model.addAttribute("partys", partyRepository.findAll());
        return "store/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("store", new Store());
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "store/edit";
    }

    @PostMapping("create")
    public String create(Model model, Store store, Pagination pagination) {
    	storeRepository.save(store);
        pagination.setDi(0);
        pagination.setTi(0);
        int lastPage = (int)Math.ceil((double)storeRepository.count() / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Store store = storeRepository.findById(id).get();
        model.addAttribute("store", store);
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "store/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Store store, Pagination pagination) {
    	storeRepository.save(store);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
    	storeRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

