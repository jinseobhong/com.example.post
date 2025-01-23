package com.example.post.repository;

import com.example.post.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본적인 CRUD 메서드는 자동으로 제공됩니다.
    Optional<User> findByUserName(String userName);
}