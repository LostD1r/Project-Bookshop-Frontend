package com.bookshop.bookshop;

import com.bookshop.bookshop.Mappers.BookMapper;
import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BookShopApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        System.out.println(encoder.encode("pass"));

        BookDTO dto = new BookDTO(5L, "Тошнота", "фаіваціав", "dsfrwefd", 13.2, "asdfsd", null);
    }

}
