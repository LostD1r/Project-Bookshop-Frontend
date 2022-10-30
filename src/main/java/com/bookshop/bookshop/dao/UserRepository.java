package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);

    Optional<User> findByName(String name);
}
