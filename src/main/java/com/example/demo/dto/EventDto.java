package com.example.demo.dto;

import com.google.api.client.util.DateTime;
import jakarta.persistence.Column;

public class EventDto {
    private String title;
    private String colorId;
    private String location;
    private String status;//Example: "confirmed"
    private String description;
    private DateTime start;
    private DateTime end;
}
