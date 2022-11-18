package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {
    private final BookService bookService;

    public AdminBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/new")
    public String getBookForm(Model model){
        model.addAttribute("book", new BookDto());
        return "admin";
    }

    @PostMapping("/new")
    public String addNewBook(@PathVariable("book") BookDto bookDto){
        bookService.addBook(bookDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id,Model model){
        model.addAttribute("book", new BookDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        BookDto bookDto = (BookDto) model.getAttribute("book");
        bookService.updateBook(bookDto, id);
        return "redirect:/admin/book";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        bookService.delete(id);
        return "redirect:/admin";
    }
}
