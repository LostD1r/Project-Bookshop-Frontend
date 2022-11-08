package com.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String name;
    private String englishName;
    private String description;
    private String characteristic;
    private Double price;
    private String authorName;
    private String genres;
    private String publishingName;
    private String image;
    private Long shopAmount;
    private Long salesAmount;
}
