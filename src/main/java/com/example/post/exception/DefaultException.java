package com.example.post.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultException extends RuntimeException {
    private String title;
    private String message;
    private String notificationMessage;

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public DefaultException(String title, String message, String notificationMessage) {
        this.title = title;
        this.message = message;
        this.notificationMessage = notificationMessage;
    }
}