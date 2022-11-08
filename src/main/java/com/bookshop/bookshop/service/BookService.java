package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Bucket;
import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.models.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService{

    private final BookRepository bookRepository;
    private final PersonDetailsService personDetailsService;
    private final BucketService bucketService;
    private final AuthorService authorService;
    private final PublishingService publishingService;
    private final GenreService genreService;

    public BookService(BookRepository bookRepository, PersonDetailsService personDetailsService, BucketService bucketService, AuthorService authorService, PublishingService publishingService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.personDetailsService = personDetailsService;
        this.bucketService = bucketService;
        this.authorService = authorService;
        this.publishingService = publishingService;
        this.genreService = genreService;
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


    @javax.transaction.Transactional
    public void addBook(BookDto bookDto) {
        List<Genre> genres = genreService.addFromString(bookDto.getGenres());

        Book newBook = Book.builder()
                .name(bookDto.getName())
                .author(authorService.getByName(bookDto.getAuthorName()))
                .characteristic(bookDto.getCharacteristic())
                .description(bookDto.getDescription())
                .image(bookDto.getImage())
                .englishName(bookDto.getEnglishName())
                .price(bookDto.getPrice())
                .publishing(publishingService.getByName(bookDto.getPublishingName()))
                .salesAmount(bookDto.getSalesAmount())
                .shopAmount(bookDto.getShopAmount())
                .genres(genres)
                .build();
        bookRepository.save(newBook);
    }

    public void delete(long id){
        Book book = bookRepository.findById(id);
        bookRepository.delete(book);
    }

    @javax.transaction.Transactional
    public void updateBook(BookDto bookDto, long id) {
        List<Genre> genres = genreService.addFromString(bookDto.getGenres());


        Book newBook = Book.builder()
                .name(bookDto.getName())
                .author(authorService.getByName(bookDto.getAuthorName()))
                .characteristic(bookDto.getCharacteristic())
                .description(bookDto.getDescription())
                .image(bookDto.getImage())
                .englishName(bookDto.getEnglishName())
                .price(bookDto.getPrice())
                .publishing(publishingService.getByName(bookDto.getPublishingName()))
                .salesAmount(bookDto.getSalesAmount())
                .shopAmount(bookDto.getShopAmount())
                .genres(genres)
                .build();
        bookRepository.save(newBook);
    }

    public void save(Book book){
        bookRepository.save(book);
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
