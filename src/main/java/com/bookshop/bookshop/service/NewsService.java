package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.NewsRepository;
import com.bookshop.bookshop.dto.NewDto;
import com.bookshop.bookshop.models.New;
import com.bookshop.bookshop.models.Publishing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<New> getNews(){
        return newsRepository.findAll();
    }

    public void addNew(NewDto newDto) {
        New newNew = New.builder()
                .title(newDto.getTitle())
                .image(newDto.getImage())
                .message(newDto.getMessage())
                .build();
        newsRepository.save(newNew);
    }


    public void updateNew(NewDto newDto, long id) {
        New aNew = newsRepository.findById(id);
        aNew.setMessage(newDto.getMessage());
        aNew.setTitle(newDto.getTitle());
        aNew.setImage(newDto.getImage());
        newsRepository.save(aNew);
    }

    public void delete(long id) {
        newsRepository.delete(newsRepository.findById(id));
    }

    public New getById(long id) {
        return newsRepository.getById(id);
    }
}
