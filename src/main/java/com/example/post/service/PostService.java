package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post post, User user);

    Optional<Post> selectPost(Long id);

    void updatePost(Post post);

    void deletePost(Long id);

    List<Post> selectAllPost();
}