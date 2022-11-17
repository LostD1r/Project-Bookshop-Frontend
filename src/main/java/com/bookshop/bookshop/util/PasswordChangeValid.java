package com.bookshop.bookshop.util;

import com.bookshop.bookshop.dao.UserRepository;
import com.bookshop.bookshop.dto.PasswordDto;
import com.bookshop.bookshop.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordChangeValid implements Validator {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordChangeValid(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordDto passwordDto = (PasswordDto) target;
        User user = userRepository.findFirstByName(passwordDto.getUsername());
        if(!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())){
            errors.rejectValue("oldPassword", "", "Неправильний старий пароль. Спробуйте ще раз.");
        }
        if(!passwordDto.getNewPassword().equals(passwordDto.getMatchingNewPassword())){
            errors.rejectValue("newPassword", "", "Нові паролі не співпадають. Спробуйте ще раз.");
        }
        if(passwordEncoder.matches(passwordDto.getNewPassword(), user.getPassword())){
            errors.rejectValue("newPassword", "", "Новий пароль співпадає зі старим. Спробуйте ще раз.");
        }
    }
}
