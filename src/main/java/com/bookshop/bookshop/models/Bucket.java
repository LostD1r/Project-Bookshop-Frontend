package com.bookshop.bookshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "buckets")
public class Bucket {
    private static final String SEQ_NAME = "bucket_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable(name = "bucket_books",
        joinColumns = @JoinColumn(name = "bucket_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
