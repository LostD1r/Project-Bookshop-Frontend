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
@Table(name = "publishing")
public class Publishing {
    private static final String SEQ_NAME = "publishing_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    private String name;
    @Column(length = 600)
    private String description;
    @OneToMany(mappedBy = "publishing")
    private List<Book> books;
    private String image;
}
