package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.AuthorRepository;
import com.bookshop.bookshop.dto.AuthorDto;
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

    public Author getById(long id) {
        return authorRepository.findById(id);
    }

    public void addAuthor(AuthorDto authorDto) {
        Author newAuthor = Author.builder()
                .name(authorDto.getName())
                .image(authorDto.getImage())
                .description(authorDto.getDescription())
                .build();
        authorRepository.save(newAuthor);
    }

    public void updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id);
        author.setDescription(authorDto.getDescription());
        author.setName(authorDto.getName());
        author.setImage(authorDto.getImage());
        authorRepository.save(author);
    }

    public void delete(long id) {
        Author author = authorRepository.findById(id);
        authorRepository.delete(author);
    }
}
