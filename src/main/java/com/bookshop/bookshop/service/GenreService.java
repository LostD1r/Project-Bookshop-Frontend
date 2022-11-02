package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.GenreRepository;
import com.bookshop.bookshop.models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll(){
        return genreRepository.findAll();
    }
}
