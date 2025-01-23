package com.example.post.repository;

import com.example.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    void create(Post post);

    Optional<Post> select(Long id);

    void update(Post post);

    void delete(Long id);

    List<Post> selectAll();
}