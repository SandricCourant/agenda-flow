package com.example.demo.controllers;

import com.example.demo.domain.Event;
import com.example.demo.dtos.EventDto;
import com.example.demo.exceptions.EventExistsException;
import com.example.demo.exceptions.EventNotFoundException;
import com.example.demo.exceptions.EventSyntaxException;
import com.example.demo.helpers.tools;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> listCategories() {

        Iterable<Event>eventI=eventService.getAll();
        List<Event> events= new ArrayList<>();
        eventI.forEach(events::add);

        List<EventDto> eventDtos= new ArrayList<>();

        events.forEach(val-> eventDtos.add(tools.toEventDto(val)));

        return ResponseEntity.status(HttpStatus.OK).body(eventDtos);

    }
    @PostMapping("/events")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto){
        Event eventCreate = tools.toEvent(eventDto);
        if (eventService.isError(eventCreate)) {
            throw new EventSyntaxException();
        }
        if(eventService.isExist(eventCreate)){
            throw new EventExistsException();
        }
        Event event = eventService.createEvent(eventCreate);
        EventDto res = tools.toEventDto(event);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto eventDto) throws EventNotFoundException {
        Event event = eventService.findById(id);

        if (event == null) throw new EventNotFoundException();

        event.setTitle(eventDto.getTitle());
        event.setColorId(eventDto.getColorId());
        event.setDescription(eventDto.getDescription());
        event.setLocation(eventDto.getLocation());
        event.setStart(eventDto.getStart());
        event.setEnd(eventDto.getEnd());
        eventService.createEvent(event);
        EventDto res = tools.toEventDto(event);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> cancel(@PathVariable("id") Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) throws EventNotFoundException {
        Event event = eventService.findById(id);
        if (event == null) {
            throw new EventNotFoundException();
        }

        EventDto res = tools.toEventDto(event);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
