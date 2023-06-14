package com.example.demo.services;

import com.example.demo.domain.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    boolean isExistByUsername(String username);
    boolean isExistByEmail(String email);

    void create(String username, String email, String password, Set<Role> roles);

}
