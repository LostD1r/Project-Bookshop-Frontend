package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.UserRepository;
import com.bookshop.bookshop.dto.PasswordDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.ArrayList;

import static com.bookshop.bookshop.models.Role.ROLE_USER;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean save(UserDTO user){
        User userFromDB = userRepository.findFirstByName(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        System.out.println(555);
        User newUser = User.builder()
                .name(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .role(ROLE_USER)
                .about("Про себе...")
                .books(new ArrayList<Book>())
                .build();
        userRepository.save(newUser);
        return true;
    }

    @javax.transaction.Transactional
    public boolean changePassword(String name, PasswordDto passwordDto){
        User user = userRepository.findFirstByName(name);
        System.out.println(1);
        user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
        userRepository.save(user);
        return true;
    }
}
