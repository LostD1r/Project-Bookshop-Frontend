package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.UserRepository;
import com.bookshop.bookshop.dto.ChangeUserRoleDto;
import com.bookshop.bookshop.dto.PasswordDto;
import com.bookshop.bookshop.dto.PersonDataChangeDto;
import com.bookshop.bookshop.models.Role;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public PersonDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> person = userRepository.findByName(s);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(person.get());
    }

    public User findByName(String username) {
        return userRepository.findFirstByName(username);
    }
    public Optional<User> optionalFindByName(String username) {
        return userRepository.findByName(username);
    }
    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void updateUserRole(ChangeUserRoleDto changeUserRoleDto, long id) {
        User user = userRepository.findById(id);
        user.setRole(Role.valueOf(changeUserRoleDto.getRole()));
        userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(userRepository.findById(id));
    }

    public void changeUserData(String username, PersonDataChangeDto personDataChangeDto) {
        User user = userRepository.findFirstByName(username);
        user.setName(personDataChangeDto.getName());
        user.setAbout(personDataChangeDto.getAbout());
        user.setEmail(personDataChangeDto.getEmail());
        userRepository.save(user);

    }
}

