package com.example.post.service;

import com.example.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post post);

    Optional<Post> selectPost(Long id);

    void updatePost(Post post);

    void deletePost(Long id, String password);

    List<Post> selectAllPost();
}
