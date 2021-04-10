package com.example.practice14.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Post {
    private int id;
    private String text;
    private String creationDate;
}
