package com.bookshop.bookshop.Mappers;

import com.bookshop.bookshop.dto.AuthorDTO;
import com.bookshop.bookshop.models.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

    List<AuthorDTO> fromAuthorList(List<Author> authors);
}
