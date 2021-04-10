package com.example.practice24.controllers;

import com.example.practice24.services.UserService;
import com.example.practice24.tables.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public String addPost(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String middleName,
                          @RequestParam String birthDate) {
        Users users = new Users();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setMiddleName(middleName);
        users.setBirthDate(birthDate);
        userService.addUser(users);
        return "Post added";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deletePost(@RequestParam int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Users> getPosts() {
        return userService.getUsers();
    }

    @GetMapping("/get/sortedByFirstName")
    @ResponseBody
    public List<Users> getSortedUsersByFirstName(){
        return userService.getSortedUsersByFirstName();
    }

    @GetMapping("/get/sortedByLastName")
    @ResponseBody
    public List<Users> getSortedUsersByLastName(){
        return userService.getSortedUsersByLastName();
    }

    @GetMapping("/get/sortedByMiddleName")
    @ResponseBody
    public List<Users> getSortedUsersByMiddleName(){
        return userService.getSortedUsersByMiddleName();
    }

    @GetMapping("/get/sortedByBirthDate")
    @ResponseBody
    public List<Users> getSortedUsersByBirthDate(){
        return userService.getSortedUsersByBirthDate();
    }
}
