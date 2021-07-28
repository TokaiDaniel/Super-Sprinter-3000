package com.codecool.superSprinter.controller;

import com.codecool.superSprinter.userStory.UserStory;
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

    @RequestMapping(path = "/story")
    public String storyAdd(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("user_story", new UserStory());
        return "add";
    }

    @RequestMapping(path = "/story/{id}")
    public String storyUpdate(Model model, @PathVariable Long id) {
        model.addAttribute("user_story", service.getStoryById(id));
        model.addAttribute("id", id);
        return "user_story/edit";
    }

}

