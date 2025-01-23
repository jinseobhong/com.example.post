package com.example.post.service;

import com.example.post.exception.PostNotFoundException;
import com.example.post.model.Post;
import com.example.post.model.User;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true) // 읽기 전용으로 가져온다. 실제 커밋/롤백이 필요한 것에는 @Transactional을 붙임
@RequiredArgsConstructor // 의존성 주입(DI, Dependency Injection) - 생성자 주입 코드 생성
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void savePost(Post post, User user) {
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("글을 찾을 수 없습니다.", "유효한 ID를 가진 Post를 찾을 수 없습니다.", "유효한 ID를 가진 글을 입력 해주십시오.")));
    }

    @Override
    @Transactional
    public void update(Post post) {
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}