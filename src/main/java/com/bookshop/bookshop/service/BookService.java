package com.bookshop.bookshop.service;

import com.bookshop.bookshop.Mappers.BookMapper;
import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    private final BookMapper mapper = BookMapper.MAPPER;

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookDTO> getAll() {
        return mapper.fromBookList(bookRepository.findAll());
    }


    public void addToUserBucket(Long bookId, String username) {

    }


    public void addBook(BookDTO dto) {

    }


    public BookDTO getById(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        return BookMapper.MAPPER.fromBook(book);
    }
}
