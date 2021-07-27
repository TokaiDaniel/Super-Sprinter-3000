package com.codecool.superSprinter.controller;

import com.codecool.superSprinter.userStory.UserStoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {

    UserStoryService service;

    @RequestMapping(path = "/")
    public String mainPage(Model model) {
        model.addAttribute("user_stories", service.getAllStories());
        return "index";
    }

}

