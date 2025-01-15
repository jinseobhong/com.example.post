package com.example.post.repository;

import com.example.post.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter
@Setter
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> users = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void create(User user) {
        user.setId(this.generateUserId());
        users.put(user.getId(), user);
    }

    public Optional<User> selectUser(Long id) {
        // Check if the user exists in the users map and return it wrapped in an Optional
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> selectAll() {
        return new ArrayList<>(users.values());
    }

    private Long generateUserId() {
        return sequence++; // ID 생성 및 증가 및 캡슐화
    }
}
