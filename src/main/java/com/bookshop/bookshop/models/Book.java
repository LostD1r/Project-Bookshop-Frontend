package com.bookshop.bookshop.models;

import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
public class Book {
    private static final String SEQ_NAME = "book_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    private String name;
    private String description;
    private String characteristic;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @ManyToMany
    @JoinTable(name = "books_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Genre> genres;
    @ManyToOne
    @JoinColumn(name = "publishing_id", referencedColumnName = "id")
    private Publishing publishing;
    private String image;

    @OneToMany(mappedBy = "book")
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;
}
