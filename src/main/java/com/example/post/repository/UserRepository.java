package com.example.post.repository;

import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void create(User user);

    public Optional<User> selectUser(Long id);
    
    List<User> selectAll();
}
