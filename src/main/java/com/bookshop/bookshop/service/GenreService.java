package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.GenreRepository;
import com.bookshop.bookshop.dto.GenreDto;
import com.bookshop.bookshop.models.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Genre> addFromString(String genres) {
        List<String> genresNames = List.of(genres.split(" "));
        List<Genre> genreList = new ArrayList<>();
        for(String name : genresNames){
            genreList.add(genreRepository.findByName(name));
        }
        return genreList;
    }

    public void addGenre(GenreDto genreDto) {
        Genre genre = Genre.builder()
                .name(genreDto.getName())
                .build();
        genreRepository.save(genre);
    }

    public void updateGenre(GenreDto genreDto, long id) {
        Genre genre = genreRepository.findById(id);
        genre.setName(genreDto.getName());
        genreRepository.save(genre);
    }

    public void delete(long id) {
        genreRepository.delete(genreRepository.findById(id));
    }

    public Genre getById(long id) {
        return genreRepository.getById(id);
    }

    public String fromListToString(List<Genre> genres) {
        String res = " ";
        for(Genre genre : genres){
            res += genre.getName() + " ";
        }
        return res;
    }
}
