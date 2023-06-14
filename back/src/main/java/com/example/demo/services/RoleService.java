package com.example.demo.services;

import com.example.demo.domain.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoles(Set<String> strRoles);
}
