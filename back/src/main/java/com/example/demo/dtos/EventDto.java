package com.example.demo.dtos;

import java.time.LocalDateTime;

public class EventDto {
    private String title;
    private String colorId;
    private String location;
    private String status;//Example: "confirmed"
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    public EventDto(String title, String colorId, String location, String status, String description, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.colorId = colorId;
        this.location = location;
        this.status = status;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}