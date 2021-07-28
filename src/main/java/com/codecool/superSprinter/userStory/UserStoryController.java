package com.codecool.superSprinter.userStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserStoryController {

    UserStoryService service;

    @Autowired
    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserStory> getStories() {
        return service.getAllStories();
    }

    @ModelAttribute("user_story")
    public UserStory userStory() {
        return new UserStory();
    }

    @PostMapping(path = "api/v1/user_story")
    public void addUserStory(@ModelAttribute("user_story") UserStory userStory, HttpServletResponse response) {
        service.saveUserStory(userStory);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @PostMapping("/update")
    public void update(Long id, UserStory newStory) {
        UserStory userStory = service.getStoryById(id);
        if (userStory == null) {
            throw new IllegalArgumentException("User Story not available to update");
        }

        userStory.setStoryTitle(newStory.getStoryTitle());
        userStory.setStory(newStory.getStory());
        userStory.setAcceptanceCriteria(newStory.getAcceptanceCriteria());
        userStory.setStatus(newStory.getStatus());
        userStory.setEstimation(newStory.getEstimation());
    }
}

