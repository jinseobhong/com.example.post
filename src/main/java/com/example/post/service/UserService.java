package com.example.post.service;

import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUserName(String userName);

    void update(User user);

    void delete(Long id, String password);

    List<User> findAll();

    Boolean authenticate(String userName, String rawPassword);
}
