package com.bookshop.bookshop.Mappers;

import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.models.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    Book toBook(BookDTO dto);

    @InheritInverseConfiguration
    BookDTO fromBook(Book product);

    List<Book> toBookList(List<BookDTO> bookDTOS);

    List<BookDTO> fromBookList(List<Book> books);

}
