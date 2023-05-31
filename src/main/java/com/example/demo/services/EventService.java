package com.example.demo.services;

import com.example.demo.domain.Event;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Events;

import java.util.Collection;

public interface EventService {
    Iterable<Event> saveAll(Events events);
    Iterable<Event> getAll();

    Event createEvent(Event event);

    Event findById(Long id);


}
