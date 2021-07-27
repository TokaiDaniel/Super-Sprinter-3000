package com.codecool.superSprinter.userStory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserStory {
    @Id
    @SequenceGenerator(
            name = "story_sequence",
            sequenceName = "story_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "story_sequence"
    )
    private Long id;
    private String storyTitle;
    private String story;
    private String acceptanceCriteria;
    private int businessValue;
    private String status;
    private LocalTime estimation;

    public UserStory(String storyTitle) {
        this.storyTitle = storyTitle;
    }
}

