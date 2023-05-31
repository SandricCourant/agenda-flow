package com.cda.AgendaFlow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/events")
    public ResponseEntity<String> event() {
        return ResponseEntity.ok("coucou");
    }
}
