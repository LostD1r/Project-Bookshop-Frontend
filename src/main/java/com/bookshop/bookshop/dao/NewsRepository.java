package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<New, Long> {
    New findById(long id);
}
