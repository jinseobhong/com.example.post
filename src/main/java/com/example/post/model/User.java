package com.example.post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING) // Enum의 기본 타입은 숫자 형식이지만 문자 형식으로 표현하기 위해 type을 String으로 설정
    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
