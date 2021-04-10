package com.example.practice22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Practice22Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice22Application.class, args);
    }

}