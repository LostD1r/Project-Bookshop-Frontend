package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.EventRepository;
import com.bookshop.bookshop.dto.EventDto;
import com.bookshop.bookshop.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll(){
        return eventRepository.findAll();
    }

    public void addEvent(EventDto eventDto) {
        Event event = Event.builder()
                .title(eventDto.getTitle())
                .message(eventDto.getMessage())
                .build();
        eventRepository.save(event);
    }

    public void updateEvent(EventDto eventDto, long id) {
        Event event = eventRepository.findById(id);
        event.setTitle(eventDto.getTitle());
        event.setMessage(eventDto.getMessage());
        eventRepository.save(event);
    }

    public void delete(long id) {
        eventRepository.delete(eventRepository.findById(id));
    }

    public Event getById(long id) {
        return eventRepository.getById(id);
    }
}
