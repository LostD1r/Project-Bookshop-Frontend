package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.CommentDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import com.bookshop.bookshop.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping("/catalog/book/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        bookService.addToUserBucket(id, principal.getName());
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/book/{id}/comment")
    public String newController(Principal principal, @PathVariable("id") Long id,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("book", bookService.getById(id));
            return "product-page";
        }
        String name = principal.getName();
        commentService.newComment(id, name, commentDto);
        return "redirect:/catalog/book/{id}";
    }
}
