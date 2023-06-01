package com.example.demo.services.impl;

import com.example.demo.domain.Event;
import com.example.demo.exceptions.EventExistsException;
import com.example.demo.helpers.tools;
import com.example.demo.repositories.EventRepository;
import com.example.demo.services.EventService;
import com.google.api.services.calendar.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

            eventData.setStart(tools.toLocalDateTime(item.getStart()));
            eventData.setEnd(tools.toLocalDateTime(item.getEnd()));

            if(isExist(eventData)) throw new EventExistsException();//Si l'évenement existe déjà, lever une exception

            eventsData.add(eventData);
        }
        return eventRepository.saveAll(eventsData);
    }
    @Override
    public Iterable<Event> getAll(){
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
    @Override
    public boolean isExist(Event event){
        List<Event> events= new ArrayList<>();


        Iterable<Event> eventI = eventRepository.findAll();
        eventI.forEach(events::add);
        for(Event e: events){
            if((event.getStart().isAfter(e.getStart()) && event.getStart().isBefore(e.getEnd())) ||  event.getStart().equals(e.getStart())
                    || (event.getStart().isBefore(e.getEnd()) && event.getEnd().isAfter(e.getStart()))) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

}
