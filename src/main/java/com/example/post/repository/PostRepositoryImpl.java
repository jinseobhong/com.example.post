package com.example.post.repository;

import com.example.post.model.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Repository
public class PostRepositoryImpl implements PostRepository {

    private static final Map<Long, Post> posts = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void create(Post post) {
        post.setId(this.generatePostId());
        posts.put(post.getId(), post);
    }

    @Override
    public Optional<Post> select(Long id) {
        // Check if the user exists in the posts map and return it wrapped in an Optional
        return Optional.ofNullable(posts.get(id));
    }

    @Override
    public void update(Post post) {
        posts.put(post.getId(), post);
    }

    @Override
    public void delete(Long id) {
        posts.remove(id);
    }

    @Override
    public List<Post> selectAll() {
        return new ArrayList<>(posts.values());
    }

    private Long generatePostId() {
        return sequence++; // ID 생성 및 증가 및 캡슐화
    }
}
