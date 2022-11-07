package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.NewsRepository;
import com.bookshop.bookshop.models.New;
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
}
