package com.example.post.service;

import com.example.post.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> selectByUId(Long id);

    Optional<User> selectByUserName(String userName);

    void updateUser(User user);

    void deleteUser(Long id, String password);

    List<User> selectAllUsers();

    Boolean authenticate(String userName, String rawPassword);
}
