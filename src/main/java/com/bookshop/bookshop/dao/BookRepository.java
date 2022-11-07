package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String substr);
    Book findById(long id);

    List<Book> findTop20ByOrderBySalesAmountDesc();

    List<Book> findTop10ByOrderByCreatedDateDesc();
}