package com.example.demo.dto;

import com.example.demo.domain.Event;
import com.google.api.client.util.DateTime;
import jakarta.persistence.Column;
import jdk.jfr.DataAmount;


public class EventDto {
    private String title;
    private String colorId;
    private String location;
    private String status;//Example: "confirmed"
    private String description;
    private DateTime start;
    private DateTime end;

    public EventDto(String title, String colorId, String location, String status, String description, DateTime start, DateTime end) {
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

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Event toEvent(){
        return new Event( this.title, this.colorId, this.location,this.status,this.description,this.start,this.end);
    }
}
