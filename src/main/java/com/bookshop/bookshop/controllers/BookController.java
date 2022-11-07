package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.CommentDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import com.bookshop.bookshop.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BookController {
    private final BookService bookService;
    private final CommentService commentService;

    public BookController(BookService bookService, CommentService commentService) {
        this.bookService = bookService;
        this.commentService = commentService;
    }

    @GetMapping("/catalog/book/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model){
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        model.addAttribute("comment", new CommentDto());
        return "product-page";
    }

    @GetMapping("/catalog/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if(principal == null){
            return "redirect:/products";
        }
        bookService.addToUserBucket(id, principal.getName());
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/{id}/comment")
    public String newController(Principal principal, @PathVariable("id") Long id,
                                @ModelAttribute("comment") CommentDto commentDto){
        String name = principal.getName();
        if (!commentService.newComment(id, name, commentDto)){
            return "redirect:/catalog/{id}";
        }
        return "redirect:/catalog/{id}";
    }
}
