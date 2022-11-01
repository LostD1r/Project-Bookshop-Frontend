package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAll() {
        return bookRepository.findAll();
    }


    public void addToUserBucket(Long bookId, String username) {

    }


    public void addBook(Book book) {

    }


    public Book getById(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        return book;
    }
}
