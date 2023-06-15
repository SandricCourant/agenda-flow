package com.example.demo.services;

import com.example.demo.domain.Role;

import java.util.Collection;

public interface UserService {
    boolean isExistByUsername(String username);
    boolean isExistByEmail(String email);

    void create(String username, String email, String password, Collection<Role> roles);

}
