package com.example.post.repository;

import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void create(User user);

    Optional<User> selectById(Long id);

    Optional<User> selectByUserName(String userName);

    List<User> selectAll();
}
