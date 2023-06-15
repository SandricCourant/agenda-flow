package com.example.demo.dtos.request;

import lombok.Data;

import java.util.Collection;

@Data
public class SignupRequest {

    private Long id;
    private String username;
    private String email;
    private  String password;

    private Collection<String> roles;


}
