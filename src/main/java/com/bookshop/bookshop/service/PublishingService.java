package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.PublishingRepository;
import com.bookshop.bookshop.models.Publishing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingService{
    private final PublishingRepository publishingRepository;

    public PublishingService(PublishingRepository publishingRepository) {
        this.publishingRepository = publishingRepository;
    }

    public List<Publishing> getAll() {
        return publishingRepository.findAll();
    }
}
