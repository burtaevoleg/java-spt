package com.example.practice16.controllers;

import com.example.practice16.services.UserService;
import com.example.practice16.tables.User;
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
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setBirthDate(birthDate);
        userService.addUser(user);
        return "Post added";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deletePost(@RequestParam int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public List<User> getPosts() {
        return userService.getUsers();
    }
}
