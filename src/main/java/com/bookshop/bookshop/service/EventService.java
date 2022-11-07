package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.EventRepository;
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
}
