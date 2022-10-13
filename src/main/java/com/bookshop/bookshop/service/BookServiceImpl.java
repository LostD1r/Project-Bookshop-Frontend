package com.bookshop.bookshop.service;

import com.bookshop.bookshop.Mappers.BookMapper;
import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookMapper mapper = BookMapper.MAPPER;

    private final BookRepository bookRepository;
    private final UserService userService;

    public BookServiceImpl(BookRepository bookRepository, UserService userService) {
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    @Override
    public List<BookDTO> getAll() {
        return mapper.fromBookList(bookRepository.findAll());
    }

    @Override
    public void addToUserBucket(Long bookId, String username) {

    }

    @Override
    public void addBook(BookDTO dto) {

    }

    @Override
    public BookDTO getById(Long id) {
        return null;
    }
}
