package com.example.demo.helpers;

import com.example.demo.domain.Event;
import com.example.demo.dto.EventDto;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public abstract class tools {
    public static LocalDateTime toLocalDateTime(EventDateTime eventDateTime){

        DateTime date = eventDateTime.getDateTime();
        if(date == null) date = eventDateTime.getDate();

        long timestamp = date.getValue();

        String timeZone = eventDateTime.getTimeZone();

        if(timeZone != null) return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getTimeZone(timeZone).toZoneId());

        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
    }
    public static EventDto toEventDto(Event event){
        return new EventDto(event.getTitle(), event.getColorId(), event.getLocation(), event.getStatus(), event.getDescription(), event.getStart(), event.getEnd());
    }

    public static Event toEvent(EventDto eventDto){
        return new Event(eventDto.getTitle(), eventDto.getColorId(), eventDto.getLocation(), eventDto.getStatus(), eventDto.getDescription(), eventDto.getStart(), eventDto.getEnd());
    }
}
