package com.example.demo.controllers;

import com.example.demo.domain.Event;
import com.example.demo.services.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/events")
    public ResponseEntity<Iterable<Event>> listCategories() {
        return ResponseEntity.ok(eventService.getAll()); // Sending a 200 HTTP status code
    }
}
