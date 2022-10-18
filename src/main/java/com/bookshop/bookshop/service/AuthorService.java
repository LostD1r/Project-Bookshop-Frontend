package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dto.AuthorDTO;
import org.springframework.context.annotation.Bean;


import java.util.List;
public interface AuthorService {
    List<AuthorDTO> getAll();
}
