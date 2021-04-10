package com.example.practice14.dto;

import com.example.practice14.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDto {
    private final List<User> users= new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(int id){
        users.removeIf( post -> post.getId() == id);
    }

    public String getUsers() {
        return users.toString();
    }
}
