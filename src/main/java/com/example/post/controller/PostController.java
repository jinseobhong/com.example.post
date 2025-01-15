package com.example.post.controller;

import com.example.post.model.Post;
import com.example.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/post")
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "post/create/index"; // post/create/index.html
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post, Model model) {
        // 서비스에서 저장 로직 실행
        postService.createPost(post);
        return "redirect:select/all"; // 성공 시 글 목록 페이지로 리다이렉트
    }

    @GetMapping("/select/{id}")
    public String showSelectUser(@PathVariable(name = "id") Long id, Model model) {
        // 서비스에서 글 조회
        Optional<Post> post = postService.selectPost(id);
        // 모델에 사용자 정보 추가
        model.addAttribute("post", post);
        return "post/select/selectById"; // user/select/selectById.html
    }

    @GetMapping("/select/all")
    public String showSelectAllPosts(Model model) {
        model.addAttribute("posts", postService.selectAllPost());
        return "post/select/selectAll"; // post/select/selectAll.html
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable(name = "id") Long id, @RequestParam(name = "password") String password) {
        postService.deletePost(id, password);
        return "redirect:/post/select/all";
    }
}
