package com.example.demo.services.impl;

import com.example.demo.domain.Event;
import com.example.demo.repositories.EventRepository;
import com.example.demo.services.EventService;
import com.google.api.services.calendar.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;
    @Override
    public Iterable<Event> saveAll(Events events) {
        //To collect items of Google's events
        List<com.google.api.services.calendar.model.Event> items = events.getItems();

        Collection<Event> eventsData = new ArrayList<>();

        for(com.google.api.services.calendar.model.Event item : items){

            Event eventData = new Event();
            //Collect data
            eventData.setTitle(item.getSummary());
            eventData.setDescription(item.getDescription());
            eventData.setLocation(item.getLocation());

            eventData.setStatus(item.getStatus());
            eventData.setColorId(item.getColorId());

            eventData.setStart(item.getStart().getDateTime());
            eventData.setEnd(item.getEnd().getDateTime());
            eventsData.add(eventData);
        }
        return eventRepository.saveAll(eventsData);
    }

    public Iterable<Event> getAll(){
        return eventRepository.findAll();
    }

}
