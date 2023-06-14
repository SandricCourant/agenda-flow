package com.example.demo.services.impl;

import com.example.demo.domain.ERole;
import com.example.demo.domain.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Set<Role> getRoles(Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        return roles;
    }
}
