package com.example.post.service;

import com.example.post.exception.user.UserNotFoundException;
import com.example.post.model.User;
import com.example.post.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", "유효한 ID를 가진 User를 찾을 수 없습니다.", "유효한 ID를 가진 회원을 입력 해주십시오.")));
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName).orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", "유효한 userName을 가진 User를 찾을 수 없습니다.", "유효한 userName을 가진 회원을 입력 해주십시오.")));
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id, String password) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean authenticate(String userName, String rawPassword) {
        // 데이터베이스에서 사용자 조회
        Optional<User> user = userRepository.findByUserName(userName);
        // 유효성 검사 후 값 반환
        return user.map(value -> checkPassword(value.getPassword(), rawPassword)).orElse(false);
    }

    private Boolean checkPassword(String password, String rawPassword) {
        return password.equals(rawPassword);
    }
}