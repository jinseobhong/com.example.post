package com.example.post.exception;

public class PostNotFoundException extends DefaultException {
    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String title, String message) {
        super(title, message);
    }

    public PostNotFoundException(String title, String message, String notificationMessage) {
        super(title, message, notificationMessage);
    }
}