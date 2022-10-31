package com.bookshop.bookshop.service;

import com.bookshop.bookshop.Mappers.AuthorMapper;
import com.bookshop.bookshop.dao.AuthorRepository;
import com.bookshop.bookshop.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService{
    private final AuthorMapper mapper = AuthorMapper.MAPPER;
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAll() {
        return mapper.fromAuthorList(authorRepository.findAll());
    }
}
