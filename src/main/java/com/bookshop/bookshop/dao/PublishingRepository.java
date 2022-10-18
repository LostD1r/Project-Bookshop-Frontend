package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingRepository extends JpaRepository<Publishing, Long> {
}
