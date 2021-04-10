package com.example.practice14.controllers;

import com.example.practice14.dto.UserDto;
import com.example.practice14.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserControllers {

    @Autowired
    private UserDto userDto;

    private static int ID = 0;

    @PostMapping("/add")
    @ResponseBody
    public String addPost(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String middleName,
                          @RequestParam String birthDate) {
        User user = new User(ID++, firstName, lastName, middleName, birthDate);
        userDto.addUser(user);
        return "Post added";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deletePost(@RequestParam int id) {
        userDto.deleteUser(id);
        return "Post deleted";
    }

    @GetMapping("/get")
    @ResponseBody
    public String getPosts() {
        return userDto.getUsers();
    }
}
