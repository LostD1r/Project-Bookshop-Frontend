package com.bookshop.bookshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "authors")
public class Author {
    private static final String SEQ_NAME = "author_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    @Column(length = 50)
    private String name;
    @Column(length = 600)
    private String description;
    @OneToMany(mappedBy = "author")
    private List<Book> book;
}
