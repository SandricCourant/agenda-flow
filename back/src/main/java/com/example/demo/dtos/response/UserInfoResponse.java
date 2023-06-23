package com.example.demo.dtos.response;

import com.example.demo.domain.Role;
import com.example.demo.dtos.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
