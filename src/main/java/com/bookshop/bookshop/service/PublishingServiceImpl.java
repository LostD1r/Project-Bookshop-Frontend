package com.bookshop.bookshop.service;

import com.bookshop.bookshop.Mappers.PublishingMapper;
import com.bookshop.bookshop.dao.PublishingRepository;
import com.bookshop.bookshop.dto.PublishingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingServiceImpl implements PublishingService {
    private final PublishingMapper mapper = PublishingMapper.MAPPER;
    private final PublishingRepository publishingRepository;

    public PublishingServiceImpl(PublishingRepository publishingRepository) {
        this.publishingRepository = publishingRepository;
    }

    @Override
    public List<PublishingDTO> getAll() {
        return mapper.fromPublishingList(publishingRepository.findAll());
    }
}
