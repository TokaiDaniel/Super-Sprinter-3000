package com.codecool.superSprinter.userStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    UserStoryRepository repository;

    @Autowired
    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public List<UserStory> getAllStories() {
        return repository.findAll();
    }

    public UserStory getStoryById(Long id) {
        return repository.getById(id);
    }

    public void saveUserStory(UserStory userStory) {
        repository.save(userStory);
    }
}

