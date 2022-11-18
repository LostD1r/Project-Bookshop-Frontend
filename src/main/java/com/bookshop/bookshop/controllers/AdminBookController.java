package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.service.BookService;
import com.bookshop.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {
    private final BookService bookService;
    private final GenreService genreService;

    public AdminBookController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping("/new")
    public String getBookForm(Model model){
        model.addAttribute("book", new BookDto());
        return "admin/add-book-list";
    }

    @PostMapping("/new")
    public String addNewBook(@ModelAttribute("book") BookDto bookDto){
        bookService.addBook(bookDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id,Model model){
        Book book = bookService.getById(id);
        List<Genre> genres = book.getGenres();
        String stringGenres = genreService.fromListToString(genres);
        BookDto bookDto = BookDto.builder()
                .name(book.getName())
                .image(book.getImage())
                .description(book.getDescription())
                .authorName(book.getAuthor().getName())
                .characteristic(book.getCharacteristic())
                .englishName(book.getEnglishName())
                .price(book.getPrice())
                .publishingName(book.getPublishing().getName())
                .shopAmount(book.getShopAmount())
                .genres(stringGenres)
                .build();
        model.addAttribute("book", bookDto);
        model.addAttribute("id", id);
        return "admin/change-book-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("book") BookDto bookDto){
        bookService.updateBook(bookDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        bookService.delete(id);
        return "redirect:/admin";
    }
}
