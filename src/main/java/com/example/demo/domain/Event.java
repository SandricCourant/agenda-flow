package com.example.demo.domain;

import com.example.demo.dto.EventDto;
import com.google.api.client.util.DateTime;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String colorId;
    private String location;
    private String status;//Example: "confirmed"
    private String description;

    @Column(name = "event_start")
    private DateTime start;

    @Column(name = "event_end")
    private DateTime end;

    public Event() {

    }

    public Event(String title, String colorId, String location, String status, String description, DateTime start, DateTime end) {
        this.title = title;
        this.colorId = colorId;
        this.location = location;
        this.status = status;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
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

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventDto toEventDto(){
        return new EventDto(this.title, this.colorId, this.location,this.status,this.description,this.start,this.end);
    }
}