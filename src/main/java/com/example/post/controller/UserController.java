package com.example.post.controller;

import com.example.post.model.User;
import com.example.post.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/create")
    public String showCreateForm() {
        return "user/create/index"; // user/create/index.html
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/select/{id}")
    public String showSelectUser(@PathVariable(name = "id") Long id, Model model) {
        // 서비스에서 사용자 조회
        Optional<User> user = userService.selectByUId(id);
        // 모델에 사용자 정보 추가
        model.addAttribute("user", user);
        return "user/select/selectById"; // user/select/selectById.html
    }

    @GetMapping("/select/all")
    public String showSelectAllUser(Model model) {
        model.addAttribute("users", userService.selectAllUsers());
        return "user/select/selectAll"; // user/select/selectAll.html
    }

    @GetMapping("/session/create")
    public String showSessionCreateForm(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }
        return "user/session/create";
    }

    @PostMapping("/session/create")
    public String createSessionUser(@ModelAttribute User user, HttpSession session) {
        if (session.getAttribute("user") != null)
            if (userService.authenticate(user.getUserName(), user.getPassword())) {
                session.setAttribute("user", user);
                return "redirect:/";
            }
        return "redirect:/user/session/create";
    }

    @GetMapping("session/delete")
    public String deleteSessionUser(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return "redirect:/";
        }
        return "user/session/create";
    }
}