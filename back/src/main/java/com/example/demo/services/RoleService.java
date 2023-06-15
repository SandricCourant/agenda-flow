package com.example.demo.services;

import com.example.demo.domain.Role;

import java.util.Collection;

public interface RoleService {
    Collection<Role> getRoles(Collection<String> strRoles);
}
