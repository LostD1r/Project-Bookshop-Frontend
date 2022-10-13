package com.bookshop.bookshop.dto;

import com.bookshop.bookshop.models.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    private String name;
    private String description;
    private String characteristic;
    private Double price;
    private String image;
    private Author author;
}
