package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}