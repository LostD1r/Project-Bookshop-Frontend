package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dao.CommentRepository;
import com.bookshop.bookshop.dao.UserRepository;
import com.bookshop.bookshop.dto.CommentDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Comment;
import com.bookshop.bookshop.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;;

    public CommentService(CommentRepository commentRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public boolean newComment(Long id, String name, CommentDto message){
        Book book = bookRepository.getById(id);
        User user = userRepository.findFirstByName(name);
        if (message == null || book == null){
            return false;
        }
        Comment comment = new Comment();
        comment.setBook(book);
        comment.setUser(user);
        comment.setMessage(message.getMassage());
        commentRepository.save(comment);
        return true;
    }
}
