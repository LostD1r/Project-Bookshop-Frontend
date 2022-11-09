package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);

    Optional<User> findByName(String name);
    User findById(long id);

    Optional<User> findByEmail(String email);
}
