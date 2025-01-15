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

    @Override
    public Optional<User> selectById(Long id) {
        // Check if the user exists in the users map and return it wrapped in an Optional
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> selectByUserName(String userName) {
        // users의 values()를 순회하며 userName을 가진 User 객체를 찾음
        return users.values().stream().filter(user -> userName.equals(user.getUserName())) // userName 일치 여부 확인
                .findFirst(); // 필터링된 첫 번째 User를 Optional로 반환
    }

    @Override
    public List<User> selectAll() {
        return new ArrayList<>(users.values());
    }

    private Long generateUserId() {
        return sequence++; // ID 생성 및 증가 및 캡슐화
    }
}
