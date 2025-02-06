package com.example.projectplzwork.utils;

import com.example.projectplzwork.entities.Role;
import com.example.projectplzwork.entities.User;

public class UserFactory {
    public static User createUser(String name, String email, String password, String phone, Role role) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phone(phone)
                .role(role)
                .build();
    }
}
