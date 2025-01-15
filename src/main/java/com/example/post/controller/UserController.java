package com.example.post.controller;

import com.example.post.model.User;
import com.example.post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "user/index"; // user/index.html
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "user/create/index"; // user/create/index.html
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        // 서비스에서 저장 로직 실행
        userService.createUser(user);
        return "redirect:create/status/success"; // 성공 시 회원 목록 페이지로 리다이렉트
    }

    @GetMapping("/create/status/success")
    public String showSuccessUserCreate() {
        return "user/create/status/success";
    }

    @GetMapping("/select/{id}")
    public String showSelectUser(@PathVariable(name = "id") Long id, Model model) {
        // 서비스에서 사용자 조회
        Optional<User> user = userService.selectUser(id);
        // 모델에 사용자 정보 추가
        model.addAttribute("user", user);
        return "user/select/selectById"; // user/select/selectById.html
    }

    @GetMapping("/select/all")
    public String showSelectAllUser(Model model) {
        model.addAttribute("users", userService.selectAllUsers());
        return "user/select/selectAll"; // user/select/selectAll.html
    }
}