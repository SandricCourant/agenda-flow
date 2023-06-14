package com.example.demo.services.impl;

import com.example.demo.domain.Owner;
import com.example.demo.domain.Role;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isExistByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void create(String username, String email, String password, Set<Role> roles) {

        // Create new user's account
        Owner user = new Owner(username, email, encoder.encode(password));
        user.setRoles(roles);

        userRepository.save(user);

    }
}
