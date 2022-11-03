package com.bookshop.bookshop.dto;

import com.bookshop.bookshop.models.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDetailDto {
    private String title;
    private String img;
    private String author;
    private Long productId;
    private Double price;
    private Double amount;
    private Double sum;

    public BucketDetailDto(Book book){
        this.title = book.getName();
        this.productId = book.getId();
        this.price = book.getPrice();
        this.amount = 1.0;
        this.sum = book.getPrice();
        this.img = book.getImage();
        this.author = book.getAuthor().getName();
    }
}
