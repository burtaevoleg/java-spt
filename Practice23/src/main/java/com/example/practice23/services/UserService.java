package com.example.practice23.services;

import com.example.practice23.repositories.UserRepository;
import com.example.practice23.tables.Users;
import lombok.RequiredArgsConstructor;
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
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(Users users){
        emailService.sendMail("Add new user","Add new user, first name: " + users.getFirstName()
                + ", last name: " + users.getLastName());
        userRepository.save(users);
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
    public List<Users> getSortedUsersByFirstName(){
        return userRepository.findAll(Sort.by("firstName"));
    }

    @Transactional(readOnly = true)
    public List<Users> getSortedUsersByLastName(){
        return userRepository.findAll(Sort.by("lastName"));
    }

    @Transactional(readOnly = true)
    public List<Users> getSortedUsersByMiddleName(){
        return userRepository.findAll(Sort.by("middleName"));
    }

    @Transactional(readOnly = true)
    public List<Users> getSortedUsersByBirthDate(){
        return userRepository.findAll(Sort.by("birthDate"));
    }

}
