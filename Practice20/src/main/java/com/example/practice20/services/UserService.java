package com.example.practice20.services;

import com.example.practice20.repositories.UserRepository;
import com.example.practice20.tables.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public String deleteUser(int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted";
        }
        return "Can not find user";
    }

    public List<User> getSortedUsersByFirstName(){
        return userRepository.findAll(Sort.by("firstName"));
    }

    public List<User> getSortedUsersByLastName(){
        return userRepository.findAll(Sort.by("lastName"));
    }

    public List<User> getSortedUsersByMiddleName(){
        return userRepository.findAll(Sort.by("middleName"));
    }

    public List<User> getSortedUsersByBirthDate(){
        return userRepository.findAll(Sort.by("birthDate"));
    }

}
