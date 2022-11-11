package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.PublishingRepository;
import com.bookshop.bookshop.dto.PublishingDto;
import com.bookshop.bookshop.models.Author;
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

    public Publishing getByName(String publishingName) {
        return publishingRepository.getFirstByName(publishingName);
    }

    public Publishing getById(long id) {
        return publishingRepository.findById(id);
    }

    public void addPublishing(PublishingDto publishingDto) {
        Publishing newPublishing = Publishing.builder()
                .name(publishingDto.getName())
                .image(publishingDto.getImage())
                .description(publishingDto.getDescription())
                .build();
        publishingRepository.save(newPublishing);
    }

    public void updatePublishing(PublishingDto publishingDto, long id) {
        Publishing publishing = publishingRepository.findById(id);
        publishing.setDescription(publishingDto.getDescription());
        publishing.setName(publishingDto.getName());
        publishing.setImage(publishingDto.getImage());
        publishingRepository.save(publishing);
    }

    public void delete(long id) {
        publishingRepository.delete(publishingRepository.findById(id));
    }
}
