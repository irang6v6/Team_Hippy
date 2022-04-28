package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hippy")
public class FirstController {

    @RequestMapping("index")
	public String test1(Model model) {
        return "index";
    }




}

