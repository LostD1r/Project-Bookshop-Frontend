package com.bookshop.bookshop.dao;


import com.bookshop.bookshop.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findFirstByName(String authorName);
    Author findById(long id);
}
