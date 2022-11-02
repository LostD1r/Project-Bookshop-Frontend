package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
