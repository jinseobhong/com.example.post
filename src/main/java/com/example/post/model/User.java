package com.example.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
