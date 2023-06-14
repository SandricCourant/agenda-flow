package com.example.demo.dtos.request;

import com.example.demo.domain.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class SignupRequest {

    private Long id;
    private String username;
    private String email;
    private  String password;

    private Set<String> role;


}
