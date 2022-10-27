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
@Table(name = "authors")
public class Author {
    private static final String SEQ_NAME = "author_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "author")
    private List<Book> book;
}
