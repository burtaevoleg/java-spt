package com.example.practice21.services;

import com.example.practice21.repositories.UserRepository;
import com.example.practice21.tables.User;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = true)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(User user){
        emailService.sendMail("Add new user","Add new user, first name: " + user.getFirstName()
                + ", last name: " + user.getLastName());
        userRepository.save(user);
    }

    @Transactional
    public String deleteUser(int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted";
        }
        return "Can not find user";
    }

    @Transactional(readOnly = true)
    public List<User> getSortedUsersByFirstName(){
        return userRepository.findAll(Sort.by("firstName"));
    }

    @Transactional(readOnly = true)
    public List<User> getSortedUsersByLastName(){
        return userRepository.findAll(Sort.by("lastName"));
    }

    @Transactional(readOnly = true)
    public List<User> getSortedUsersByMiddleName(){
        return userRepository.findAll(Sort.by("middleName"));
    }

    @Transactional(readOnly = true)
    public List<User> getSortedUsersByBirthDate(){
        return userRepository.findAll(Sort.by("birthDate"));
    }

}
