package com.example.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String content;
    private User user;
    private String password;
    private int countViews;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}