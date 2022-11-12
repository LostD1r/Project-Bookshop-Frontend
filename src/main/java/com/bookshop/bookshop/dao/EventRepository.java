package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findById(long id);
}
