package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepository extends JpaRepository<Publishing, Long> {
    Publishing getFirstByName(String publishingName);
    Publishing findById(long id);
}
