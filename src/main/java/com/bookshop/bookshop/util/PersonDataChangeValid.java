package com.bookshop.bookshop.util;

import com.bookshop.bookshop.dao.UserRepository;
import com.bookshop.bookshop.dto.PersonDataChangeDto;
import com.bookshop.bookshop.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonDataChangeValid implements Validator {

    private final UserRepository userRepository;

    public PersonDataChangeValid(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonDataChangeDto personDataChangeDto = (PersonDataChangeDto) target;
        User user = userRepository.findFirstByName(personDataChangeDto.getOldName());
        if(!personDataChangeDto.getOldName().equals(personDataChangeDto.getName()) &&
            !userRepository.findByName(personDataChangeDto.getName()).isEmpty()){
            errors.rejectValue("name", "", "Цей логін вже використовується. Спробуйте інший.");
        }
        if(!personDataChangeDto.getEmail().equals(user.getEmail()) &&
                !userRepository.findByEmail(personDataChangeDto.getEmail()).isEmpty()){
            errors.rejectValue("name", "", "Цей емайл вже використовується. Спробуйте інший.");
        }
    }
}
