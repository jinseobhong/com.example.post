package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void savePost(Post post, User user);

    Optional<Post> findById(Long id);

    void update(Post post);

    void delete(Long id);

    List<Post> findAll();
}