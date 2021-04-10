package com.example.practice13;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    @PostConstruct
    private void init(){
        System.out.println("My name: " + name + ", my last name: " + last_name + ", my group: " + group);
    }
}
