package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dao.BucketRepository;
import com.bookshop.bookshop.dto.BucketDTO;
import com.bookshop.bookshop.dto.BucketDetailDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Bucket;
import com.bookshop.bookshop.models.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BucketService {

    private final BookRepository bookRepository;
    private final BucketRepository bucketRepository;
    private final PersonDetailsService personDetailsService;

    public BucketService(BookRepository bookRepository, BucketRepository bucketRepository, PersonDetailsService personDetailsService) {
        this.bookRepository = bookRepository;
        this.bucketRepository = bucketRepository;
        this.personDetailsService = personDetailsService;
    }

    @javax.transaction.Transactional
    public Bucket createBucket(User user, List<Long> booksIds) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Book> bookList = getCollectRefProductsByIds(booksIds);
        bucket.setBooks(bookList);
        return bucketRepository.save(bucket);
    }

    private List<Book> getCollectRefProductsByIds(List<Long> productIds) {
        return productIds.stream()
                .map(bookRepository::getOne)
                .collect(Collectors.toList());
    }

    @javax.transaction.Transactional
    public void addProducts(Bucket bucket, List<Long> booksIds) {
        List<Book> books = bucket.getBooks();
        List<Book> newBooksList = books == null ? new ArrayList<>() : new ArrayList<>(books);
        newBooksList.addAll(getCollectRefProductsByIds(booksIds));
        bucket.setBooks(newBooksList);
        bucketRepository.save(bucket);
    }

    public BucketDTO getBucketByUser(String name) {
        User user = personDetailsService.findByName(name);
        if(user == null || user.getBucket() == null){
            return new BucketDTO();
        }

        BucketDTO bucketDto = new BucketDTO();
        Map<Long, BucketDetailDto> mapByProductId = new HashMap<>();

        List<Book> books = user.getBucket().getBooks();
        for (Book book : books) {
            BucketDetailDto detail = mapByProductId.get(book.getId());
            if(detail == null){
                mapByProductId.put(book.getId(), new BucketDetailDto(book));
            }
            else {
                detail.setAmount(detail.getAmount() + 1.0);
                detail.setSum(detail.getSum() + book.getPrice());
            }
        }

        bucketDto.setBucketDetails(new ArrayList<>(mapByProductId.values()));
        bucketDto.aggregate();

        return bucketDto;
    }

    @javax.transaction.Transactional
    public void removeBook(long id, String name){
        User user = personDetailsService.findByName(name);
        Bucket bucket = user.getBucket();
        Book book = bookRepository.findById(id);
        bucket.getBooks().remove(bucket.getBooks().indexOf(book));
        bucketRepository.save(bucket);
    }
}
