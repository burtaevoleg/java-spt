package com.example.practice19.services;

import com.example.practice19.repositories.UserRepository;
import com.example.practice19.tables.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        log.info("Get all users");
        return userRepository.findAll();
    }

    public void addUser(User user){
        log.info("Add user");
        userRepository.save(user);
    }

    public String deleteUser(int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            log.debug("Delete user");
            return "User deleted";
        }
        log.error("Delete user. Can not find user");
        return "Can not find user";
    }

    public List<User> getSortedUsersByFirstName(){
        log.info("Get sorted users by first_name");
        return userRepository.findAll(Sort.by("firstName"));
    }

    public List<User> getSortedUsersByLastName(){
        log.info("Get sorted users by last_name");
        return userRepository.findAll(Sort.by("lastName"));
    }

    public List<User> getSortedUsersByMiddleName(){
        log.info("Get sorted users by middle_name");
        return userRepository.findAll(Sort.by("middleName"));
    }

    public List<User> getSortedUsersByBirthDate(){
        log.info("Get sorted users by birth_date");
        return userRepository.findAll(Sort.by("birthDate"));
    }

}
