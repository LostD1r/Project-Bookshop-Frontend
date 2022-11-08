package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.AuthorRepository;
import com.bookshop.bookshop.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService{
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        List<Author> list = authorRepository.findAll();
        return list;
    }

    public Author getByName(String authorName) {
        return authorRepository.findFirstByName(authorName);
    }
}
