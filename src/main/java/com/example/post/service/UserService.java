package com.example.post.service;

import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> selectUser(Long id);

    List<User> selectAllUsers();
}
