package com.example.demo.controllers;

import com.example.demo.domain.Event;
import com.example.demo.dto.EventDto;
import com.example.demo.exceptions.EventNotFoundException;
import com.example.demo.services.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> listCategories() {

        Iterable<Event>eventI=eventService.getAll();
        List<Event> events= new ArrayList<>();
        eventI.forEach(events::add);

        List<EventDto>eventDtos= new ArrayList<EventDto>();

        events.forEach(val->{
            eventDtos.add(val.toEventDto());
        });

        return ResponseEntity.status(HttpStatus.OK).body(eventDtos);

    }

    @PostMapping("/events")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto){
        Event event = eventService.createEvent(eventDto.toEvent());
        EventDto res = event.toEventDto();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/events/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto eventDto) throws EventNotFoundException {
        Event event = eventService.findById(id);
        System.out.println(event.toString());
        if (event == null) {
            throw new EventNotFoundException();
        }
        event.setTitle(eventDto.getTitle());
        event.setColorId(eventDto.getColorId());
        event.setDescription(eventDto.getDescription());
        event.setLocation(eventDto.getLocation());
        event.setStart(eventDto.getStart());
        event.setEnd(eventDto.getEnd());
        eventService.createEvent(event);
        EventDto res = event.toEventDto();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
