package com.example.post.exception;

import com.example.post.exception.user.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // UserNotFoundException 처리
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException ex, Model model) {
        populateErrorModel(model, ex.getTitle(), ex.getMessage(), ex.getNotificationMessage());
        return "error/index"; // resources/templates/error/index.html로 이동
    }

    // PostNotFoundException 처리
    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFoundException(PostNotFoundException ex, Model model) {
        populateErrorModel(model, ex.getTitle(), ex.getMessage(), ex.getNotificationMessage());
        return "error/index"; // resources/templates/error/index.html로 이동
    }

    // IllegalArgumentException 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        populateErrorModel(model, "Invalid Argument", ex.getMessage(), null);
        return "error/index"; // resources/templates/error/index.html로 이동
    }

    // 중복 제거: 공통 에러 모델 설정
    private void populateErrorModel(Model model, String title, String errorMessage, String notificationMessage) {
        model.addAttribute("errorTitle", title);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("notificationMessage", notificationMessage);

    }
}