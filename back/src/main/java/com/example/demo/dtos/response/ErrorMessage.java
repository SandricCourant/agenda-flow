package com.example.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int code;
    private Date date;
    private String message;
    private String description;
}
