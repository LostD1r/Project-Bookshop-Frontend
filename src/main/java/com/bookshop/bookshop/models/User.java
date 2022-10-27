package com.bookshop.bookshop.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private long id;
    @Column(unique = true)
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Bucket bucket;
}
