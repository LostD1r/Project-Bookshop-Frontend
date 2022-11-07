package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Bucket;
import com.bookshop.bookshop.models.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService{

    private final BookRepository bookRepository;
    private final PersonDetailsService personDetailsService;
    private final BucketService bucketService;

    public BookService(BookRepository bookRepository, PersonDetailsService personDetailsService, BucketService bucketService) {
        this.bookRepository = bookRepository;
        this.personDetailsService = personDetailsService;
        this.bucketService = bucketService;
    }


    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<Book> search(String str){
        return bookRepository.findByNameContainingIgnoreCase(str);
    }

    @javax.transaction.Transactional
    public void addToUserBucket(Long bookId, String username) {
        User user = personDetailsService.findByName(username);
        if(user == null){
            throw new RuntimeException("User not found. " + username);
        }

        Bucket bucket = user.getBucket();
        if(bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(bookId));
            user.setBucket(newBucket);
            personDetailsService.save(user);
        }
        else {
            bucketService.addProducts(bucket, Collections.singletonList(bookId));
        }
    }


    public void addBook(Book book) {

    }

    public List<Book> getLastAdded(){
        return bookRepository.findTop10ByOrderByCreatedDateDesc();
    }

    public List<Book> getTopBySales(){
        return bookRepository.findTop20ByOrderBySalesAmountDesc();
    }

    public Book getById(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        return book;
    }
}
