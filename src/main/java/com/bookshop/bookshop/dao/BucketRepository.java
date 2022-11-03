package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long> {

}
