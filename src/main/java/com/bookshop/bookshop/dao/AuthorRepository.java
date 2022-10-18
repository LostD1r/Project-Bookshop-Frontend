package com.bookshop.bookshop.dao;


import com.bookshop.bookshop.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
