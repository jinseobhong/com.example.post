package com.example.post.service;

import com.example.post.exception.PostNotFoundException;
import com.example.post.model.Post;
import com.example.post.model.User;
import com.example.post.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(Post post, User user) {
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.create(post);
    }

    @Override
    public Optional<Post> selectPost(Long id) {
        return Optional.ofNullable(postRepository.select(id).orElseThrow(() -> new PostNotFoundException("글을 찾을 수 없습니다.", "유효한 ID를 가진 Post를 찾을 수 없습니다.", "유효한 ID를 가진 글을 입력 해주십시오.")));
    }

    @Override
    public void updatePost(Post post) {
        post.setUpdatedAt(LocalDateTime.now());
        postRepository.update(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    @Override
    public List<Post> selectAllPost() {
        return postRepository.selectAll();
    }
}