package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAll();
    void addToUserBucket(Long bookId, String username);
    void addBook(BookDTO dto);
    BookDTO getById(Long id);
}
